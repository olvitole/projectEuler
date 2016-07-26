package problems;

import java.util.ArrayList;

/*

 Problem 21
 05 July 2002

 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.

 */

public class TwentyOne {

	private static final int MAX = 10000;

	public static void main(String args[]) {
		long totalSum = 0;
		long divSum = 0;
		long aDivSum = 0;
		ArrayList<Long> aNums = new ArrayList<Long>();
		Helper helper = new Helper();
		for (long i = 2; i <= MAX; i++) {
			divSum = helper.sumOfDivisors(i);
			aDivSum = helper.sumOfDivisors(divSum);
			if (i == aDivSum && divSum != aDivSum) {
				if (!aNums.contains(aDivSum)) {
					System.out.println(divSum + " " + aDivSum);
					aNums.add(divSum);
					aNums.add(aDivSum);
					totalSum = totalSum + divSum + aDivSum;
				}

			}
		}
		System.out.println("d4: " + helper.sumOfDivisors(4));
		System.out.println("d8: " + helper.sumOfDivisors(8));
		System.out.println("Answer: " + totalSum);
	}

}

// Answer: 15276
// Answer: 23934
// Answer: 31626
