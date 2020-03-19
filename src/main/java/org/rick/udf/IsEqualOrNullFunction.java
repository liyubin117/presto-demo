package org.rick.udf;

import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

import java.lang.invoke.MethodHandle;

/**
 * @author liyubin
 * @version 1.0
 * @description TODO
 */
@ScalarFunction(value = "is_equal_or_null", calledOnNullInput = true)
public final class IsEqualOrNullFunction {
    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isEqualOrNullSlice(
//            @OperatorDependency(operator = OperatorType.EQUAL, returnType = StandardTypes.BOOLEAN, argumentTypes = {"T", "T"}) MethodHandle equals,
            @OperatorDependency(operator = OperatorType.EQUAL, argumentTypes = {"T", "T"}) MethodHandle equals,
            @SqlNullable @SqlType("T") Slice value1,
            @SqlNullable @SqlType("T") Slice value2) throws Throwable {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return (boolean) equals.invokeExact(value1, value2);
    }
}
