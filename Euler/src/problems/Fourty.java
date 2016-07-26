package problems;

/*

Problem 40
28 March 2003

An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 x  d10 x d100 x d1000 x d10000 x d100000 x d1000000

 */

public class Fourty {

	private static final int MAX = 1000000;

	public static void main(String args[]) {

		
		// building just the fractional part until 1000000
		
		StringBuilder dsb = new StringBuilder(".");

		
		
		for (int i = 1;i <= MAX;i++) {
			dsb.append(i);

		}

		//System.out.println(d.toString());
		String d = dsb.toString();
		System.out.println(Integer.parseInt(d.charAt(1)+"") * Integer.parseInt(d.charAt(10)+"") * Integer.parseInt(d.charAt(100)+"") * Integer.parseInt(d.charAt(1000)+"") * Integer.parseInt(d.charAt(10000)+"") * Integer.parseInt(d.charAt(100000)+"") * Integer.parseInt(d.charAt(1000000)+""));

	}
}
