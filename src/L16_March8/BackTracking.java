package L16_March8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Mar-2019
 *
 */

public class BackTracking {

	static int count = 0;

	public static void main(String[] args) {

		// QueenPermutation(new boolean[4], 0, 2, "");
		// QueenCombination(new boolean[4], 0, 2, "", -1);
		// CoinChange(new int[] { 2, 3, 5, 6 }, 10, "", 0);
		// QueenBoxRespect(new boolean[4], 0, 0, 2, "");
		// Queen2DCombination(new boolean[4][4], 0, 0, 0, 3, "");
		// NKnights(new boolean[4][4], 0, 0, 0, 4, "");

		int[][] board = new int[8][8];
		board[0][0] = 1;

		boolean res = KnightsTour(board, 2, 0, 0);
		display(board);
		System.out.println(res);

		// String str = "blolbll";
		// WordBreakPalindrome(str, 0, str.length() - 1, "");

	}

	public static void QueenPermutation(boolean[] board, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = 0; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				QueenPermutation(board, qpsf + 1, tq, ans + "q" + (qpsf + 1) + "b" + i + " ");
				board[i] = false;
			}

		}

	}

	public static void QueenCombination(boolean[] board, int qpsf, int tq, String ans, int lastCellUsed) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = lastCellUsed + 1; i < board.length; i++) {

			board[i] = true;
			QueenCombination(board, qpsf + 1, tq, ans + "q" + (qpsf + 1) + "b" + i + " ", i);
			board[i] = false;

		}

	}

	public static void CoinChange(int[] denom, int amt, String ans, int lastCoinUsed) {

		if (amt == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = lastCoinUsed; i < denom.length; i++) {
			if (amt >= denom[i])
				CoinChange(denom, amt - denom[i], ans + denom[i], i);
		}

	}

	public static void QueenBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (col == board.length) {
			return;
		}

		// yes
		board[col] = true;
		QueenBoxRespect(board, col + 1, qpsf + 1, tq, ans + "q" + (qpsf + 1) + "b" + col + " ");
		board[col] = false;

		QueenBoxRespect(board, col + 1, qpsf, tq, ans);

	}

	public static void Queen2DCombination(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		if (col == board[0].length) {
			Queen2DCombination(board, row + 1, 0, qpsf, tq, ans);
			return;
		}

		// yes
		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			Queen2DCombination(board, row, col + 1, qpsf + 1, tq,
					ans + "q" + (qpsf + 1) + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}

		// no
		Queen2DCombination(board, row, col + 1, qpsf, tq, ans);

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

		// horizontally left
		r = row;
		c = col;
		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}

		return true;

	}

	public static void NKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {

		if (kpsf == tk) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		if (col == board[0].length) {
			NKnights(board, row + 1, 0, kpsf, tk, ans);
			return;
		}

		// yes
		if (isItSafeToPlaceKnight(board, row, col)) {
			board[row][col] = true;
			NKnights(board, row, col + 1, kpsf + 1, tk, ans + "k" + (kpsf + 1) + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}

		NKnights(board, row, col + 1, kpsf, tk, ans);

	}

	public static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {

		int[] rowsArr = { -1, -2, -2, -1 };
		int[] colArr = { -2, -1, 1, 2 };

		for (int idx = 0; idx < rowsArr.length; idx++) {

			int nr = row + rowsArr[idx];
			int nc = col + colArr[idx];

			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc]) {
				return false;
			}
		}

		return true;
	}

	public static boolean KnightsTour(int[][] board, int move, int row, int col) {

		if (move == ((board.length * board[0].length) + 1)) {
			return true;
		}

		int rowArr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int colArr[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int idx = 0; idx < 8; idx++) {

			int nr = row + rowArr[idx];
			int nc = col + colArr[idx];

			if (isItSafe(board, nr, nc)) {

				board[nr][nc] = move;

				boolean res = KnightsTour(board, move + 1, nr, nc);

				if (res)
					return true;

				board[nr][nc] = 0;

			}
		}

		return false;

	}

	public static boolean isItSafe(int[][] board, int row, int col) {

		if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void display(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------------------");
	}

	public static void WordBreakPalindrome(String str, int si, int ei, String ans) {

		if (si > ei) {
			System.out.println(ans);
			return;
		}

		for (int i = si + 1; i <= ei + 1; i++) {

			String ss = str.substring(si, i);

			if (isPalindrome(ss)) {
				WordBreakPalindrome(str, i, ei, ans + ss + " ");
			}

		}

	}

	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;

	}

}
