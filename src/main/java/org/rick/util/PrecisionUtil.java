package org.rick.util;

import java.text.DecimalFormat;

public class PrecisionUtil {
 
	public static double getPrecision(double value) {
 
		DecimalFormat df = new DecimalFormat("####0.000");
 
		double tmp = Double.valueOf(df.format(value));
 
		return tmp;
	}
}