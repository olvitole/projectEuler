package problems;

/*Problem 6
14 December 2001

The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
public class Six{
	
	public static void main(String args[]) {

		long sumOfSqr = 0;
		long sqrOfSum =0;
		for (int i=1; i<=100; i++){
			sumOfSqr = sumOfSqr+i*i;
		}
		
		for (int i=1; i<=100; i++){
			sqrOfSum = sqrOfSum+i;
		}
		sqrOfSum = sqrOfSum*sqrOfSum;
		
		System.out.print("Answer "+ (sqrOfSum-sumOfSqr));
	}
	
	
}
 