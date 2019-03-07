package Assignments.March7;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class OnlyLadders {

	public static void main(String[] args) {

		int n = 3;

		int[] ladders = makeLadders(SOE(n));

		int ans = boardPathLadders(0, n, "", ladders);
		System.out.println("\n" + ans);
	}

	public static int boardPathLadders(int curr, int end, String ans, int[] ladders) {

		if (curr == end) {
			System.out.print(ans + "END" + " , ");
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		int count = 0;

		if (ladders[curr] != 0) { // ladders exist
			count += boardPathLadders(ladders[curr], end, ans + curr + " ", ladders);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				count += boardPathLadders(curr + dice, end, ans + curr + " ", ladders);
			}
		}

		return count;

	}

	public static boolean[] SOE(int n) {

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

		return primes;

	}

	public static int[] makeLadders(boolean[] primes) {

		int[] ladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			ladders[left] = right;
			left++;
			right--;

		}

		return ladders;

	}

}
