package L2_Dec30;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int r = scn.nextInt();

		int temp = n;
		
		// number of digits
		int count = 0;
		while (temp != 0) {
			temp = temp / 10;
			count = count + 1;
		}

		r = r % count;

		if (r < 0) {
			r = r + count;
		}

		// logic
		int divisor = (int) Math.pow(10, r);
		int multiplier = (int) Math.pow(10, count - r);

		int rem = n % divisor;
		int quotient = n / divisor;

		int ans = rem * multiplier + quotient;

		System.out.println(ans);

	}

}
