package problems;

/*
 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 */

public class Three {

	public static void main(String args[]) {

		long num = new Long("600851475143");

		boolean inFound = false;
		int count = 1;
		long answer = -1;
		while (num != 1) {
			while (!inFound) {
				count++;
				System.out.println(count);
				if (num % count == 0 || count == num) {
					answer = count;
					System.out.println(answer);
					inFound = true;
					num = num / count;
					System.out.println(num);
				}
			}
			inFound = false;
			count = 1;
		}

	}

}
