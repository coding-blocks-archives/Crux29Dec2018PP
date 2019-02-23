package Assignments.Feb23 ;

public class subsetPrblm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3 };
		subset(arr, 0, 3, "");

	}

	public static int subset(int[] nums, int vidx, int target, String ans) {

		if (vidx == nums.length) {

			if (target == 0) {
				System.out.print(ans + " ");
				return 1;
			}
			return 0;
		}

		int cnt = 0;
		cnt += subset(nums, vidx + 1, target, ans);
		cnt += subset(nums, vidx + 1, target - nums[vidx], ans + nums[vidx] + " ");

		return cnt;
	}

}
