package org.rick.udf;

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
public final class StringFunction {
    @ScalarFunction("lowercaser")
    @SqlType(StandardTypes.VARCHAR)
    public static Slice lowercaser(@SqlType(StandardTypes.VARCHAR) Slice slice){
        String argument = slice.toStringUtf8();
        return Slices.utf8Slice(argument.toLowerCase());
    }
}
