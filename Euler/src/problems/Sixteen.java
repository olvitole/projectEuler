package problems;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

/*

 Problem 16
03 May 2002

215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?

*/

public class Sixteen {

	private static final int BASE = 2;
	private static final int POWER = 1000;

	public static void main(String args[]) {

	Helper helper = new Helper();
	BigDecimal result = helper.power(new BigDecimal(BASE), new BigDecimal(POWER));
	
	String resultString = result.toString();
	System.out.println("resultString" + resultString);
	double sum = 0;
	for (int i=0; i<resultString.length();i++){
		sum = sum + Double.parseDouble(resultString.charAt(i)+"");
		
	}
	
		System.out.println("Answer "+sum);
	}
}
