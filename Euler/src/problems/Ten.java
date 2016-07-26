package problems;

/*

Problem 10
08 February 2002

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

*/


public class Ten {
			
		private static final int PRIME_NUMBER_UNDER = 2000000;

		public static void main(String args[]) {

			//int primeNumber = 2;
			long count = 1;
			Helper helper = new Helper();
			// we add one because we are starting from the second prime number 
			long sum = 0;
			while (count <= PRIME_NUMBER_UNDER) {
				count++;
				if (helper.isPrimePro(count)) {
					//primeNumber++;
					//System.out.println("Prime number "+ (primeNumber-1) + ": " + count);
					sum = sum+ count;
				}
			}
			System.out.println("Answer " + sum);
		}
}
