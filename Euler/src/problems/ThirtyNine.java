package problems;

import java.util.HashSet;
import java.util.Set;

/*
Integer right triangles
Problem 39
Published on Friday, 14th March 2003, 06:00 pm; Solved by 51425; Difficulty rating: 5%
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

 */

public class ThirtyNine {

	public static void main(String args[]) {

		// System.out.println("Test 120: " + findMaxPerValueOfP(120));

		int p = 1000;
		int vp = findValueOfP(p);

		System.out.println(">>>Answer: " + vp);

	}

	// 349966
	// 160000
	// 73682

	private static int findValueOfP(int p) {

		int max = -1;
		int maxI = -1;
		for (int i = 3; i <= p; i++) {
			int tempMax = findMaxPerValueOfP(i);

			if (tempMax > max){
				max = tempMax;
				maxI = i;
			}
		}

		return maxI;
	}

	private static int findMaxPerValueOfP(int p) {

		Set<Triangle> st = new HashSet<Triangle>();

		// p/2 bc kateti will be max sa gjysma
		for (int i = 1; i <= p / 2; i++) {
			for (int j = 1; j <= p / 2; j++) {
				int k1 = i;
				int k2 = j;
				int k3 = p - k1 - k2;

				Triangle tri = isValid(k1, k2, k3);

				if (tri != null) {

					if (right(tri)) {
						st.add(tri);
					}
				}

			}
		}
		System.out.println("P: " +p + " Tri "+ st);

		return st.size();
	}

	private static boolean right(Triangle tri) {
		return tri.h * tri.h == tri.k1 * tri.k1 + tri.k2 * tri.k2;
	}

	private static Triangle isValid(int k1, int k2, int k3) {
		if (k1 == 0 || k2 == 0 || k3 == 0)
			return null;
		if (k1 >= k2 && k2 >= k3)
			return new ThirtyNine.Triangle(k1, k2, k3);
		if (k1 >= k2 && k3 >= k2)
			return new ThirtyNine.Triangle(k1, k3, k2);
		if (k2 >= k3 && k3 >= k1)
			return new ThirtyNine.Triangle(k2, k3, k1);
		if (k2 >= k3 && k1 >= k3)
			return new ThirtyNine.Triangle(k2, k1, k3);
		else if (k3 >= k2 && k2 >= k1)
			return new ThirtyNine.Triangle(k3, k2, k1);
		else
			return new ThirtyNine.Triangle(k3, k1, k2);

	}

	static class Triangle {

		@Override
		public String toString() {
			return "Triangle [h=" + h + ", k1=" + k1 + ", k2=" + k2 + "]";
		}

		public Triangle(int h, int k1, int k2) {
			this.h = h;
			this.k1 = k1;
			this.k2 = k2;
		}

		int h;
		int k1;
		int k2;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + h;
			result = prime * result + k1;
			result = prime * result + k2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triangle other = (Triangle) obj;
			if (h != other.h)
				return false;
			if (k1 != other.k1)
				return false;
			if (k2 != other.k2)
				return false;
			return true;
		}

	}
}
