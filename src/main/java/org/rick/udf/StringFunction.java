package org.rick.udf;

import com.facebook.presto.spi.function.Description;
import com.facebook.presto.spi.function.ScalarFunction;
import com.facebook.presto.spi.function.SqlType;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;
import io.airlift.slice.Slices;

/**
 * @author liyubin
 * @version 1.0
 * @description TODO
 */

public class StringFunction {
    @ScalarFunction("str_lower")
    @Description("lower string")
    @SqlType(StandardTypes.VARCHAR)
    public static Slice str_lower(@SqlType(StandardTypes.VARCHAR) Slice arg) {
        String argument = arg.toStringUtf8();
        return Slices.utf8Slice(argument.toLowerCase());
    }

    @ScalarFunction("str_upper")
    @Description("upper string")
    @SqlType(StandardTypes.VARCHAR)
    public static Slice str_upper(@SqlType(StandardTypes.VARCHAR) Slice arg) {
        String argument = arg.toStringUtf8();
        return Slices.utf8Slice(argument.toUpperCase());
    }

    @ScalarFunction("printone")
    @SqlType(StandardTypes.INTEGER)
    public static long print_one(@SqlType(StandardTypes.INTEGER) long arg){
        return 1;
    }

}