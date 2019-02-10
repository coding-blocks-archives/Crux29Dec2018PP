package L10_Feb9;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2019
 *
 */

public class BackTracking {

	public static void main(String[] args) {

		// boolean[][] board = new boolean[4][4];
		// NQueens2(board, 0, "", 0, 3);

		// int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0
		// } };
		// System.out.println(blockedMaze(maze, 0, 0, "", new boolean[4][4]));
		// display(board);

		Scanner scn = new Scanner(System.in);

		int[][] arr = new int[9][9];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = scn.nextInt();
			}

		}

		sudoku(arr, 0, 0);
	}

	public static void NQueens(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				NQueens(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static void display(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		return true;

	}

	public static void NQueens2(boolean[][] board, int row, String ans, int qpsf, int total) {

		if (qpsf == total) {
			System.out.println(ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				NQueens2(board, row + 1, ans + "{" + row + "-" + col + "}", qpsf + 1, total);
				board[row][col] = false;
			}
		}

		NQueens2(board, row + 1, ans, qpsf, total);
	}

	public static int blockedMaze(int[][] maze, int cr, int cc, String ans, boolean[][] visited) {

		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println(ans);
			return 1;
		}

		if (cr < 0 || cr >= maze.length || cc < 0 || cc >= maze[0].length || maze[cr][cc] == 1 || visited[cr][cc]) {
			return 0;
		}

		visited[cr][cc] = true;

		// DTLR
		int d = blockedMaze(maze, cr + 1, cc, ans + "D", visited);
		int t = blockedMaze(maze, cr - 1, cc, ans + "T", visited);
		int l = blockedMaze(maze, cr, cc - 1, ans + "L", visited);
		int r = blockedMaze(maze, cr, cc + 1, ans + "R", visited);

		visited[cr][cc] = false;

		return d + t + l + r;
	}

	public static void sudoku(int[][] arr, int row, int col) {

		if (row == arr.length) {
			display(arr);
			return;
		}

		if (col == arr[0].length) {
			sudoku(arr, row + 1, 0);
			return;
		}

		if (arr[row][col] != 0) {
			sudoku(arr, row, col + 1);
			return;
		}

		// self work : 1->9
		for (int i = 1; i <= 9; i++) {

			if (isItSafe(arr, row, col, i)) {
				arr[row][col] = i;

				sudoku(arr, row, col + 1);

				arr[row][col] = 0;
			}
		}

	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

	public static boolean isItSafe(int[][] arr, int row, int col, int val) {

		return isItSafeRow(arr, row, val) && isItSafeCol(arr, col, val) && isItSafeCell(arr, row, col, val);
	}

	public static boolean isItSafeRow(int[][] arr, int row, int val) {

		for (int col = 0; col < arr[0].length; col++) {
			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(int[][] arr, int col, int val) {

		for (int row = 0; row < arr.length; row++) {
			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCell(int[][] arr, int row, int col, int val) {

		int rs = row - row % 3;
		int cs = col - col % 3;

		for (int r = rs; r < rs + 3; r++) {

			for (int c = cs; c < cs + 3; c++) {

				if (arr[r][c] == val) {
					return false;
				}
			}
		}

		return true;

	}

}
