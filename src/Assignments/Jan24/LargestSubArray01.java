package Assignments.Jan24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class LargestSubArray01 {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 0, 1, 0, 1, 1 };

		int si = -1;
		int ei = -1;
		int max = -1;

		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {

				int num0 = 0;
				int num1 = 0;

				for (int k = i; k <= j; k++) {

					if (arr[k] == 1) {
						num1++;
					} else {
						num0++;
					}
				}

				int length = j - i + 1;
				if (num1 == num0 && length > max) {

					max = length;
					si = i;
					ei = j;

				}

			}

		}

		System.out.println(si + " " + ei);

	}

}
