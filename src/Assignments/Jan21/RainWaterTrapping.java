package Assignments.Jan21;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(waterTrapping(arr));
	}

	public static int waterTrapping(int[] arr) {

		int[] left = new int[arr.length];

		left[0] = arr[0];

		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		int[] right = new int[arr.length];

		right[right.length - 1] = arr[arr.length - 1];

		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++)
			ans += Math.min(left[i], right[i]) - arr[i];

		return ans;
	}

}
