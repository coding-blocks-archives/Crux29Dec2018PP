package L3_Jan2;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class LowerUpper {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		char ch = scn.next().charAt(0);

		if (ch >= 'a' && ch <= 'z') {
			System.out.println("lower");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("upper");
		} else {
			System.out.println("invalid");
		}

	}

}
