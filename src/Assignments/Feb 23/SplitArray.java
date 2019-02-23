package doubt_class;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 3, 4, 5 };
		System.out.println(split(arr, 0, 0, "", 0, ""));

	}

	public static int split(int[] nums, int vidx, int sum1, String asf1, int sum2, String asf2) {

		if (vidx == nums.length) {

			if (sum1 == sum2) {
				System.out.println(asf1 + "and " + asf2);
				return 1;
			}

			return 0;

		}
		int cnt = 0;
		cnt += split(nums, vidx + 1, sum1 + nums[vidx], asf1 + nums[vidx] + " ", sum2, asf2);
		cnt += split(nums, vidx + 1, sum1, asf1, sum2 + nums[vidx], asf2 + nums[vidx] + " ");

		return cnt;

	}

}
