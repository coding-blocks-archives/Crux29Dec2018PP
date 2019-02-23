package Assignments.Feb23 ;

public class ArrayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 2, 2, 2 };
		System.out.println(game(arr, 0, arr.length - 1));
	}

	public static int game(int[] arr, int si, int ei) {

		if (si > ei) {
			return 0;
		}

		int ans = 0;
		for (int i = si; i < ei; i++) {

			int fh = sum(arr, si, i);
			int sh = sum(arr, i + 1, ei);

			if (fh == sh) {

				int rr1 = game(arr, si, i);
				int rr2 = game(arr, i + 1, ei);

				ans = Math.max(rr1, rr2) + 1;

			}
		}

		return ans;

	}

	public static int sum(int[] arr, int i, int j) {

		int sum = 0;

		for (int k = i; k <= j; k++) {
			sum += arr[k];
		}

		return sum;
	}

}
