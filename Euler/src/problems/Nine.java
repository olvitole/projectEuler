package problems;


/*
Problem 9
25 January 2002

A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

public class Nine {


	
	private static final int VALUE = 1000;

	public static void main(String args[]) {
		
		int c = -1;
		mainLoop:
		for (int a=1; a< VALUE-2;a++){
			for (int b=1; b< VALUE-2;b++){
				c = VALUE - (a+b);
				if (a*a+b*b ==c*c){
					System.out.println("Found "+ a+" "+b+" "+c);
					System.out.println("Answer "+ a*b*c);
					break mainLoop;
				}
			}
		}
		
		
	}
}
