package problems;

/*
Problem 28
11 October 2002

Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */


public class TwentyEight {
	
	private static final long DIM = 1001;

	public static void main (String args[]){
		long i = 1;
		//long j = 2;
		long sum =0;
		int trigger = 0;
		int k = 2;
		while (i<=DIM*DIM){
			
			if (trigger ==4){
				trigger = 0;
				k +=2;
			}
			sum +=i;
			trigger = trigger+1;
			System.out.println(i);
			i = i+k;
			
			
		}
		
		System.out.println("Answer: " + sum);
		
	}

}

// Answer: 669171001
