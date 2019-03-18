package Assignments.March16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Mar-2019
 *
 */

public class MaximumIndex {

	public static void main(String[] args) {

		int[] arr = { 80, 40, 10, 30, 60, 70, 15 };

		int[] leftMin = new int[arr.length];
		leftMin[0] = arr[0];

		for (int i = 1; i < leftMin.length; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
		}

		int[] rightMax = new int[arr.length];
		rightMax[rightMax.length - 1] = arr[arr.length - 1];

		for (int i = rightMax.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		int ans = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;

		while (i < leftMin.length && j < rightMax.length) {

			if (leftMin[i] < rightMax[j]) {
				ans = Math.max(ans, j - i);
				j++;
			} else {
				i++;
			}

		}
		
		System.out.println(ans);

	}
}
