package L10_Feb9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Feb-2019
 *
 */

public class BackTracking {

	static int counter = 0;

	public static void main(String[] args) {

		// boolean[][] board = new boolean[4][4];
		// NQueens2(board, 0, "", 0, 3);

		// System.out.println(counter);

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println(blockedMaze(maze, 0, 0, "", new boolean[4][4]));
		// display(board);
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

	public static void sudoku(int[][] arr) {
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
