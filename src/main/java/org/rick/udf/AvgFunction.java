package org.rick.udf;

import static com.facebook.presto.spi.type.DoubleType.DOUBLE;
 
import com.facebook.presto.spi.block.BlockBuilder;
import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import org.rick.udf.LongAndDoubleState;
import org.rick.util.PrecisionUtil;


@AggregationFunction("my_avg")
@Description("avg udf")
public final class AvgFunction {
	private AvgFunction() {
	}
 
	@InputFunction
	public static void input(@AggregationState LongAndDoubleState state, @SqlType(StandardTypes.BIGINT) long value) {
		state.setLong(state.getLong() + 1);
		state.setDouble(state.getDouble() + value);
	}
 
	@InputFunction
	public static void input(@AggregationState LongAndDoubleState state, @SqlType(StandardTypes.DOUBLE) double value) {
		state.setLong(state.getLong() + 1);
		state.setDouble(state.getDouble() + value);
	}
 
	@CombineFunction
	public static void combine(@AggregationState LongAndDoubleState state,
			@AggregationState LongAndDoubleState otherState) {
		state.setLong(state.getLong() + otherState.getLong());
		state.setDouble(state.getDouble() + otherState.getDouble());
	}
 
	@OutputFunction(StandardTypes.DOUBLE)
	public static void output(@AggregationState LongAndDoubleState state, BlockBuilder out) {
		long count = state.getLong();
		if (count == 0) {
			out.appendNull();
		} else {
			double value = state.getDouble();
			
			double tmp = Double.valueOf(PrecisionUtil.getPrecision(value / count));
			
			DOUBLE.writeDouble(out, tmp);
		}
	}
}