package problems;

import java.io.IOException;

/*
 Problem 18
 31 May 2002

 By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom of the triangle below:

 75
 95 64
 17 47 82
 18 35 87 10
 20 04 82 47 65
 19 01 23 75 03 34
 88 02 77 73 07 63 67
 99 65 04 28 06 16 70 92
 41 41 26 56 83 40 80 70 33
 41 48 72 33 47 32 37 16 94 29
 53 71 44 65 25 43 91 52 97 51 14
 70 11 33 28 77 73 17 78 39 68 17 57
 91 71 52 38 17 14 91 43 58 50 27 29 48
 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

 NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)


 */

public class Eighteen {

	public static void main(String args[]) {
		Helper helper = new Helper();
		StringBuilder triangle = helper
				.readTXT("/Users/olvitole/Dropbox/workspace/Euler/src/eighteen.txt");
		System.out.print(triangle);

		String rows[] = triangle.toString().split(
				System.getProperty("line.separator"));
		int rl = rows.length;
		long tr[][] = new long[rl][rl];

		for (int i = 0; i < rl; i++) {
			System.out.println(rows[i]);
			String col[] = rows[i].split(" ");
			for (int j = 0; j <= i; j++) {
				tr[i][j] = Long.parseLong(col[j]);
			}
		}

		System.out.println("Read: ");
		helper.print2DArray(tr);
/*
		// did not work
		int i = 1;
		int x = 0;
		int y = 0;
		long maxSum = tr[x][y];
		long num = 0;
		while (x < tr.length - 1) {
			if (tr[x + 1][y] > tr[x + 1][y + 1]) {
				num = tr[x + 1][y];
				maxSum += num;
				x++;
			} else {
				num = tr[x + 1][y + 1];
				maxSum += num;
				x++;
				y++;
			}
			System.out.println("num: " + num + " Sum " + maxSum);
			i++;
		}
		System.out.println("Answer: " + maxSum);
*/
		 int x = tr.length - 1;
		// int y=0;
		// long maxSum = tr[x][y];
		// long num = 0;
		while (x > 0) {
			for (int i = 0; i < x ; i++) {
				if (tr[x][i] > tr[x][i + 1])
					tr[x - 1][i] = tr[x - 1][i] + tr[x][i];
				else
					tr[x - 1][i] = tr[x - 1][i] + tr[x][i + 1];
			}
			x--;
			// y--;
			System.out.println("num: " + x + " Sum " + tr[1][1]);

		}
		helper.print2DArray(tr);
		System.out.println("Answer: " + tr[0][0]);
	}

}
