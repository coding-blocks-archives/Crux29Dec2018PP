package Assignments.Jan21;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class MaxSumPath {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			
			int n = scn.nextInt();
			int m = scn.nextInt();

			int[] one = new int[n];
			int[] two = new int[m];

			for (int i = 0; i < one.length; i++) {
				one[i] = scn.nextInt();
			}

			for (int j = 0; j < two.length; j++) {
				two[j] = scn.nextInt();
			}

			int sum1 = 0;
			int sum2 = 0;

			int finalAns = 0;

			int i = 0;
			int j = 0;

			while (i < one.length && j < two.length) {

				if (one[i] > two[j]) {
					sum2 += two[j];
					j++;
				} else if (one[i] < two[j]) {
					sum1 += one[i];
					i++;
				} else {

					finalAns += Math.max(sum1, sum2);
					finalAns += one[i];

					sum1 = 0;
					sum2 = 0;

					i++;
					j++;
				}

			}

			if (i == one.length) {

				while (j < two.length) {
					sum2 += two[j];
					j++;
				}

			}

			if (j == two.length) {

				while (i < one.length) {
					sum1 += one[i];
					i++;
				}
			}

			finalAns += Math.max(sum1, sum2);

			System.out.println(finalAns);
			tc--;
		}

	}

}
