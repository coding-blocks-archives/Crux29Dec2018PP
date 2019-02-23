package doubt_class;

public class Gen_sorted_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };

		int[] C = new int[A.length + B.length];

		generateArrays(A, B, C, 0, 0, 0, true);

	}

	public static void generateArrays(int[] A, int[] B, int[] C, int i, int j, int len, boolean flag) {

		if (flag) {

			if (len != 0) {

				PrintArray(C, len + 1);
			}

			for (int k = i; k < A.length; k++) {

				if (len == 0) {
					C[len] = A[k];

					generateArrays(A, B, C, k + 1, j, len, false);
				} else if (A[k] > C[len]) {

					C[len + 1] = A[k];
					generateArrays(A, B, C, k + 1, j, len + 1, false);
				}
			}
		} else {

			for (int l = j; l < B.length; l++) {

				if (B[l] > C[len]) {

					C[len + 1] = B[l];
					generateArrays(A, B, C, i, l + 1, len + 1, true);
				}
			}

		}

	}

	public static void PrintArray(int[] nums, int n) {

		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
