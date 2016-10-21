package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FourtyOne {

	/**
	 * 
	 * Pandigital prime 
	 * 
	 * Problem 41 
	 * We shall say that an n-digit number is
	 * pandigital if it makes use of all the digits 1 to n exactly once. For
	 * example, 2143 is a 4-digit pandigital and is also prime.
	 * 
	 * What is the largest n-digit pandigital prime that exists?
	 */

	private static ArrayList<String> output;

	static String usableNumbers = "0";

	public static void main(String args[]) {
		
		
		// review: http://introcs.cs.princeton.edu/java/23recursion/

		Helper h = new Helper();
		output = new ArrayList<String>();

		usableNumbers = "1";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "12";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "123";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "1234";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "12345";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "123456";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "1234567";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "12345678";
		output.addAll(h.permutations(usableNumbers));
		usableNumbers = "123456789";
		output.addAll(h.permutations(usableNumbers));
		// h.permute(usableNumbers.length(), "", output, usableNumbers);
		System.out.println(output);

		int maxPrime = -1;
		for (String j : output) {
			int i = Integer.parseInt(j);
			if (h.isPrimePro(i))
				if (i > maxPrime)
					maxPrime = i;
		}

		System.out.println("Answer" + maxPrime);

	}
}
