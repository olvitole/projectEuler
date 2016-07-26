package problems;

/*
 Problem 357
 05 November 2011

 Consider the divisors of 30: 1,2,3,5,6,10,15,30.
 It can be seen that for every divisor d of 30, d+30/d is prime.

 Find the sum of all positive integers n not exceeding 100 000 000
 such that for every divisor d of n, d+n/d is prime.
 */

import java.util.ArrayList;

public class ThreeHundredFiftySeven {

	private static final long MAX = 100000;

	public static void main(String[] args) {

		Helper helper = new Helper();
		long sum = 0;
		for (long n = 1; n <= MAX; n++) {
			if (n%1000000==0)
				System.out.println("n: " + n);
			// cannot work for odd nr or multi of 4
			if ((n % 4 != 0) && (n % 2 != 1)) {
				boolean add = true;
				ArrayList<Long> divisors = helper.getDivisors(n);
				for (int i = 0; i < divisors.size(); i++) {
					Long d = divisors.get(i);
					//System.out.println("d: " + d);
					if (!helper.isPrimePro((d + n / d))) {
						//System.out.println("np: " + (d + n / d));
						add = false;
						break;
					}
				}
				if (add){
					sum = sum + n;
					System.out.println("num: " + n);
				}
			}
		}
		System.out.println("Answer: " + (sum+1));

	}
}

// first Answer: 1739023853136
// after adding 1 : 1739023853137
