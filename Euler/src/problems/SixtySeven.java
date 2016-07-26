package problems;

/*
Problem 67
09 April 2004

By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */

public class SixtySeven {

	public static void main(String args[]) {
		Helper helper = new Helper();
		StringBuilder triangle = helper
				.readTXT("/Users/olvitole/Dropbox/workspace/Euler/src/sixtySeventriangle.txt");
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
