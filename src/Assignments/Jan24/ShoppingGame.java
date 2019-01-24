package Assignments.Jan24;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class ShoppingGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int aayushLimit = scn.nextInt();
			int harshitLimit = scn.nextInt();

			int aayushCount = 0;
			int harshitCount = 0;

			int i = 1;

			while (true) {

				if (i % 2 == 1) {

					if (aayushCount + i <= aayushLimit) {
						aayushCount += i;
					} else {
						System.out.println("Harshit");
						break;
					}
				} else {
					if (harshitCount + i <= harshitLimit) {
						harshitCount += i;
					} else {
						System.out.println("Aayush");
						break;
					}
				}

				i++;

			}

			tc--;
		}

	}

}
