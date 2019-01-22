package Assignments.Jan21;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jan-2019
 *
 */

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			
			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int nor = scn.nextInt();
			int noc = scn.nextInt();

			int[] rickshaw = new int[nor];
			int[] cabs = new int[noc];

			for (int i = 0; i < nor; i++) {
				rickshaw[i] = scn.nextInt();
			}

			for (int i = 0; i < noc; i++) {
				cabs[i] = scn.nextInt();
			}

			int ans = minFare(cabs, rickshaw, c1, c2, c3, c4);

			System.out.println(ans);
			
			tc--;
		}
	}

	private static int minFare(int[] cabs, int[] rickshaw, int c1, int c2, int c3, int c4) {

		int rickshawFare = minFareTransport(rickshaw, c1, c2, c3, c4);
		int cabsFare = minFareTransport(cabs, c1, c2, c3, c4);

		int cost = rickshawFare + cabsFare;

		return Math.min(cost, c4);

	}

	private static int minFareTransport(int[] freq, int c1, int c2, int c3, int c4) {

		int sum = 0;

		for (int i = 0; i < freq.length; i++) {
			sum += Math.min(freq[i] * c1, c2);
		}

		return Math.min(sum, c3);

	}

}
