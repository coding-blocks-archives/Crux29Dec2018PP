package Assignments.Jan21;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nob = scn.nextInt();
		int nos = scn.nextInt();

		int[] pages = new int[nob];

		for (int i = 0; i < nob; i++) {
			pages[i] = scn.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < nob; i++) {
			sum += pages[i];
		}

		int finalAns = 0;

		int lo = 0;
		int hi = sum;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(nos, nob, pages, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	public static boolean isPossible(int nos, int nob, int[] pages, int mid) {

		int numStudents = 1;
		int pagesRead = 0;

		int i = 0;

		while (i < pages.length) {

			if (pagesRead + pages[i] <= mid) {
				pagesRead += pages[i];
				i++;
			} else {

				numStudents++;
				pagesRead = 0;

				if (numStudents > nos) {
					return false;
				}

			}

		}

		return true;

	}

}
