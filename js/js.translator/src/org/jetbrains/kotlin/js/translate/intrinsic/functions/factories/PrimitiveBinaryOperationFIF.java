/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.js.translate.intrinsic.functions.factories;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.dart.compiler.backend.js.ast.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.builtins.KotlinBuiltIns;
import org.jetbrains.kotlin.descriptors.FunctionDescriptor;
import org.jetbrains.kotlin.js.patterns.DescriptorPredicate;
import org.jetbrains.kotlin.js.patterns.NamePredicate;
import org.jetbrains.kotlin.js.translate.context.Namer;
import org.jetbrains.kotlin.js.translate.context.TranslationContext;
import org.jetbrains.kotlin.js.translate.intrinsic.functions.basic.FunctionIntrinsic;
import org.jetbrains.kotlin.js.translate.intrinsic.functions.basic.RangeToIntrinsic;
import org.jetbrains.kotlin.js.translate.operation.OperatorTable;
import org.jetbrains.kotlin.js.translate.utils.JsAstUtils;
import org.jetbrains.kotlin.lexer.KtToken;
import org.jetbrains.kotlin.name.Name;
import org.jetbrains.kotlin.types.expressions.OperatorConventions;
import org.jetbrains.kotlin.util.OperatorNameConventions;

import java.util.List;

import static org.jetbrains.kotlin.js.patterns.PatternBuilder.pattern;

public enum PrimitiveBinaryOperationFIF implements FunctionIntrinsicFactory {
    INSTANCE;

    private static abstract class BinaryOperationIntrinsicBase extends FunctionIntrinsic {
        @NotNull
        public abstract JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context);

        @NotNull
        @Override
        public JsExpression apply(
                @Nullable JsExpression receiver,
                @NotNull List<JsExpression> arguments,
                @NotNull TranslationContext context) {
            assert receiver != null;
            assert arguments.size() == 1;
            return doApply(receiver, arguments.get(0), context);
        }
    }

    private static final BinaryOperationIntrinsicBase INT_MULTIPLICATION_INTRINSIC = new BinaryOperationIntrinsicBase() {
        // IEEE 754 mantissa is 52 bits long. Assuming one argument may be up to 2^31, the second argument should be
        // not greater than 2^21 in order their product don't exceed 2^52. We preserve two extra bits to be more safe.
        private static final int SAFE_THRESHOLD = 2 << 19;

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            if (isSafeConstant(left) || isSafeConstant(right)) {
                return JsAstUtils.toInt32(JsAstUtils.mul(left, right));
            }
            return new JsInvocation(Namer.imul(), left, right);
        }

        private boolean isSafeConstant(@NotNull JsExpression expression) {
            if (!(expression instanceof JsNumberLiteral.JsIntLiteral)) return false;
            int value = ((JsNumberLiteral.JsIntLiteral) expression).value;
            return Math.abs(value) < SAFE_THRESHOLD;
        }
    };

    @NotNull
    private static final BinaryOperationIntrinsicBase BUILTINS_COMPARE_TO_INTRINSIC = new BinaryOperationIntrinsicBase() {
        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return JsAstUtils.compareTo(left, right);
        }
    };

    @NotNull
    private static final BinaryOperationIntrinsicBase PRIMITIVE_NUMBER_COMPARE_TO_INTRINSIC = new BinaryOperationIntrinsicBase() {
        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return JsAstUtils.primitiveCompareTo(left, right);
        }
    };

    @NotNull
    private static final NamePredicate BINARY_OPERATIONS = new NamePredicate(OperatorNameConventions.BINARY_OPERATION_NAMES);

    private static final DescriptorPredicate INT_BINARY_OPERATIONS = pattern("Int.plus|minus(Int)");
    private static final DescriptorPredicate SIMPLE_INT_MULTIPLICATION = pattern("Byte|Short.times(Byte|Short)");
    private static final DescriptorPredicate INT_DIVISION = pattern("Byte|Short|Int.div(Byte|Short|Int)");
    private static final DescriptorPredicate PRIMITIVE_NUMBERS_BINARY_OPERATIONS =
            pattern(NamePredicate.PRIMITIVE_NUMBERS_MAPPED_TO_PRIMITIVE_JS, BINARY_OPERATIONS);

    private static final DescriptorPredicate PRIMITIVE_NUMBERS_COMPARE_TO_OPERATIONS =
            pattern(NamePredicate.PRIMITIVE_NUMBERS_MAPPED_TO_PRIMITIVE_JS, "compareTo");
    private static final Predicate<FunctionDescriptor> INT_WITH_BIT_OPERATIONS = Predicates.or(
            pattern("Int.or|and|xor|shl|shr|ushr"),
            pattern("Short|Byte.or|and|xor")
    );
    private static final DescriptorPredicate BOOLEAN_OPERATIONS = pattern("Boolean.or|and|xor");
    private static final DescriptorPredicate STRING_PLUS = pattern("String.plus");
    private static final DescriptorPredicate INT_MULTIPLICATION = pattern("Int.times(Int)");

    private static final DescriptorPredicate CHAR_RANGE_TO = pattern("Char.rangeTo(Char)");
    private static final DescriptorPredicate NUMBER_RANGE_TO = pattern("Byte|Short|Int.rangeTo(Byte|Short|Int)");

    private static final ImmutableMap<String, JsBinaryOperator> BINARY_BITWISE_OPERATIONS = ImmutableMap.<String, JsBinaryOperator>builder()
            .put("or", JsBinaryOperator.BIT_OR)
            .put("and", JsBinaryOperator.BIT_AND)
            .put("xor", JsBinaryOperator.BIT_XOR)
            .put("shl", JsBinaryOperator.SHL)
            .put("shr", JsBinaryOperator.SHR)
            .put("ushr", JsBinaryOperator.SHRU)
            .build();

    private static final Predicate<FunctionDescriptor> PREDICATE = Predicates.or(PRIMITIVE_NUMBERS_BINARY_OPERATIONS, BOOLEAN_OPERATIONS,
                                                                                 STRING_PLUS, INT_WITH_BIT_OPERATIONS,
                                                                                 PRIMITIVE_NUMBERS_COMPARE_TO_OPERATIONS);

    @Nullable
    @Override
    public FunctionIntrinsic getIntrinsic(@NotNull FunctionDescriptor descriptor) {
        if (CHAR_RANGE_TO.apply(descriptor)) {
            return new RangeToIntrinsic(descriptor);
        }

        if (PRIMITIVE_NUMBERS_COMPARE_TO_OPERATIONS.apply(descriptor)) {
            return PRIMITIVE_NUMBER_COMPARE_TO_INTRINSIC;
        }


        if (KotlinBuiltIns.isBuiltIn(descriptor) && descriptor.getName().equals(OperatorNameConventions.COMPARE_TO)) {
            return BUILTINS_COMPARE_TO_INTRINSIC;
        }

        if (!PREDICATE.apply(descriptor)) {
            return null;
        }

        if (INT_MULTIPLICATION.apply(descriptor)) {
            return INT_MULTIPLICATION_INTRINSIC;
        }
        if (NUMBER_RANGE_TO.apply(descriptor)) {
            return new RangeToIntrinsic(descriptor);
        }
        if (INT_WITH_BIT_OPERATIONS.apply(descriptor)) {
            JsBinaryOperator op = BINARY_BITWISE_OPERATIONS.get(descriptor.getName().asString());
            if (op != null) {
                return new OptimizedIntBinaryOperationInstrinsic(op);
            }
        }
        JsBinaryOperator operator = getOperator(descriptor);
        if (INT_BINARY_OPERATIONS.apply(descriptor)) {
            return new AdditiveIntBinaryOperationInstrinsic(operator);
        }
        if (SIMPLE_INT_MULTIPLICATION.apply(descriptor) || INT_DIVISION.apply(descriptor)) {
            return new IntBinaryOperationFunctionIntrinsic(operator);
        }
        BinaryOperationIntrinsicBase result = new PrimitiveBinaryOperationFunctionIntrinsic(operator);

        if (pattern("Char.plus|minus(Int)").apply(descriptor)) {
            return new CharAndIntBinaryOperationFunctionIntrinsic(result);
        }
        if (pattern("Char.minus(Char)").apply(descriptor)) {
            return new CharAndCharBinaryOperationFunctionIntrinsic(result);
        }
        return result;
    }

    @NotNull
    private static JsBinaryOperator getOperator(@NotNull FunctionDescriptor descriptor) {
        // Temporary hack to get '%' for deprecated 'mod' operator
        Name descriptorName = descriptor.getName().equals(OperatorNameConventions.MOD) ? OperatorNameConventions.REM : descriptor.getName();

        KtToken token = OperatorConventions.BINARY_OPERATION_NAMES.inverse().get(descriptorName);
        if (token == null) {
            token = OperatorConventions.BOOLEAN_OPERATIONS.inverse().get(descriptorName);
        }
        if (token == null) {
            assert descriptorName.asString().equals("xor");
            return JsBinaryOperator.BIT_XOR;
        }
        return OperatorTable.getBinaryOperator(token);
    }

    private static class PrimitiveBinaryOperationFunctionIntrinsic extends BinaryOperationIntrinsicBase {

        @NotNull
        private final JsBinaryOperator operator;

        private PrimitiveBinaryOperationFunctionIntrinsic(@NotNull JsBinaryOperator operator) {
            this.operator = operator;
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return new JsBinaryOperation(operator, left, right);
        }
    }

    private static class IntBinaryOperationFunctionIntrinsic extends PrimitiveBinaryOperationFunctionIntrinsic {
        private IntBinaryOperationFunctionIntrinsic(@NotNull JsBinaryOperator operator) {
            super(operator);
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return JsAstUtils.toInt32(super.doApply(left, right, context));
        }
    }

    private static class OptimizedIntBinaryOperationInstrinsic extends PrimitiveBinaryOperationFunctionIntrinsic {
        public OptimizedIntBinaryOperationInstrinsic(@NotNull JsBinaryOperator operator) {
            super(operator);
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            left = unwrapAdditive(left);
            right = unwrapAdditive(right);
            return super.doApply(left, right, context);
        }

        @NotNull
        private static JsExpression unwrapAdditive(@NotNull JsExpression expression) {
            JsExpression toIntArgument = JsAstUtils.extractToInt32Argument(expression);
            if (toIntArgument == null) return expression;

            if (!(toIntArgument instanceof JsBinaryOperation)) return expression;
            JsBinaryOperator operator = ((JsBinaryOperation) toIntArgument).getOperator();
            switch (operator) {
                case ADD:
                case SUB:
                    return toIntArgument;
                default:
                    return expression;
            }
        }
    }

    private static class AdditiveIntBinaryOperationInstrinsic extends OptimizedIntBinaryOperationInstrinsic {
        public AdditiveIntBinaryOperationInstrinsic(@NotNull JsBinaryOperator operator) {
            super(operator);
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return JsAstUtils.toInt32(super.doApply(left, right, context));
        }
    }

    private static class CharAndIntBinaryOperationFunctionIntrinsic extends BinaryOperationIntrinsicBase {

        @NotNull
        private final BinaryOperationIntrinsicBase functionIntrinsic;

        private CharAndIntBinaryOperationFunctionIntrinsic(@NotNull BinaryOperationIntrinsicBase functionIntrinsic) {
            this.functionIntrinsic = functionIntrinsic;
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return JsAstUtils.toChar(functionIntrinsic.doApply(JsAstUtils.charToInt(left), right, context));
        }
    }

    private static class CharAndCharBinaryOperationFunctionIntrinsic extends BinaryOperationIntrinsicBase {

        @NotNull
        private final BinaryOperationIntrinsicBase functionIntrinsic;

        private CharAndCharBinaryOperationFunctionIntrinsic(@NotNull BinaryOperationIntrinsicBase functionIntrinsic) {
            this.functionIntrinsic = functionIntrinsic;
        }

        @NotNull
        @Override
        public JsExpression doApply(@NotNull JsExpression left, @NotNull JsExpression right, @NotNull TranslationContext context) {
            return functionIntrinsic.doApply(JsAstUtils.charToInt(left), JsAstUtils.charToInt(right), context);
        }
    }
}
