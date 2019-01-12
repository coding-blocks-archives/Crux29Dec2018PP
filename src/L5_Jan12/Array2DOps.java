package L5_Jan12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jan-2019
 *
 */

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput();
		// display(arr);
		//
		// int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15
		// }, { 16, 17, 18, 19, 20 } };

		int[][] one = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] two = { { 7 }, { 8 }, { 9 } };
		// waveDisplay(arr);
//		spiralDisplay(arr);
		display(matrixMultiplication(one, two));
	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int row = 0; row < arr.length; row++) {

			System.out.println("Cols for " + row + " row ?");
			int cols = scn.nextInt();

			arr[row] = new int[cols];

			// ask values from user
			for (int col = 0; col < arr[row].length; col++) {

				System.out.println("[" + row + "-" + col + "]");
				arr[row][col] = scn.nextInt();

			}

		}

		return arr;
	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}

	}

	public static void verticalDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			for (int row = 0; row < arr.length; row++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}

	}

	public static void waveDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}

		}
	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int count = 0;
		int nel = arr.length * arr[0].length;

		while (count < nel) {

			// first col
			for (int row = minRow; count < nel && row <= maxRow; row++) {
				System.out.print(arr[row][minCol] + " ");
				count++;
			}
			minCol++;

			// bottom row
			for (int col = minCol; count < nel && col <= maxCol; col++) {
				System.out.print(arr[maxRow][col] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int row = maxRow; count < nel && row >= minRow; row--) {
				System.out.print(arr[row][maxCol] + " ");
				count++;
			}

			maxCol--;

			// top row
			for (int col = maxCol; count < nel && col >= minCol; col--) {
				System.out.print(arr[minRow][col] + " ");
				count++;
			}
			minRow++;

		}

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;

		int r2 = two.length;
		int c2 = two[0].length;

		if (c1 != r2) {
			return null; // matrix multiplication not possible
		}

		int[][] ans = new int[r1][c2];

		for (int i = 0; i < ans.length; i++) {

			for (int j = 0; j < ans[0].length; j++) {

				int sum = 0;

				for (int k = 0; k < c1; k++) {
					sum += one[i][k] * two[k][j];
				}

				ans[i][j] = sum;

			}

		}

		return ans;
	}

}
