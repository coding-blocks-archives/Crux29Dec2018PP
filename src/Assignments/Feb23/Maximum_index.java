package Assignments.Feb23 ;

public class Maximum_index {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(MaxIndex(arr));
	}

	public static int MaxIndex(int[] nums) {

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			left[i] = Math.min(left[i - 1], nums[i]);
		}

		right[right.length - 1] = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; i--) {

			right[i] = Math.max(right[i + 1], nums[i]);
		}

		int i = 0;
		int j = 0;
		int maxDiff = 0;
		while (i < nums.length && j < nums.length) {

			if (left[i] < right[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}

		return maxDiff;

	}
}
