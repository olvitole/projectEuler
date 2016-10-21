
package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThirtyEight {

	/**
	 * 
	 * Pandigital multiples
	 * 
	 * Problem 38 Take the number 192 and multiply it by each of 1, 2, and 3:
	 * 
	 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576 By concatenating each product
	 * we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
	 * concatenated product of 192 and (1,2,3)
	 * 
	 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3,
	 * 4, and 5, giving the pandigital, 918273645, which is the concatenated
	 * product of 9 and (1,2,3,4,5).
	 * 
	 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
	 * as the concatenated product of an integer with (1,2, ... , n) where n >
	 * 1?
	 */

	private static ArrayList<String> output;

	static String usableNumbers = "0";

	public static void main(String args[]) {

		Helper h = new Helper();
		output = new ArrayList<String>();

		usableNumbers = "123456789";
		output.addAll(h.permutations(usableNumbers));
		// h.permute(usableNumbers.length(), "", output, usableNumbers);
		System.out.println(output);

		// teest with 1 and 2 -> if was not right would have tried other splits or coded them all in here
		int max = -1;
		for (String j : output) {
			int i = Integer.parseInt(j);
			int ia = Integer.parseInt(j.substring(0, 4));
			int ib = Integer.parseInt(j.substring(4));

			if (ib == 2 * ia)
				if (i > max)
					max = i;
		}

		System.out.println("Answer" + max);

	}


}
