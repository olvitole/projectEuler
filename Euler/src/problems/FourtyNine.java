package problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FourtyNine {

	/**
	 * 
	 * Prime permutations Problem 49 The arithmetic sequence, 1487, 4817, 8147,
	 * in which each of the terms increases by 3330, is unusual in two ways: (i)
	 * each of the three terms are prime, and, (ii) each of the 4-digit numbers
	 * are permutations of one another.
	 * 
	 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
	 * primes, exhibiting this property, but there is one other 4-digit
	 * increasing sequence.
	 * 
	 * What 12-digit number do you form by concatenating the three terms in this
	 * sequence?
	 */

	private static ArrayList<Integer> output;

	static String usableNumbers;

	public static void main(String args[]) {

		// review: http://introcs.cs.princeton.edu/java/23recursion/

		Helper h = new Helper();
		output = new ArrayList<Integer>();

		// get pandigital + some intruders
		usableNumbers = "123456789";
		h.permute(4, "", output, usableNumbers);
		// h.permute(usableNumbers.length(), "", output, usableNumbers);
		System.out.println(output);

		// get primes
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (Integer i : output) {
			if (h.isPrimePro(i))
				primes.add(i);
		}

		// find permutations of each other
		HashMap<String, ArrayList<Integer>> cA = new HashMap<String, ArrayList<Integer>>();
		Set<Integer> cAOut = new HashSet<Integer>();
		System.out.println(primes);

		for (Integer p : primes) {

			String temp = p + "";
			int[] newGuess = new int[temp.length()];
			for (int i = 0; i < temp.length(); i++) {
				newGuess[i] = temp.charAt(i) - '0';
			}
			Arrays.sort(newGuess);
			String sorted = new String(Arrays.toString(newGuess));
			// System.out.println(sorted);
			// System.out.println(p);

			if (sorted.equals("[1, 4, 7, 8]"))
				System.out.println("---------------" + p);
			if (cA.containsKey(sorted)) {
				ArrayList<Integer> tmps = cA.get(sorted);
				tmps.add(p);
				cA.put(sorted, tmps);
				// note is 2 because we track from
				if (cA.get(sorted).size() >= 3)
					cAOut.addAll(cA.get(sorted));
			} else {
				ArrayList<Integer> tmps = new ArrayList<Integer>();
				tmps.add(p);
				cA.put(sorted, tmps);
			}
		}

		// find the ones with same distance
		/*
		 * for (ArrayList<Integer> sets : cA.values()) { HashMap<Integer,
		 * Integer> cnts = new HashMap<Integer, Integer>(); Set<Integer> sameD =
		 * new HashSet<Integer>(); System.out.println("sets beging " + sets);
		 * for (Integer e1 : sets) { for (Integer e2 : sets) { int key =
		 * Math.abs(e1 - e2); if (cnts.containsKey(key)) { cnts.put(key,
		 * cnts.get(key) + 1); if (cnts.get(key) >= 3) { sameD.add(e1);
		 * sameD.add(e2); } } else { cnts.put(key, 1);
		 * 
		 * } } }
		 * 
		 * 
		 */
		Set<Set<Integer>> end = new HashSet<Set<Integer>>();

		for (ArrayList<Integer> sets : cA.values()) {
			Set<Integer> sameD = new HashSet<Integer>();
			System.out.println("sets beging " + sets);
			for (Integer e1 : sets) {
				for (Integer e2 : sets) {
					int dif = e1 - e2;
					if (dif < 0) {
						if (sets.contains(e2 - dif)) {
							sameD.add(e2 - dif);
							sameD.add(e1);
							sameD.add(e2);
						}

					}
					if (dif > 0) {
						if (sets.contains(e1 + dif)) {
							sameD.add(e1 + dif);
							sameD.add(e1);
							sameD.add(e2);
						}

					}

				}
			}

			System.out.println("sets  end " + sameD);
			if (sameD.size() > 0)
				end.add(sameD);

		}

		System.out.println("Answer " + end);
		
		// Answer [[2969, 6299, 9629], [4817, 8147, 1487]]


	}
}
