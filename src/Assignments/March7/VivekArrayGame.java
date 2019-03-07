package Assignments.March7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class VivekArrayGame {

	public static void main(String[] args) {

		int[] arr = { 0, 0, 0, 4, 1, 0, 1, 1, 0, 1 };
		System.out.println(arrayGame(arr, 0, arr.length - 1));
	}

	public static int arrayGame(int[] arr, int lo, int hi) {

		for (int mid = lo; mid < hi; mid++) {

			int sum1 = 0;
			for (int i = lo; i <= mid; i++) {
				sum1 += arr[i];
			}

			int sum2 = 0;
			for (int i = mid + 1; i <= hi; i++) {
				sum2 += arr[i];
			}

			if (sum1 == sum2) {

				int ans1 = arrayGame(arr, lo, mid);
				int ans2 = arrayGame(arr, mid + 1, hi);

				return Math.max(ans1, ans2) + 1;
			}

		}

		return 0;

	}
}
