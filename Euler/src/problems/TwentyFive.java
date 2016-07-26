package problems;

import

java.math.BigDecimal;

/*

 Problem 25

 30 August 2002



 The Fibonacci sequence is defined by the recurrence relation:

 Fn

 = Fn1 + Fn2, where F1 = 1 and F2 = 1.
 Hence the first 12 terms will be:

 F1 = 1

 F2 = 1

 F3 = 2

 F4 = 3

 F5 = 5

 F6 = 8

 F7 = 13

 F8 = 21

 F9 = 34

 F10 = 55

 F11 = 89

 F12 = 144

 The 12th term, F12, is the first term to contain three digits.

 What is the first term in the Fibonacci sequence to contain 1000 digits?









 */

public class TwentyFive {
	public static void main(String args[]) {
		BigDecimal fn =

		new BigDecimal("0");
		BigDecimal fn1 =

		new BigDecimal("1");
		BigDecimal fn2 =

		new BigDecimal("1");
		int i = 2;
		while ((fn).toPlainString().length() < 1000) {
			i++;

			fn = fn1.add(fn2);

			fn1 = fn2;

			fn2 = fn;

			System.

			out.println(i);
			System.

			out.println(fn);
		}

		System.

		out.println((fn).toPlainString().length());
		System.

		out.println("Answer " + i);
	}

}
