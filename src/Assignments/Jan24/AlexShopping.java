package Assignments.Jan24;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class AlexShopping {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] price = { 100, 200, 400, 100 };
		shopping(price);

	}

	public static void shopping(int[] price) {

		int q = scn.nextInt();

		for (int j = 0; j < q; j++) {

			int amt = scn.nextInt();
			int k = scn.nextInt();
			int cnt = 0;
			for (int i = 0; i < price.length; i++) {

				if (amt % price[i] == 0) {
					cnt++;
				}

			}

			if (cnt >= k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}
}
