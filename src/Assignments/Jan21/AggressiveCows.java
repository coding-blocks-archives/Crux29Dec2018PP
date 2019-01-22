package Assignments.Jan21;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] pos = new int[nos];

		for (int i = 0; i < nos; i++) {
			pos[i] = scn.nextInt();
		}

		Arrays.sort(pos);

		int finalAns = 0;

		int lo = 0;
		int hi = pos[pos.length - 1] - pos[0];

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(noc, nos, pos, mid)) {
				lo = mid + 1;
				finalAns = mid;
			} else {
				hi = mid - 1;
			}

		}

		System.out.println(finalAns);

	}

	public static boolean isPossible(int noc, int nos, int[] arr, int mid) {

		int cowsPlaced = 1;
		int pos = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - pos >= mid) {
				cowsPlaced++;
				pos = arr[i];

				if (cowsPlaced == noc) {
					return true;
				}
			}
		}

		return false;

	}

}
