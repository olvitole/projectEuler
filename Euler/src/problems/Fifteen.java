package problems;

import java.math.BigDecimal;

/*
Problem 15
19 April 2002

Starting in the top left corner of a 22 grid, there are 6 routes (without backtracking) to the bottom right corner.


How many routes are there through a 2020 grid?
*/


public class Fifteen {

	private static final BigDecimal DIM = new BigDecimal("20");

	public static void main(String args[]) {
		Helper helper = new Helper();
		BigDecimal answer = helper.combinationPermutation('C',DIM.add(DIM),DIM);
		System.out.println("Answer " + answer.toPlainString());
	}
}


