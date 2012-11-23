/*
 * Copyright 2010-2012 JetBrains s.r.o.
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

package org.jetbrains.k2js.translate.reference;

import com.google.dart.compiler.backend.js.ast.JsExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.lang.descriptors.DeclarationDescriptor;
import org.jetbrains.jet.lang.descriptors.FunctionDescriptor;
import org.jetbrains.jet.lang.descriptors.PropertyDescriptor;
import org.jetbrains.jet.lang.descriptors.VariableDescriptor;
import org.jetbrains.jet.lang.psi.JetSimpleNameExpression;
import org.jetbrains.jet.lang.resolve.BindingContext;
import org.jetbrains.k2js.translate.context.TranslationContext;

import static org.jetbrains.k2js.translate.utils.PsiUtils.isBackingFieldReference;

/**
 * @author Pavel Talanov
 */
public final class ReferenceTranslator {

    private ReferenceTranslator() {
    }

    @NotNull
    public static JsExpression translateSimpleName(@NotNull JetSimpleNameExpression expression,
            @NotNull TranslationContext context) {
        return getAccessTranslator(expression, context).translateAsGet();
    }

    @NotNull
    public static JsExpression translateAsFQReference(@NotNull DeclarationDescriptor referencedDescriptor,
            @NotNull TranslationContext context) {
        JsExpression alias = context.getAliasForDescriptor(referencedDescriptor);
        return alias != null ? alias : context.getQualifiedReference(referencedDescriptor);
    }

    @NotNull
    public static JsExpression translateAsLocalNameReference(@NotNull DeclarationDescriptor descriptor,
            @NotNull TranslationContext context) {
        if (descriptor instanceof FunctionDescriptor || descriptor instanceof VariableDescriptor) {
            JsExpression alias = context.getAliasForDescriptor(descriptor);
            if (alias != null) {
                return alias;
            }
        }
        return context.getNameRefForDescriptor(descriptor);
    }

    @NotNull
    public static AccessTranslator getAccessTranslator(@NotNull JetSimpleNameExpression referenceExpression,
            @NotNull TranslationContext context) {
        return getAccessTranslator(referenceExpression, null, context);
    }

    @NotNull
    public static AccessTranslator getAccessTranslator(@NotNull JetSimpleNameExpression expression,
            @Nullable JsExpression receiver,
            @NotNull TranslationContext context) {
        if (isBackingFieldReference(expression)) {
            return BackingFieldAccessTranslator.newInstance(expression, context);
        }

        DeclarationDescriptor descriptor = context.bindingContext().get(BindingContext.REFERENCE_TARGET, expression);
        if (descriptor instanceof PropertyDescriptor) {
            return PropertyAccessTranslator.newInstance(expression, receiver, CallType.NORMAL, context, (PropertyDescriptor) descriptor);
        }
        assert descriptor != null;
        return new ReferenceAccessTranslator(descriptor, context);
    }
}