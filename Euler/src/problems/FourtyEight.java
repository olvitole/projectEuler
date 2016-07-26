package problems;

import java.math.BigDecimal;

/*
Problem 48
18 July 2003

The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
	
	
*/


public class FourtyEight {
	
	
	
	private static final int MAX_BASE_POW = 1000;
	private static final BigDecimal zeroDecimal = new BigDecimal("0");
	private static final BigDecimal LAST_DIGITS = new BigDecimal("10000000000");
	
	public static void main(String args[]) {
		BigDecimal sum = zeroDecimal;
		Helper helper = new Helper();
		for (int i=1;i<=MAX_BASE_POW;i++) {
			//sum = sum.add(BigDecimal.valueOf(Math.pow(i, i)).remainder(LAST_DIGITS));
			//System.out.println("pow "+ Math.pow(i, i));
			sum = sum.add(helper.power(new BigDecimal(i), new BigDecimal(i))).remainder(LAST_DIGITS);
			System.out.println("pow "+ helper.power(new BigDecimal(i), new BigDecimal(i)));
		}
	
	System.out.println("Answer "+ sum);
	}

}
