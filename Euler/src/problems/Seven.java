package problems;

/*
 Problem 7
 28 December 2001

 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 What is the 10 001st prime number?
 */

public class Seven {

	private static final int PRIME_NUMBER = 10001;

	public static void main(String args[]) {

		int primeNumber = 2;
		long count = 1;
		Helper helper = new Helper();

		// we add one because we are starting from the second prime number 
		while (primeNumber <= PRIME_NUMBER+1) {
			count++;
			if (helper.isPrime(count)) {
				primeNumber++;
				System.out.println("Primes " + count);
			}
		}
		System.out.println("Answer " + count);
	}	
	
}
