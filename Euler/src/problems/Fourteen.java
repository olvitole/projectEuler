package problems;

import java.util.LinkedList;
import java.util.Queue;

/*

 Problem 14
 05 April 2002

 The following iterative sequence is defined for the set of positive integers:

 n  n/2 (n is even)
 n  3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13  40  20  10  5  16  8  4  2  1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.
 */

/* Old inefficient */
public class Fourteen {

	private static final double MAX = 1000000;

	public static void main(String args[]) {

		long maxTerms = 1;
		long numberWithMaxTerms = 1;
		for (long i = 2; i < MAX; i++) {
			//System.out.println("Num: " + i);
			long terms = 1;
			long num=i;
			while (num != 1) {
				if ((num % 2) == 0) {
					num /= 2;
				} else {
					num = (3 * num) + 1;
				}
				terms++;
				// System.out.println("New Num: " + num);
			}
			// System.out.println("Terms " + terms);
			if (terms > maxTerms) {
				maxTerms = terms;
				numberWithMaxTerms = i;
			}

		}
		System.out.println("Answer " + numberWithMaxTerms);
	}
}

/*
 * did not work public class Fourteen {
 * 
 * private static final double MAX = 1000000;
 * 
 * public static void main(String args[]) {
 * 
 * Queue<Double> patternQueue = new LinkedList<Double>(); // use transition
 * stock if you need them ordered //Stack<Double> transitionStack = new
 * Stack<Double>();
 * 
 * double num = 1; double answer =-1; for (double i = 1; i < MAX; i++) { num =
 * i; System.out.println("Num: " + num); if (!patternQueue.contains(num)) {
 * answer = num; while (!patternQueue.contains(num)) { patternQueue.add(num); if
 * (num % 2 == 0) { num = num / 2; } else { num = 3 * num + 1; }
 * System.out.println("New Num: " + num); // transitionStack.push(num); } //
 * while(!transitionStack.isEmpty()){ //
 * patternQueue.add(transitionStack.pop()); // } } }
 * 
 * System.out.println("Answer " + answer); }
 * 
 * 
 * }
 */

/*
It will depend on the underlying architecture. In general, the fastest types will be the ones that correspond to your native word size: 32-bit on a 32-bit machine, or 64-bit on a 64-bit machine.

So int is faster than long on a 32-bit machine; long might be faster than int on a 64-bit machine, or the might be the same. As for boolean, I would imagine it's using the native word size anyway, so it will be pretty much exactly as fast as int or long.

Doubles (using floating point arithmetic) tend to be slower.

As long as you are dealing with primitive types, the difference will be negligible. The really slow types are the class types (like Integer or Boolean) -- avoid those if you want performance.

*/

//Answer 837799