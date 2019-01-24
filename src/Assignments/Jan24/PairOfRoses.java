package Assignments.Jan24;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class PairOfRoses {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5, 6, 7, 8 };
		int target = 12;

		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		int fi = 0;
		int fj = 0;

		while (i < j) {

			if (arr[i] + arr[j] > target) {
				j--;
			} else if (arr[i] + arr[j] < target) {
				i++;
			} else {
				fi = arr[i];
				fj = arr[j];
				i++;
				j--;

			}

		}

		System.out.println(fi + " and " + fj);

	}

}
