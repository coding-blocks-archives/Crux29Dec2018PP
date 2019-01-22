package Assignments.Jan21;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class CalculateTheSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		int q = scn.nextInt();

		while (q > 0) {

			int idx = scn.nextInt();

			long[] narr = new long[arr.length];

			for (int i = 0; i < arr.length; i++) {

				int ni = i - idx;

				if (ni < 0) {
					ni = ni + arr.length;
				}

				narr[i] = arr[i] + arr[ni];

			}

			arr = narr;
			q--;

		}

		long sum = 0;

		for (long val : arr) {
			sum = (sum + val) % 1000000007;
		}

		System.out.println(sum);

	}

}
