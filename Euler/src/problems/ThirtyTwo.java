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

	private static int digitLimit = 4;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// main logic

		for (Integer two : twoDigits) {
			for (Integer three : threeDigits) {
				int mult = two * three;
				// System.out.println("" + mult + two + three);
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
				// System.out.println("" + mult + two + three);
				String eval = "" + mult + two + three;
				if (isPandigital(eval)) {
					System.out.println(eval);
					results.add(mult);
				}
			}
		}

		int sum = 0;

		for (Integer rs : results) {
			// System.out.println(rs);
			sum += rs;
		}

		System.out.println("Answer: " + sum);
	}

	// revice cleanup
	private static boolean isPandigital(String string) {
		if (string.length() == oneDigit.size() && !string.contains("0")) {
			//System.out.println(string);
			boolean[] b = new boolean[oneDigit.size()];
			//System.out.println(Arrays.toString(b));
			for (char c : string.toCharArray()) {
				//System.out.println(Integer.parseInt(c + "") - 1);
				b[Integer.parseInt(c + "") - 1] = true;
			}
			//System.out.println(Arrays.toString(b));
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

	@Deprecated
	private static class Pair {
		private final List<Integer> result;
		private final int index;

		private Pair(List<Integer> result, int index) {
			this.result = result;
			this.index = index;
		}

		public List<Integer> getResult() {
			return result;
		}

		public Integer getRslt() {
			String temp = "0";
			for (Integer a : result)
				temp = temp + a;
			return Integer.parseInt(temp);
		}

		public int getIndex() {
			return index;
		}
	}

	@Deprecated
	private static void foo(List<Integer> items) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(Collections.<Integer> emptyList(), 0));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			System.err.println(pair.getRslt());
			if (2 == ("0" + pair.getRslt()).length())
				twoDigits.add(pair.getRslt());
			if (3 == ("0" + pair.getRslt()).length())
				threeDigits.add(pair.getRslt());
			if (4 == ("0" + pair.getRslt()).length())
				fourDigits.add(pair.getRslt());
			if (pair.getResult().size() < digitLimit) {
				for (int i = pair.getIndex(); i < items.size(); ++i) {
					List<Integer> copy = new LinkedList<Integer>(pair.getResult());
					copy.add(items.get(i));
					queue.add(new Pair(copy, i + 1));
				}
			}
		}
	}

	@Deprecated
	void comb(int... items) {
		Arrays.sort(items);
		for (int k = 1; k <= items.length; k++) {
			kcomb(items, 0, k, new int[k]);
		}
	}

	@Deprecated
	private void kcomb(int[] items, int n, int k, int[] arr) {
		if (k == 0) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = n; i <= items.length - k; i++) {
				arr[arr.length - k] = items[i];
				kcomb(items, i + 1, k - 1, arr);
			}
		}
	}
}
