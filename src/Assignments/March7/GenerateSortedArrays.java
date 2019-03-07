package Assignments.March7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class GenerateSortedArrays {

	public static void main(String[] args) {

		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };

		int[] C = new int[A.length + B.length];

		sortedArray(A, B, C, 0, 0, 0, true);

	}

	public static void sortedArray(int[] A, int[] B, int[] C, int avidx, int bvidx, int cvidx, boolean flag) {

		// A consume : true
		// B consume : false
		if (flag) {

			display(C, cvidx);

			for (int i = avidx; i < A.length; i++) {

				if (cvidx == 0 || A[i] > C[cvidx - 1]) {
					C[cvidx] = A[i];
					sortedArray(A, B, C, avidx + 1, bvidx, cvidx + 1, !flag);
				}

			}

		} else {

			for (int i = bvidx; i < B.length; i++) {

				if (B[i] > C[cvidx - 1]) {
					C[cvidx] = B[i];
					sortedArray(A, B, C, avidx, bvidx + 1, cvidx + 1, !flag);
				}

			}

		}

	}

	public static void display(int[] C, int idx) {

		if (idx == 0) {
			return;
		}

		for (int i = 0; i < idx; i++) {
			System.out.print(C[i] + " ");
		}
		System.out.println();
	}

}
