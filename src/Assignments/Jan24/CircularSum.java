package Assignments.Jan24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class CircularSum {

	public static void main(String[] args) {

		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };

		int[] narr = new int[arr.length * 2];

		for (int i = 0; i < arr.length; i++) {
			narr[i] = arr[i];
			narr[i + arr.length] = arr[i];
		}

		int maxSum = 0;

		for (int i = 0; i < arr.length; i++) {

			int sum = 0;
			for (int j = i; j <= i + arr.length - 1; j++) {

				sum += narr[j];

				if (sum > maxSum) {
					maxSum = sum;
				}

			}

		}

		System.out.println(maxSum);

	}

}
