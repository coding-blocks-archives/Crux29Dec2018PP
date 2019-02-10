package L11_Feb10;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Feb-2019
 *
 */

public class TimeSpaceQs {

	public static void main(String[] args) {

		// System.out.println(polynomial(3, 6));
		// System.out.println(palindromicSSCount("nitinn"));

		SOE(25);

	}

	public static int polynomial(int x, int n) {

		int multiplier = x;
		int sum = 0;

		for (int coeff = n; coeff >= 1; coeff--) {

			sum = sum + coeff * multiplier;
			multiplier = multiplier * x;

		}

		return sum;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int ans = 0;

		int sp = power(x, n / 2);

		if (n % 2 == 0) {
			ans = sp * sp;
		} else {
			ans = sp * sp * x;
		}

		return ans;

	}

	public static int palindromicSSCount(String str) {

		int count = 0;
		// odd length palindromic ss
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}

		}

		// even length palindromic ss
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}

		}

		return count;
	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}

		// printing
		for (int i = 0; i < primes.length; i++) {

			if (primes[i]) {
				System.out.println(i);
			}
		}

	}

}
