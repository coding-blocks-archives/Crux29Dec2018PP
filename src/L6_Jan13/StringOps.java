package L6_Jan13;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jan-2019
 *
 */

public class StringOps {

	public static void main(String[] args) {

		// printChars("coding");
		// allSubstrings("block");
		// palindromicSubstrings("nitin");

		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		System.out.println(str);
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(ch);
		}

	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	public static void allSubstrings(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				System.out.println(ss);
			}
		}

	}

	public static void palindromicSubstrings(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				if (isPalindrome(ss))
					System.out.println(ss);
			}
		}
	}

}










