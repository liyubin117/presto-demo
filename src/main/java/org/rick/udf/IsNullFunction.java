package org.rick.udf;

import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

/**
 * @author liyubin
 * @version 1.0
 * @description TODO
 */
@ScalarFunction(value = "is_null", calledOnNullInput = true)
@Description("Returns TRUE if the argument is NULL")
public final class IsNullFunction {

//    @SqlType(StandardTypes.BOOLEAN)
//    public static boolean isNull(@SqlNullable @SqlType(StandardTypes.VARCHAR) Slice string)
//    {
//        return (string == null);
//    }


    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullSlice(@SqlNullable @SqlType("T") Slice value)
    {
        return (value == null);
    }

    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullLong(@SqlNullable @SqlType("T") Long value)
    {
        return (value == null);
    }

    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullDouble(@SqlNullable @SqlType("T") Double value)
    {
        return (value == null);
    }


}
