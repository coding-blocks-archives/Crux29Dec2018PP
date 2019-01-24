package Assignments.Jan24;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jan-2019
 *
 */

public class ToggleCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String str = scn.next();

		String ans = "";

		int diff = 'a' - 'A';
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// if (Character.isUpperCase(ch)) {
			// ans = ans + Character.toLowerCase(ch);
			//
			// } else if (Character.isLowerCase(ch)) {
			// ans = ans + Character.toUpperCase(ch);
			// }

			if (ch >= 'a' && ch <= 'z') {
				ans = ans + (char) (ch - diff);
			} else if (ch >= 'A' && ch <= 'Z') {
				ans = ans + (char) (ch + diff);
			}

		}

		System.out.println(ans);

	}

}
