package problems;

/*
Problem 50
15 August 2003

The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes? 
 
 */

public class Fifty {
	
	private static final int MAX = 1000000;

	public static void main (String args[]){
		
		Helper helper = new Helper();
		long sum = 0;
		long number = 0;
		for (long i=2; i<MAX;i++){
			if (helper.isPrimePro(i)){
				System.out.println(i);
				if (sum==i){
					number = sum;
					
				}
				//System.out.println("S: " + sum);
				sum = sum+i;
				
			}
			
		}
		System.out.println("Answer" + number);
	}

}
