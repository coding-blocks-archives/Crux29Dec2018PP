package Assignments.Jan21;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class PainterPartition {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nop = scn.nextInt();
		int nob = scn.nextInt();

		int[] boards = new int[nob];

		for (int i = 0; i < nob; i++) {
			boards[i] = scn.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < nob; i++) {
			sum += boards[i];
		}

		int finalAns = 0;

		int lo = 0;
		int hi = sum;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(nob, nop, boards, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	public static boolean isPossible(int nob, int nop, int[] boards, int mid) {

		int painters = 1;
		int timeRemaining = mid;

		int i = 0;

		while (i < boards.length) {

			if (timeRemaining >= boards[i]) {
				timeRemaining = timeRemaining - boards[i];
				i++;
			} else {

				painters++;
				timeRemaining = mid;

				if (painters > nop) {
					return false;
				}

			}
		}

		return true;

	}

}
