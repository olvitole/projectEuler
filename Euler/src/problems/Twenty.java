package problems;

import java.math.BigDecimal;

/*

Problem 20
21 June 2002

n! means n  (n  1)  ...  3  2  1

For example, 10! = 10  9  ...  3  2  1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 */


public class Twenty {


	private static final int NUM = 100;

	public static void main(String args[]){
		
		Helper helper = new Helper();
		BigDecimal factorial = helper.factorial(new BigDecimal(NUM));
		
		System.out.println("Factorial "+factorial.toPlainString());
		
		int sum = 0;
		String factorialString = factorial.toPlainString();
		for (int i=0; i<factorialString.length();i++){
			sum = sum+Integer.parseInt(factorialString.charAt(i)+"");
		}
		
		System.out.println("Answer: "+ sum);			
		
	}
	
}
