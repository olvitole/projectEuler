package problems;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem 42
25 April 2003

The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
	
*/


public class FourtyTwo {
	
	
	
	private static final int MAX_BASE_POW = 1000;
	private static final BigDecimal zeroDecimal = new BigDecimal("0");
	private static final BigDecimal LAST_DIGITS = new BigDecimal("10000000000");
	
	public static void main(String args[]) {
		Helper helper = new Helper();
		StringBuilder text = helper
				.readTXT("/Users/olvitole/Dropbox/workspace/Euler/src/wordsFourtyTwo.txt");
		System.out.print(text);
		
		System.out.println("Text read in: " + text);
		String names = text.toString().replace('"', ' ');
		names = names.trim();
		System.out.println("Text read in: " + names);
		
		String[] namesArray = null;
		namesArray = names.split(" , ");
		for (int i=0; i<namesArray.length;i++)
			System.out.print(namesArray[i]+" ");
		System.out.println();
		
		
		
		
		
		int maxLength =0;
		int tempmax = 0;
		for (int i=0; i<namesArray.length;i++){
			tempmax = namesArray[i].length();
			if (maxLength< tempmax) 
			maxLength = tempmax;
		}
		System.out.println("maxLength" + maxLength);
		System.out.println();
		
		// alphabet z index = 26
		int maxTriabgleUpperLimit = maxLength*26;

		
		
		
		
		
		ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();
		int t=0;
		int n = 1;
		while(t<maxTriabgleUpperLimit){
			t = n*(n+1)/2;
			System.out.print(t+", ");
			triangleNumbers.add(t);
			n++;
		}
		System.out.println();
		
		
		
		Arrays.sort(namesArray);
		int answer =0;
		int score =0;
		for (int i=0; i<namesArray.length;i++){
			System.out.println(i+": "+namesArray[i]+" :::");
			score = 0;
			int letter =0;
			for (int j =0;j<namesArray[i].length();j++){
				letter = namesArray[i].charAt(j)-64;
				System.out.println(" l : "+j+" " + letter);
				score = score +letter;
			}
			
			System.out.println("Sum "+ score);
				
			if(triangleNumbers.contains(score))
				answer++;
		}
		
		System.out.println("Answer "+ answer);

	}
}
