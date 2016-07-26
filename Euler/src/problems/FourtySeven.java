package problems;

import java.util.ArrayList;
import java.util.List;

/*
 Problem 47
 04 July 2003

 The first two consecutive numbers to have two distinct prime factors are:

 14 = 2  7
 15 = 3  5

 The first three consecutive numbers to have three distinct prime factors are:

 644 = 2²  7  23
 645 = 3  5  43
 646 = 2  17  19.

 Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
 */

public class FourtySeven {

	public static void main(String args[]) {
		boolean found = false;
		int i = 1;
		Helper helper = new Helper();
		ArrayList<Long> a = new ArrayList<Long>();
		ArrayList<Long> b = new ArrayList<Long>();
		ArrayList<Long> c = new ArrayList<Long>();
		ArrayList<Long> d = new ArrayList<Long>();

		ArrayList<Long> not_a = new ArrayList<Long>();
		ArrayList<Long> not_b = new ArrayList<Long>();
		ArrayList<Long> not_c = new ArrayList<Long>();
		ArrayList<Long> not_d = new ArrayList<Long>();

		mainloop: while (!found) {
			i++;
			a = helper.primeFactorsPowered(i);
			b = helper.primeFactorsPowered(i + 1);
			c = helper.primeFactorsPowered(i + 2);
			d = helper.primeFactorsPowered(i + 3);
			not_a.addAll(b);
			not_a.addAll(c);
			not_a.addAll(d);

			not_b.addAll(c);
			not_b.addAll(d);
			not_b.addAll(a);

			not_c.addAll(d);
			not_c.addAll(a);
			not_c.addAll(b);

			not_d.addAll(a);
			not_d.addAll(b);
			not_d.addAll(c);

			for (Long ai : a) {
				if (not_a.contains(ai)) {
					continue mainloop;
				}
			}

			for (Long bi : b) {
				if (not_b.contains(bi)) {
					continue mainloop;
				}
			}

			for (Long ci : c) {
				if (not_c.contains(ci)) {
					continue mainloop;
				}
			}

			for (Long di : d) {
				if (not_d.contains(di)) {
					continue mainloop;
				}
			}

			System.out.println("Answer: " + i);
			//break;

		}
	}
}

// for (long a: primes){
// System.out.println(a);
