package Assignments.March7;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class Chessboard2 {

	public static void main(String[] args) {

		int n = 3;

		int[] minePort = makeMinesPorts(SOE(n * n));

		System.out.println("\n" + chessboard2(0, 0, n - 1, n - 1, "", minePort));
	}

	public static int chessboard2(int cr, int cc, int er, int ec, String ans, int[] minePort) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + er + "-" + ec + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		int val = (cr * (ec + 1)) + (cc + 1);

		if (minePort[val] == 1) {
			return 0;
		} else if (minePort[val] == 2) {
			count += chessboard2(er, ec, er, ec, ans + "{" + cr + "-" + cc + "}P", minePort);
		}

		// knight
		count += chessboard2(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K", minePort);
		count += chessboard2(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K", minePort);

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			for (int moves = 1; moves <= ec - cc; moves++) {
				count += chessboard2(cr, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}R", minePort);
			}

			for (int moves = 1; moves <= er - cr; moves++) {
				count += chessboard2(cr + moves, cc, er, ec, ans + "{" + cr + "-" + cc + "}R", minePort);
			}
		}

		// bishop
		if (cr == cc || cr + cc == er) {
			for (int moves = 1; moves <= er - cr && moves <= ec - cc; moves++) {
				count += chessboard2(cr + moves, cc + moves, er, ec, ans + "{" + cr + "-" + cc + "}B", minePort);
			}
		}

		return count;
	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}

		return primes;

	}

	public static int[] makeMinesPorts(boolean[] primes) {

		int count = 1;

		int[] minesPorts = new int[primes.length];

		for (int i = 0; i < primes.length; i++) {

			if (primes[i]) {

				if (count % 2 == 1) {
					minesPorts[i] = 1;
				} else {
					minesPorts[i] = 2;
				}

				count++;

			}

		}

		return minesPorts;

	}

}
