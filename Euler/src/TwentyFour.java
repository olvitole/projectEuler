

/*
Lexicographic permutations
Problem 24
Published on Friday, 16th August 2002, 06:00 pm; Solved by 49822A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?




/// solution of the milionth record 
// print copy paste the output and find the milonth.
// 2783915460

// public class PermutationsLex {

*/

public class TwentyFour {
  
public static void show(int[] a) {
    	//System.out.println("Value is: " + a[1000000]);
        for (int i = 0; i < a.length; i++)
        	System.out.print(a[i]);
        System.out.println();
            //System.out.printf("%d", a[i]);
       // System.out.printf("\n");
        
    } 

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(int[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);

        return true;
    }

    public static void perm(int N) {

        // initialize permutation
        int[] a  = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;

        // print permutations
        show(a);
        while (hasNext(a))
           show(a);
    }


    public static void main(String[] args) {
        int N = Integer.parseInt("10");
        perm(N);
    }
}

