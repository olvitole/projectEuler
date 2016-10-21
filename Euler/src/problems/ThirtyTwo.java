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

	private static String source = "123456789";

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

		twoDigits = new ArrayList<Integer>();
		permute(2, "", twoDigits);

		threeDigits = new ArrayList<Integer>();
		permute(3, "", threeDigits);

		fourDigits = new ArrayList<Integer>();
		permute(4, "", fourDigits);

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
				if (isPandigital(eval)) {
					System.out.println(eval);
					results.add(mult);
				}
			}
		}

		for (Integer two : oneDigit) {
			for (Integer three : fourDigits) {
				int mult = two * three;
				String eval = "" + mult + two + three;
				if (isPandigital(eval)) {
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

	// revice cleanup
	private static boolean isPandigital(String string) {
		if (string.length() == source.length() && !string.contains("0")) {
			boolean[] b = new boolean[source.length()];
			for (char c : string.toCharArray()) {
				b[Integer.parseInt(c + "") - 1] = true;
			}
			return !(Arrays.toString(b)).contains("false");
		}
		return false;
	}

	static void permute(int level, String prefix, ArrayList<Integer> populate) {
		// note for our problem we can exclude the ones that contain repeat
		// numbers even though they will be filtered later on
		if (level == 0) {
			populate.add(Integer.parseInt(prefix));
			return;
		}
		for (int i = 0; i < source.length(); i++)
			permute(level - 1, prefix + source.charAt(i), populate);
	}

}
