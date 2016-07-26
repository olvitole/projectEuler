package problems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Helper {

	private static final BigDecimal ZERO_BIG_DECIMAL = new BigDecimal("0.00");
	private static final BigDecimal ONE_BIG_DECIMAL = new BigDecimal("1");

	/**
	 * @deprecated replaced by isPrimePro
	 * @see #isPrimePro(long num) Olvi
	 */
	public boolean isPrime(long num) {
		int counter = 1;
		boolean isPrime = true;
		while (num != 1) {
			counter++;
			if (num == counter) {
				return true;
			}

			if (num % counter == 0) {
				return false;
			}
		}
		return isPrime;
	}

	public boolean isPrimePro(long n) {
		if (n == 1)
			return true;
		if (n < 2)
			return false;
		if (n % 2 == 0)
			// n is an even, so return true iff n is exactly 2
			return (n == 2);
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				// i divides evenly into n, so n is not prime
				return false;
		return true;
	}
	
	public ArrayList<Long> primeFactors(long num) {
		long counter = 1;
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		while (num != 1) {
			counter++;
			while (num % counter == 0) {
				num = num/counter;
				primeFactors.add(counter); 
			}
		}
		return primeFactors;
	}

	
	public ArrayList<Long> primeFactorsPowered(long num) {
		long counter = 1;
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		long curr=1;
		while (num != 1) {
			counter++;
			curr = 1;
			while (num % counter == 0) {
				curr  = curr*counter;
				num = num/counter;
			}
			if (curr!=1)
				primeFactors.add(curr); 
		}
		return primeFactors;
	}
	
	/**
	 * @deprecated replaced by getFactorsList
	 * @see #getDivisors(long num)
	 */

	public HashMap<Long, Long> getFactors(long num) {

		long count = 0;
		long index = 0;
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		while (count <= num) {
			count++;
			if (num % count == 0) {
				index++;
				map.put(index, count);
			}

		}
		return map;
	}

	public ArrayList<Long> getDivisors(long num) {

		long count = 0;
		ArrayList<Long> list = new ArrayList<Long>();
		// list.add(count);
		// log("Helper > getDivisors num: "+ num);
		while (count * count <= num) {
			count++;
			if (num % count == 0) {
				if (!list.contains(count))
					list.add(count);
				if (!list.contains(num / count))
					list.add(num / count);
				// log("Helper > getDivisors count: "+ count +"num/count"+
				// (num/count));
			}

		}
		// Collections.sort(list);
		list.remove(new Long(num));
		return list;
	}

	public long getNoOfFactors(long num) {
		/*
		 * long divs = 0, i, bound = (long) Math.sqrt(num); for (i = 1; i <=
		 * bound; i++) if (num % i == 0) divs += 2; if (bound * bound == num)
		 * divs--; return divs;
		 */

		long count = 0;
		long index = 0;
		while (count <= num) {
			count++;
			if (num % count == 0) {
				index++;
			}

		}
		return index;

	}

	public BigDecimal power(BigDecimal a, BigDecimal b) {

		BigDecimal answer = ONE_BIG_DECIMAL;
		BigDecimal count = ONE_BIG_DECIMAL;
		while (count.compareTo(b) <= 0) {
			count = count.add(ONE_BIG_DECIMAL);
			answer = answer.multiply(a);
		}
		return answer;
	}

	public BigDecimal factorial(BigDecimal num) {
		BigDecimal factorial = ONE_BIG_DECIMAL;
		for (BigDecimal i = ONE_BIG_DECIMAL; i.compareTo(num) <= 0; i = i
				.add(ONE_BIG_DECIMAL)) {
			factorial = factorial.multiply(i);
			//System.out.println(factorial);
		}
		return factorial;
	}

	// A permutation with repetition, P permutation without repetition,
	// C combination without repetition, R combination with repeat
	// http://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
	public BigDecimal combinationPermutation(char operation, BigDecimal n,
			BigDecimal r) {
		BigDecimal result = ONE_BIG_DECIMAL;

		if (operation == 'C') {
			result = factorial(n).divide(
					factorial(r).multiply(factorial(n.subtract(r))));
			System.out.println("Helper >>> combinationPermutation >>> C: n = "
					+ n.toPlainString() + " r: " + r.toPlainString()
					+ " result: " + result.toPlainString());
		} else if (operation == 'P') {
			result = factorial(n).divide(factorial(n.subtract(r)));
			System.out.println("Helper >>> combinationPermutation >>> P: n = "
					+ n.toPlainString() + " r: " + r.toPlainString()
					+ " result: " + result.toPlainString());
		} else if (operation == 'A') {
			result = power(n, r);
			System.out.println("Helper >>> combinationPermutation >>> T: n = "
					+ n.toPlainString() + " r: " + r.toPlainString()
					+ " result: " + result.toPlainString());
		} else if (operation == 'R') {
			result = factorial(n.add(r).subtract(ONE_BIG_DECIMAL)).divide(
					factorial(r).multiply(
							factorial(n.subtract(ONE_BIG_DECIMAL))));
			System.out.println("Helper >>> combinationPermutation >>> T: n = "
					+ n.toPlainString() + " r: " + r.toPlainString()
					+ " result: " + result.toPlainString());
		}
		return result;
	}

	public static void log(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}

	public static void logger(Object aObject) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
		// long start = System.currentTimeMillis();
		System.err.println("Logger: Time >>> " + (System.currentTimeMillis()));
		out.write(aObject.toString());
		out.flush();
	}

	// 0 - perfect; 1 - abundant; -1 deficient
	public int isPerfectAbundantDeficient(long num) {

		int val = -1;
		long sumOfProperDivisors = sumOfDivisors(num);
		if (sumOfProperDivisors == num)
			val = 0;
		else if (sumOfProperDivisors >= num)
			val = 1;

		return val;

	}

	public long sumOfDivisors(long num) {
		ArrayList<Long> divisors = getDivisors(num);
		long sumOfProperDivisors = 0;
		for (int i = 0; i < divisors.size(); i++) {
			sumOfProperDivisors = sumOfProperDivisors + divisors.get(i);
		}

		return sumOfProperDivisors;
	}

	// prime factorization
	// http://www.vogella.de/articles/JavaAlgorithmsPrimeNumbers/article.html
	// all prime numbers under n
	public List<Integer> calcPrimeNumbers(int n) {
		boolean[] isPrimeNumber = new boolean[n + 1]; // boolean defaults to
		// false
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			isPrimeNumber[i] = true;
		}
		for (int i = 2; i < n; i++) {
			if (isPrimeNumber[i]) {
				primes.add(i);
				// Now mark the multiple of i as non-prime number
				for (int j = i; j * i <= n; j++) {
					isPrimeNumber[i * j] = false;
				}
			}

		}

		/*
		 * for (Integer integer : primes) { System.out.println(integer); }
		 * System.out.println("Prime counting function (Pie(N)) : " +
		 * primes.size());
		 */
		return primes;
	}

	public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
		List mapKeys = new ArrayList(passedMap.keySet());
		List mapValues = new ArrayList(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap sortedMap = new LinkedHashMap();

		Iterator valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Object val = valueIt.next();
			Iterator keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Object key = keyIt.next();
				String comp1 = passedMap.get(key).toString();
				String comp2 = val.toString();

				if (comp1.equals(comp2)) {
					passedMap.remove(key);
					mapKeys.remove(key);
					sortedMap.put((String) key, (Double) val);
					break;
				}

			}

		}
		return sortedMap;
	}

	// the n th fibonaci nr
	public long fibonaciNr(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonaciNr(n - 1) + fibonaciNr(n - 2);
	}

	public long fibonaciNr2(long n) {
		long n1 = 0;
		long n2 = 1;
		for (int i = 0; i < n - 2; i++) {
			long temp = n2;
			n2 = n1 + n2;
			n1 = temp;
		}
		return n2 + n1;
	}

	public StringBuilder readTXT(String path) {
		File fFileName = new File(path);

		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(fFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine() + NL);
			}
		} finally {
			scanner.close();
		}
		return text;
	}

	public void print2DArray(long[][] tr) {
		for (int i = 0; i < tr.length; i++) {
			for (int j = 0; j < tr.length; j++) {
				System.out.print(tr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String permuteString(String beginningString, String endingString) throws IOException {
		String newString = "";
		long count =0;
		if (endingString.length() <= 1)
			logger(beginningString + endingString);
		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);
					count++;
					if(count>=1000000)
						break;
					permuteString(beginningString + endingString.charAt(i),
							newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		return newString;
	}

}

// 2790139313751
