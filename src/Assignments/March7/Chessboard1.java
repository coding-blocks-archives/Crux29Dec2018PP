package Assignments.March7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class Chessboard1 {

	public static void main(String[] args) {

		int n = 3;

		System.out.println("\n" + chessboard1(0, 0, n - 1, n - 1, ""));
	}

	public static int chessboard1(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + er + "-" + ec + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		// knight
		count += chessboard1(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		count += chessboard1(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			for (int moves = 1; moves <= ec - cc; moves++) {
				count += chessboard1(cr, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

			for (int moves = 1; moves <= er - cr; moves++) {
				count += chessboard1(cr + moves, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}
		}

		// bishop
		if (cr == cc || cr + cc == er) {
			for (int moves = 1; moves <= er - cr && moves <= ec - cc; moves++) {
				count += chessboard1(cr + moves, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}
		}

		return count;
	}
}
