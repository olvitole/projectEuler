package problems;

/*
 Problem 4
 16 November 2001

 A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.

 Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Four {

	public static void main(String args[]) {

		int num = 0;
		String forward = "";
		String reverse = "";

		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				forward = i * j + "";
				reverse = convert(forward);
				System.out.println(forward + " " + reverse);
				if (forward.equals(reverse)) {
					System.out.println("++++++++++++++ " + i + " " + j);
					if (num < i * j)
						num = i * j;
				}

			}
		}

		System.out.println(num);

	}

	private static String convert(String forward) {
		String reverse = "";
		for (int i = 1; i <= forward.length(); i++) {
			reverse = reverse + forward.charAt(forward.length() - i);
		}
		return reverse;
	}

}
