package problems;

/*
 Problem 31
 22 November 2002

 In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 It is possible to make £2 in the following way:

 1£1 + 150p + 220p + 15p + 12p + 31p
 How many different ways can £2 be made using any number of coins?

 */

public class ThirtyOne {

	public static void main(String args[]) {

		int combinations = 1; // when 2=2

		for (int a = 0; a <= 2; a++)
			for (int b = 0; b <= 4; b++)
				for (int c = 0; c <= 10; c++)
					for (int d = 0; d <= 20; d++)
						for (int e = 0; e <= 40; e++)
							for (int f = 0; f <= 100; f++)
								for (int g = 0; g <= 200; g++) {
									if (100 * a + 50 * b + 20 * c + 10 * d + 5
											* e + 2 * f + g == 200)
										combinations++;
								}
		System.out.println("Answer: " + combinations);

	}

	// 349966
	// 160000
	// 73682

}
