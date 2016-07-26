package problems;

import java.math.BigDecimal;

/*
 Problem 34
 03 January 2003

 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

 Find the sum of all numbers which are equal to the sum of the factorial of their digits.

 Note: as 1! = 1 and 2! = 2 are not sums they are not included.

 */

public class ThirtyFour {

	// Max cannot be > 7*9! bc 8 will result in a greater sum digit
	private static final long MAX = 9999999;

	public static void main(String args[]) {

		Helper h = new Helper();

		long totalSumOfNums = 0;
		long tempCurrSum = 0;
		String currNum = "";

		for (long a = 9; a <= MAX; a++) {
			//System.out.println("Aja" + a);

			currNum = a + "";
			tempCurrSum = 0;
			//System.out.println("tempCurrSum1 " + tempCurrSum);

			for (int j = 0; j < currNum.length(); j++) {
				//System.out.println("J-ja" + j);

				tempCurrSum = tempCurrSum
						+ h.factorial(new BigDecimal(Integer.parseInt(currNum.charAt(j) + "")+""))
								.longValue();
			}
			//System.out.println("tempCurrSum2 " + tempCurrSum);

			if (tempCurrSum == a) {
				System.out.println("Qual: "+a);
				totalSumOfNums = totalSumOfNums + a;
			}

		}

		System.out.println("Answer: " + totalSumOfNums);

	}

}
