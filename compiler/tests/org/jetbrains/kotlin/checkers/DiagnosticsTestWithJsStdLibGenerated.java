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

package org.jetbrains.kotlin.checkers;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class DiagnosticsTestWithJsStdLibGenerated extends AbstractDiagnosticsTestWithJsStdLib {
    public void testAllFilesPresentInTestsWithJsStdLib() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib"), Pattern.compile("^(.+)\\.kt$"), true);
    }

    @TestMetadata("Serializable.kt")
    public void testSerializable() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/Serializable.kt");
        doTest(fileName);
    }

    @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class DynamicTypes extends AbstractDiagnosticsTestWithJsStdLib {
        public void testAllFilesPresentInDynamicTypes() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("assignment.kt")
        public void testAssignment() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/assignment.kt");
            doTest(fileName);
        }

        @TestMetadata("block.kt")
        public void testBlock() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/block.kt");
            doTest(fileName);
        }

        @TestMetadata("callableReferences.kt")
        public void testCallableReferences() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/callableReferences.kt");
            doTest(fileName);
        }

        @TestMetadata("comparisonToNull.kt")
        public void testComparisonToNull() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/comparisonToNull.kt");
            doTest(fileName);
        }

        @TestMetadata("conditions.kt")
        public void testConditions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/conditions.kt");
            doTest(fileName);
        }

        @TestMetadata("conventions.kt")
        public void testConventions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/conventions.kt");
            doTest(fileName);
        }

        @TestMetadata("delegationBy.kt")
        public void testDelegationBy() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/delegationBy.kt");
            doTest(fileName);
        }

        @TestMetadata("dynamicCalls.kt")
        public void testDynamicCalls() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/dynamicCalls.kt");
            doTest(fileName);
        }

        @TestMetadata("dynamicCallsWithLambdas.kt")
        public void testDynamicCallsWithLambdas() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/dynamicCallsWithLambdas.kt");
            doTest(fileName);
        }

        @TestMetadata("dynamicCastTarget.kt")
        public void testDynamicCastTarget() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/dynamicCastTarget.kt");
            doTest(fileName);
        }

        @TestMetadata("dynamicSafeCalls.kt")
        public void testDynamicSafeCalls() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/dynamicSafeCalls.kt");
            doTest(fileName);
        }

        @TestMetadata("dynamicVsGeneric.kt")
        public void testDynamicVsGeneric() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/dynamicVsGeneric.kt");
            doTest(fileName);
        }

        @TestMetadata("extensionVals.kt")
        public void testExtensionVals() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/extensionVals.kt");
            doTest(fileName);
        }

        @TestMetadata("extensionVars.kt")
        public void testExtensionVars() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/extensionVars.kt");
            doTest(fileName);
        }

        @TestMetadata("extensions.kt")
        public void testExtensions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/extensions.kt");
            doTest(fileName);
        }

        @TestMetadata("extensionsToDynamic.kt")
        public void testExtensionsToDynamic() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/extensionsToDynamic.kt");
            doTest(fileName);
        }

        @TestMetadata("implicitDynamicReceiver.kt")
        public void testImplicitDynamicReceiver() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/implicitDynamicReceiver.kt");
            doTest(fileName);
        }

        @TestMetadata("inference.kt")
        public void testInference() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/inference.kt");
            doTest(fileName);
        }

        @TestMetadata("membersOfAny.kt")
        public void testMembersOfAny() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/membersOfAny.kt");
            doTest(fileName);
        }

        @TestMetadata("namedArguments.kt")
        public void testNamedArguments() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/namedArguments.kt");
            doTest(fileName);
        }

        @TestMetadata("noUnsupportedInLocals.kt")
        public void testNoUnsupportedInLocals() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/noUnsupportedInLocals.kt");
            doTest(fileName);
        }

        @TestMetadata("nullable.kt")
        public void testNullable() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/nullable.kt");
            doTest(fileName);
        }

        @TestMetadata("overloading.kt")
        public void testOverloading() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/overloading.kt");
            doTest(fileName);
        }

        @TestMetadata("overloadingAmbiguity.kt")
        public void testOverloadingAmbiguity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/overloadingAmbiguity.kt");
            doTest(fileName);
        }

        @TestMetadata("overrides.kt")
        public void testOverrides() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/overrides.kt");
            doTest(fileName);
        }

        @TestMetadata("protected.kt")
        public void testProtected() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/protected.kt");
            doTest(fileName);
        }

        @TestMetadata("reified.kt")
        public void testReified() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/reified.kt");
            doTest(fileName);
        }

        @TestMetadata("smartCast.kt")
        public void testSmartCast() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/smartCast.kt");
            doTest(fileName);
        }

        @TestMetadata("spreadOperator.kt")
        public void testSpreadOperator() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/spreadOperator.kt");
            doTest(fileName);
        }

        @TestMetadata("staticCallsInDynamicContext.kt")
        public void testStaticCallsInDynamicContext() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/staticCallsInDynamicContext.kt");
            doTest(fileName);
        }

        @TestMetadata("substitution.kt")
        public void testSubstitution() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/substitution.kt");
            doTest(fileName);
        }

        @TestMetadata("supertypesAndBounds.kt")
        public void testSupertypesAndBounds() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/supertypesAndBounds.kt");
            doTest(fileName);
        }

        @TestMetadata("typealiasExpandingToDynamic.kt")
        public void testTypealiasExpandingToDynamic() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/typealiasExpandingToDynamic.kt");
            doTest(fileName);
        }

        @TestMetadata("varargs.kt")
        public void testVarargs() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/dynamicTypes/varargs.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/jsCode")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class JsCode extends AbstractDiagnosticsTestWithJsStdLib {
        public void testAllFilesPresentInJsCode() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/jsCode"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("argumentIsLiteral.kt")
        public void testArgumentIsLiteral() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/jsCode/argumentIsLiteral.kt");
            doTest(fileName);
        }

        @TestMetadata("error.kt")
        public void testError() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/jsCode/error.kt");
            doTest(fileName);
        }

        @TestMetadata("noJavaScriptProduced.kt")
        public void testNoJavaScriptProduced() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/jsCode/noJavaScriptProduced.kt");
            doTest(fileName);
        }

        @TestMetadata("warning.kt")
        public void testWarning() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/jsCode/warning.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Native extends AbstractDiagnosticsTestWithJsStdLib {
        public void testAllFilesPresentInNative() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class NativeGetter extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInNativeGetter() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("onLocalExtensionFun.kt")
            public void testOnLocalExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onLocalExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNativeClassMembers.kt")
            public void testOnLocalNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onLocalNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNonNativeClassMembers.kt")
            public void testOnLocalNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onLocalNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalOtherDeclarations.kt")
            public void testOnLocalOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onLocalOtherDeclarations.kt");
                doTest(fileName);
            }

            @TestMetadata("onNativeClassMembers.kt")
            public void testOnNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNativeClass.kt")
            public void testOnNestedDeclarationsInsideNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onNestedDeclarationsInsideNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNonNativeClass.kt")
            public void testOnNestedDeclarationsInsideNonNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onNestedDeclarationsInsideNonNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNonNativeClassMembers.kt")
            public void testOnNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelExtensionFun.kt")
            public void testOnToplevelExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onToplevelExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelOtherDeclarations.kt")
            public void testOnToplevelOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeGetter/onToplevelOtherDeclarations.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class NativeInvoke extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInNativeInvoke() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("onLocalExtensionFun.kt")
            public void testOnLocalExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onLocalExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNativeClassMembers.kt")
            public void testOnLocalNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onLocalNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNonNativeClassMembers.kt")
            public void testOnLocalNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onLocalNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalOtherDeclarations.kt")
            public void testOnLocalOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onLocalOtherDeclarations.kt");
                doTest(fileName);
            }

            @TestMetadata("onNativeClassMembers.kt")
            public void testOnNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNativeClass.kt")
            public void testOnNestedDeclarationsInsideNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onNestedDeclarationsInsideNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNonNativeClass.kt")
            public void testOnNestedDeclarationsInsideNonNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onNestedDeclarationsInsideNonNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNonNativeClassMembers.kt")
            public void testOnNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelExtensionFun.kt")
            public void testOnToplevelExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onToplevelExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelOtherDeclarations.kt")
            public void testOnToplevelOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeInvoke/onToplevelOtherDeclarations.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class NativeSetter extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInNativeSetter() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("onLocalExtensionFun.kt")
            public void testOnLocalExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onLocalExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNativeClassMembers.kt")
            public void testOnLocalNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onLocalNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalNonNativeClassMembers.kt")
            public void testOnLocalNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onLocalNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onLocalOtherDeclarations.kt")
            public void testOnLocalOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onLocalOtherDeclarations.kt");
                doTest(fileName);
            }

            @TestMetadata("onNativeClassMembers.kt")
            public void testOnNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNativeClass.kt")
            public void testOnNestedDeclarationsInsideNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onNestedDeclarationsInsideNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNestedDeclarationsInsideNonNativeClass.kt")
            public void testOnNestedDeclarationsInsideNonNativeClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onNestedDeclarationsInsideNonNativeClass.kt");
                doTest(fileName);
            }

            @TestMetadata("onNonNativeClassMembers.kt")
            public void testOnNonNativeClassMembers() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onNonNativeClassMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelExtensionFun.kt")
            public void testOnToplevelExtensionFun() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onToplevelExtensionFun.kt");
                doTest(fileName);
            }

            @TestMetadata("onToplevelOtherDeclarations.kt")
            public void testOnToplevelOtherDeclarations() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nativeSetter/onToplevelOtherDeclarations.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nested")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Nested extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInNested() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/nested"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("nativeInnerClassProhibited.kt")
            public void testNativeInnerClassProhibited() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/nested/nativeInnerClassProhibited.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class OptionlBody extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInOptionlBody() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("native.kt")
            public void testNative() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody/native.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeGetter.kt")
            public void testNativeGetter() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody/nativeGetter.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeInvoke.kt")
            public void testNativeInvoke() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody/nativeInvoke.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeSetter.kt")
            public void testNativeSetter() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/optionlBody/nativeSetter.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Rtti extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInRtti() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("castToNativeInterface.kt")
            public void testCastToNativeInterface() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti/castToNativeInterface.kt");
                doTest(fileName);
            }

            @TestMetadata("checkForNativeInterface.kt")
            public void testCheckForNativeInterface() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti/checkForNativeInterface.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeInterfaceAsReifiedTypeArgument.kt")
            public void testNativeInterfaceAsReifiedTypeArgument() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti/nativeInterfaceAsReifiedTypeArgument.kt");
                doTest(fileName);
            }

            @TestMetadata("whenIsNativeInterface.kt")
            public void testWhenIsNativeInterface() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/rtti/whenIsNativeInterface.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class UnusedParam extends AbstractDiagnosticsTestWithJsStdLib {
            public void testAllFilesPresentInUnusedParam() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("native.kt")
            public void testNative() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam/native.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeGetter.kt")
            public void testNativeGetter() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam/nativeGetter.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeInvoke.kt")
            public void testNativeInvoke() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam/nativeInvoke.kt");
                doTest(fileName);
            }

            @TestMetadata("nativeSetter.kt")
            public void testNativeSetter() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/diagnostics/testsWithJsStdLib/native/unusedParam/nativeSetter.kt");
                doTest(fileName);
            }
        }
    }
}
