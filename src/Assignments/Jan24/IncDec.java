package Assignments.Jan24;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class IncDec {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(valid(7));
	}

	public static boolean valid(int n) {

		boolean isInc = false;
		int prev = scn.nextInt();

		for (int i = 1; i < n; i++) {

			int curr = scn.nextInt();

			if (prev < curr) {
				isInc = true;
			} else if ((isInc && prev > curr) || prev == curr) {
				return false;
			}

			prev = curr;

		}

		return true;
	}

}
