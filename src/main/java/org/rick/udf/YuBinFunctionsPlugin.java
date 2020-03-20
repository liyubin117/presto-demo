package org.rick.udf;

import com.facebook.presto.spi.Plugin;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * @author liyubin
 * @version 1.0
 * @description TODO
 */
public class YuBinFunctionsPlugin implements Plugin {

    public Set<Class<?>> getFunctions() {
        return ImmutableSet.<Class<?>>builder()
                .add(IsNullFunction.class)
                .add(IsEqualOrNullFunction.class)
                .add(StringFunction.class)
                .add(AvgFunction.class)
                .build();

    }
}