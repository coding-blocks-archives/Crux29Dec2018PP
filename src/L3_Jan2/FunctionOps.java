package L3_Jan2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printPrimes(10, 100);
		printArmstrong(10, 1000);
	}

	public static void printPrimes(int lo, int hi) {

		for (int i = lo; i <= hi; i = i + 1) {

			boolean ans = isPrime(i);
			if (ans == true) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int n) {

		boolean flag = true;
		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = false;
			}
			div = div + 1;
		}

		return flag;
	}

	public static void printArmstrong(int lo, int hi) {

		for (int i = lo; i <= hi; i = i + 1) {

			boolean ans = isArmstrong(i);
			if (ans == true) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int n) {

		int nod = numberOfDigits(n);
		int temp = n;
		int ans = 0;
		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(rem, nod);
			n = n / 10;
		}

		if (temp == ans) {
			return true;
		} else {
			return false;
		}
	}
 
	public static int numberOfDigits(int n) {
		int count = 0;

		while (n != 0) {
			count = count + 1;
			n = n / 10;
		}

		return count;

	}

}
