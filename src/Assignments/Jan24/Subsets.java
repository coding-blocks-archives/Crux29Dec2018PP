package Assignments.Jan24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class Subsets {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30 };

		for (int num = 0; num < Math.pow(2, arr.length); num++) {

			int i = 0;

			int temp = num;
			while (temp != 0) {

				int rem = temp % 2;
				if (rem == 1) {
					System.out.print(arr[i] + " ");
				}

				i++;
				temp = temp / 2;
			}

			System.out.println();

		}

	}

}
