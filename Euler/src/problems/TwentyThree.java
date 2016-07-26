package problems;

/*
 Problem 23
 02 August 2002

 A perfect number is a number for which the sum of its proper 
 divisors is exactly equal to the number. 
 For example, the sum of the proper divisors of 28 would 
 be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper 
 divisors is less than n and it is called abundant 
 if this sum exceeds n.

 As 12 is the smallest abundant number, 
 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written 
 as the sum of two abundant numbers is 24. 
 By mathematical analysis, it can be shown that all 
 integers greater than 28123 can be written as the sum of 
 two abundant numbers. However, this upper limit 
 cannot be reduced any further by analysis even though it is 
 known that the greatest number that cannot be expressed as the sum 
 of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written 
 as the sum of two abundant numbers.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TwentyThree {

	// private static final int LIMIT = 28123;

	private static final int LIMIT = 28123;

	public static void main(String args[]) {
		Helper helper = new Helper();
		int answer = 0;
		ArrayList<Integer> abundantNums = new ArrayList<Integer>();
		for (int c = 1; c <= LIMIT; c++) {
			int is = helper.isPerfectAbundantDeficient(c);
			// System.out.println(c + " id " + is);
			if (is > 0) {
				abundantNums.add(c);
			}
			// answer = answer + c;
		}
		
		int abundantNumsSize = abundantNums.size();

		System.out.println("abundantNums.size() " + abundantNumsSize);

		/*
		 * old logic
		 * 
		 * for (long i = 1; i <= LIMIT; i++) { boolean itis = false; for (int j
		 * = 1; j <= (i / 2); j++) { if (i%2000==0)
		 * System.out.println("i: "+i+" j: "+j +" i-j"+ (i-j)); if
		 * (abundantNums.contains(i) && abundantNums.contains(((i) - j))) { itis
		 * = true; break; //System.out.println(true); } if (!itis) { answer =
		 * answer + i; } } }
		 */

		HashMap<Integer, String> abundantNumsAsSum = new HashMap<Integer, String>();
		for (int i = 0; i < abundantNumsSize; i++) {
			for (int j = 0; j < abundantNumsSize; j++) {
				int sum = abundantNums.get(i) + abundantNums.get(j);
				if (sum <= LIMIT) {
					// if (!abundantNumsAsSum.contains(sum))
					abundantNumsAsSum.put(sum, null);
				}
			}
		}
		System.out.println("abundantNumsAsSum.size() "+ abundantNumsAsSum.size());
		System.out.println(abundantNumsAsSum);
		Set<Integer> abundantNumsAsSumSet =  abundantNumsAsSum.keySet();
		
		
		boolean[] allNumList = new boolean[LIMIT+1];
		//Arrays.fill(allNumList, Boolean.TRUE); 
		Iterator it = abundantNumsAsSumSet.iterator();   
		System.out.println(allNumList.length);

		while(it.hasNext()) {
			int index = (Integer) it.next();
			System.out.println(index);

			allNumList[index]= Boolean.TRUE;
		}
		for (int i=0; i< allNumList.length;i++){
			if(!allNumList[i]){
				System.out.print(i+", ");
				answer = answer+i;
				
			}
		}
		System.out.println();
		System.out.println("Answer " + answer);
	}

}

/// Answer 4179871

// Answer 917054327264
// 2789743876248