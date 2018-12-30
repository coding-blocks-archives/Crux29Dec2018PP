package L2_Dec30;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class DecimalToAnybase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int db = scn.nextInt() ;
		
		int ans = 0;
		int multiplier = 1;

		while (n != 0) {

			int rem = n % db;

			ans = rem * multiplier + ans;
			multiplier = multiplier * 10;
			n = n / db;
		}

		System.out.println(ans);

	}

}
