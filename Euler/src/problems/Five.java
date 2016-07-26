package problems;

import java.math.BigDecimal;
import java.util.HashMap;

/*
 *  Problem 5
 *  30 November 2001
 *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?  
 */

public class Five {

	private static final int MAX = 20;

	public static void main(String args[]) {

		HashMap<String, String> currMap = new HashMap<String, String>();
		HashMap<String, String> finalMap = new HashMap<String, String>();

		for (int i = 2; i <= MAX; i++) {
			currMap = getPrimeFactorsMap(i);
			System.out.println(currMap.toString());

			for (int j = 0; j < MAX; j++) {
				if (currMap.containsKey(j + "")) {
					if (finalMap.containsKey(j + "")) {
						if ((new BigDecimal(finalMap.get(j + "")))
								.compareTo(new BigDecimal(currMap.get(j + ""))) < 0) {
							finalMap.put(j + "", currMap.get(j + ""));
						}
					} else {
						finalMap.put(j + "", currMap.get(j + ""));
					}

				}
			}
		}
		System.out.println("Final Map: "+finalMap.toString());

		double prod = 1;
		for (int j = 0; j < MAX; j++) {
			if (finalMap.containsKey(j + "")) {
				prod = prod
						* Math.pow(Double.parseDouble(j + ""),
								Double.parseDouble(finalMap.get(j + "")));
			}
		}
		System.out.println("Answer "+prod);
		// broke in factors 1 2 3 4 5 6 ... 20 and choosed the ones with lowest
		// power
		System.out.println("Manual Test");
		System.out.print(1 * 2 * 3 * 2 * 5 * 7 * 2 * 3 * 11 * 13 * 2 * 17 * 19);
	}

	public static HashMap<String, String> getPrimeFactorsMap(long num) {
		HashMap<String, String> map = new HashMap<String, String>();
		int counter = 2;
		int power = 0;
		while (num != 1) {

			if (num % counter == 0) {
				power++;
				map.put(counter + "", power + "");
				num = num / counter;
			} else {
				counter++;
				power = 0;
			}
		}
		return map;
	}
}
