package L2_Dec30;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class BinaryToDecimal {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int ans = 0;
		int multiplier = 1;

		while (n != 0) {

			int rem = n % 10;

			ans = rem * multiplier + ans;
			multiplier = multiplier * 2;
			n = n / 10;
		}

		System.out.println(ans);

	}

}
