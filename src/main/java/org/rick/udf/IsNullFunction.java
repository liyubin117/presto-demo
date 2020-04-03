package org.rick.udf;

import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

/**
 * @author liyubin
 * @version 1.0
 * @description TODO
 */
import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

@ScalarFunction(value = "is_null", calledOnNullInput = true)
@Description("this is a function, if arg is null, return true")
public class IsNullFunction {
    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullSlice (@SqlNullable @SqlType("T") Slice arg){
        return arg == null;
    }

    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullDouble (@SqlNullable @SqlType("T") Double arg){
        return arg == null;
    }

    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullInt (@SqlNullable @SqlType("T") Integer arg){
        return arg == null;
    }

    @TypeParameter("T")
    @SqlType(StandardTypes.BOOLEAN)
    public static boolean isNullLong (@SqlNullable @SqlType("T") Long arg){
        return arg == null;
    }
}
