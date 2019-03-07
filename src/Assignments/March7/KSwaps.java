package Assignments.March7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class KSwaps {

	static int ans = 0;

	public static void main(String[] args) {

		int[] arr = { 2, 6, 3, 1 };
		KSwaps(arr, 2);

		System.out.println(ans);
	}

	public static void KSwaps(int[] arr, int k) {

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

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void calculateMax(int[] arr) {

		String pans = "";

		for (int i = 0; i < arr.length; i++) {
			pans += arr[i];
		}

		ans = Math.max(ans, Integer.parseInt(pans));
	}
}
