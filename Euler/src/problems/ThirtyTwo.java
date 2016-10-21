package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ThirtyTwo {

	private static ArrayList<Integer> oneDigit;
	private static ArrayList<Integer> twoDigits;
	private static ArrayList<Integer> threeDigits;
	private static ArrayList<Integer> fourDigits;
	
	private static String usableNumbers = "123456789";

	/**
	 * Problem 32
	 * 
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	 * is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
	 * multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product
	 * identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to
	 * only include it once in your sum.
	 */

	public static void main(String args[]) {

		// Analysis
		// we need to get a 9 digit number as a result this means the products
		// will be structured as follows:
		// X*XXXX, XX*XXX, the other scenaroious would not reach 10 digits

		oneDigit = new ArrayList<Integer>();
		oneDigit.add(1);
		oneDigit.add(2);
		oneDigit.add(3);
		oneDigit.add(4);
		oneDigit.add(5);
		oneDigit.add(6);
		oneDigit.add(7);
		oneDigit.add(8);
		oneDigit.add(9);
		
		Helper h = new Helper();

		twoDigits = new ArrayList<Integer>();
		h.permute(2, "", twoDigits, usableNumbers);

		threeDigits = new ArrayList<Integer>();
		h.permute(3, "", threeDigits, usableNumbers);

		fourDigits = new ArrayList<Integer>();
		h.permute(4, "", fourDigits, usableNumbers);

		HashSet<Integer> results = new HashSet<Integer>();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// main logic can be factored more but its fine for testing

		for (Integer two : twoDigits) {
			for (Integer three : threeDigits) {
				int mult = two * three;
				String eval = "" + mult + two + three;
				if (h.isPandigital(eval, usableNumbers)) {
					System.out.println(eval);
					results.add(mult);
				}
			}
		}

		for (Integer two : oneDigit) {
			for (Integer three : fourDigits) {
				int mult = two * three;
				String eval = "" + mult + two + three;
				if (h.isPandigital(eval, usableNumbers)) {
					System.out.println(eval);
					results.add(mult);
				}
			}
		}

		int sum = 0;

		for (Integer rs : results) {
			sum += rs;
		}

		System.out.println("Answer: " + sum);
	}


}
