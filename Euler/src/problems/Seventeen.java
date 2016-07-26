package problems;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

/*

 Problem 17
 17 May 2002

 If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

 If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


 NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

 */

public class Seventeen {

	public static void main(String args[]) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		for (int i = 14; i < 20; i++)
			map.put(i, map.get(i % 10) + "teen");
		map.put(15, "fifteen");
		map.put(18, "eighteen");
		map.put(20, "twenty");

		map.put(30, "thirty");
		for (int i = 40; i < 100; i += 10)
			map.put(i, map.get(i / 10) + "ty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(80, "eighty");

		for (int i = 21; i < 100; i++) {
			if (i % 10 != 0) {
				map.put(i, map.get(((i / 10) * 10)) + map.get(i % 10));
			}
		}

		for (int i = 100; i < 1000; i += 10) {
			map.put(i, map.get(i / 100) + " hundred");
		}
		map.put(1000, "one thousand");
		for (int i = 100; i < 1000; i++) {
			if (i % 100 != 0) {
				map.put(i,
						map.get(i / 100) + " hundred and " + map.get(i % 100));
			}
		}

		double totalLetters = 0;
		String currNum = "";
		int currLength =0;
		for (int i = 1; i <= 1000; i++) {
			System.out.println("Index " + i);
			System.out.println(map.get(i));
			currNum = map.get(i).replace(" ", "");
			System.out.println("currNum " + currNum);
			currLength = currNum.length();		
			System.out.println("currLength " + currLength);
			totalLetters = totalLetters + currLength;
			System.out.println("totalLetters " + totalLetters);
		}
		System.out.println("Answer " + totalLetters);
	}
}
