package L1_Dec29 ;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class SumOfN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int sum = 0;

		int counter = 1; // initialization

		while (counter <= n) { // condition

			sum = sum + counter;
			counter = counter + 1; // re-initialization
		}

		System.out.println(sum);

	}

}
