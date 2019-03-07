package Assignments.March7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Mar-2019
 *
 */

public class Mazepath_D2 {

	public static void main(String[] args) {

		int n = 3;

		int ans = mazePathD2(0, 0, n - 1, n - 1, "");
		System.out.println("\n" + ans);
	}

	public static int mazePathD2(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + " ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count += mazePathD2(cr + 1, cc, er, ec, ans + "V");
		count += mazePathD2(cr, cc + 1, er, ec, ans + "H");

		if (cr == cc || cr + cc == ec) {
			count += mazePathD2(cr + 1, cc + 1, er, ec, ans + "D");
		}

		return count;

	}
}
