package problems;

import java.math.BigDecimal;

/*

 Problem 30
 08 November 2002

 Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

 1634 = 14 + 64 + 34 + 44
 8208 = 84 + 24 + 04 + 84
 9474 = 94 + 44 + 74 + 44
 As 1 = 14 is not a sum it is not included.

 The sum of these numbers is 1634 + 8208 + 9474 = 19316.

 Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.


 */

/*
 analyze: 
 9 = 9

 22 = 
 */

public class Thirty {

	private static final BigDecimal POWER = new BigDecimal("5");
	private static final BigDecimal ZERO = new BigDecimal("0");
	private static final BigDecimal ONE = new BigDecimal("1");
	private static final BigDecimal TWO = new BigDecimal("2");
	private static final BigDecimal SIX = new BigDecimal("6");
	private static final BigDecimal NINE = new BigDecimal("9");

	public static void main(String args[]) {

		Helper helper = new Helper();

		BigDecimal i = TWO;
		BigDecimal base = null;
		BigDecimal tempSum = null;
		BigDecimal answer = ZERO;
		BigDecimal total = new BigDecimal((SIX.multiply(helper.power(NINE,
				POWER))) + "");
		while (i.compareTo(total) <= 1) {
			tempSum = ZERO;
			String curNum = i.toString();
			for (int j = 0; j < curNum.length(); j++) {
				base = new BigDecimal(curNum.charAt(j) + "");
				tempSum = tempSum.add(helper.power(base, POWER));
			}
			// System.out.println("Sum: " + tempSum);
			// System.out.println("I: " + i);
			if (tempSum.equals(i)) {
				answer = answer.add(i);
				System.out.println("Wanted: " + i);
			}
			i = i.add(ONE);

		}
		System.out.println("Answer: " + answer.toPlainString());

	}

}

// nrs 4150; 4151

/*
Wanted: 4150
Wanted: 4151
Wanted: 54748
Wanted: 92727
Wanted: 93084
Wanted: 194979
 */
