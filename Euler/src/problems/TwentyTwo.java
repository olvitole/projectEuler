package problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 Problem 22
 19 July 2002

 Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938  53 = 49714.

 What is the total of all the name scores in the file?
 */

public class TwentyTwo {

	public static void main(String args[]) throws FileNotFoundException {

		// Integer[] a = new Integer[9];

		// int a=

		// System.out.println(8*7*6*5*4*3*2*1);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Helper helper = new Helper();
		StringBuilder text = helper.readTXT("/Users/olvitole/Dropbox/workspace/Euler/src/namesTwentyTwo.txt");
		System.out.println("Text read in: " + text);
		String names = text.toString().replace('"', ' ');
		names = names.trim();
		System.out.println("Text read in: " + names);
		
		String[] namesArray = null;
		namesArray = names.split(" , ");
		for (int i=0; i<namesArray.length;i++)
			System.out.print(namesArray[i]+" ");
		System.out.println();
		Arrays.sort(namesArray);
		int answer =0;
		int score =0;
		for (int i=0; i<namesArray.length;i++){
			System.out.print(i+": "+namesArray[i]+" :::");
			score = 0;
			int letter =0;
			for (int j =0;j<namesArray[i].length();j++){
				letter = namesArray[i].charAt(j)-64;
				System.out.print(" l : "+j+" " + letter);
				score = score +letter;
			}
				
			score = (i+1)*score;
			answer = answer+score;
		}
		System.out.println("Answer: "+ answer);
		System.out.println("Answer: "+ answer);
	} 

}

// Answer: 871198282 
// Answer: 871198282

