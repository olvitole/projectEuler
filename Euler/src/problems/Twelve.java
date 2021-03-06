package problems;

//import java.util.HashMap;

/*

 Problem 12
 08 March 2002

 The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

 Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
 10: 1,2,5,10
 15: 1,3,5,15
 21: 1,3,7,21
 28: 1,2,4,7,14,28
 We can see that 28 is the first triangle number to have over five divisors.

 What is the value of the first triangle number to have over five hundred divisors?

 */

public class Twelve {

	private static final int NO_OF_DIVISORS = 500;

	public static void main(String args[]) {

		long count = 1;
		Helper helper = new Helper();
		long triangleNumber = 1;
		long noOfDivisors = 0;

		// System.out.println(helper.power(2, 500));

		while (noOfDivisors <= NO_OF_DIVISORS) {
			count++;
			triangleNumber = triangleNumber + count;
			// HashMap<Long, Long> divisors = helper.getFactors(triangleNumber);
			// noOfDivisors = divisors.size();
			
			noOfDivisors = helper.getNoOfFactors(triangleNumber);
			System.out.println("Curr Index " + count + " triangleNumber "
					+ triangleNumber + " noOfDivisors " + noOfDivisors);
		}

		System.out.println("Answer " + triangleNumber);
	}
}
