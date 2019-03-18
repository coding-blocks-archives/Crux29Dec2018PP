package Assignments.March7;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class KSwaps {

	static int ans = 0;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// take char array instead of int array
		char[] arr = scn.next().toCharArray();
		int k = scn.nextInt();

		KSwaps(arr, k);

		if (ans == 0) {
			calculateMax(arr);
		}

		System.out.println(ans);

	}

	public static void KSwaps(char[] arr, int k) {

		// base case is imp
		if (k == 0) {
			return;
		}

		for (int i = 0; i <= arr.length - 2; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] < arr[j]) {

					swap(arr, i, j);

					calculateMax(arr);

					KSwaps(arr, k - 1);

					swap(arr, i, j); // undo the changes

				}
			}
		}

	}

	public static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void calculateMax(char[] arr) {

		String pval = new String(arr);
		ans = Math.max(ans, Integer.parseInt(pval));
	}
}
