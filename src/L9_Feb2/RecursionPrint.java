package L9_Feb2;

import L8_Jan20.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Feb-2019
 *
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSSAscii("abc", "");

		// System.out.println(printKPC("145", ""));
		// System.out.println(printPermutation("abca", ""));

		// printPermutation2("abc", "");

		// System.out.println(boardPath(0, 10, ""));

		// System.out.println(mazePath(0, 0, 2, 2, ""));

		// lexicoCounting2(2, 1000);

		// System.out.println(permutationNoDuplicates("abcac", ""));

		// coinToss(3, "");
		// coinTossNoConsecutiveHead(3, "", false);

		coinTossNoConsecutive(3, "", false, false);

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ch);
		printSS(roq, ans);

	}

	public static void printSSAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSAscii(roq, ans);
		printSSAscii(roq, ans + ch);
		printSSAscii(roq, ans + (int) ch);

	}

	public static int printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		int sum = 0;

		for (int i = 0; i < code.length(); i++) {
			sum += printKPC(roq, ans + code.charAt(i));
		}

		return sum;
	}

	public static int printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int sum = 0;

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			sum += printPermutation(roq, ans + ch);

		}

		return sum;

	}

	public static void printPermutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			printPermutation2(roq, ans.substring(0, i) + ch + ans.substring(i));

		}

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += boardPath(curr + dice, end, ans + dice);
		}

		return sum;
	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;
	}

	public static int mazePathDMM(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		int sum = 0;

		for (int move = 1; move <= ec - cc; move++) {
			sum += mazePathDMM(cr, cc + move, er, ec, ans + "H" + move);
		}

		for (int move = 1; move <= er - cr; move++) {
			sum += mazePathDMM(cr + move, cc, er, ec, ans + "V" + move);
		}

		for (int move = 1; move <= ec - cc && move <= er - cr; move++) {
			sum += mazePathDMM(cr + move, cc + move, er, ec, ans + "D" + move);
		}

		return sum;
	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;

		if (curr == 0) {
			i = 1;
		}

		while (i <= 9) {
			lexicoCounting(curr * 10 + i, end);
			i++;
		}

	}

	public static void lexicoCounting2(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		for (int i = 0; i <= 9; i++) {
			lexicoCounting2(curr * 10 + i, end);
		}

		if (curr + 1 <= 9)
			lexicoCounting2(curr + 1, end);

	}

	public static int permutationNoDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int sum = 0;

		boolean[] visited = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			if (visited[ch]) {
				continue;
			}

			String roq = ques.substring(0, i) + ques.substring(i + 1);

			sum += permutationNoDuplicates(roq, ans + ch);

			visited[ch] = true;

		}

		return sum;

	}

	public static void coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static void coinTossNoConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHeadIncluded) {
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else {
			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		}

	}

	public static void coinTossNoConsecutive(int n, String ans, boolean wasLastHeadIncluded,
			boolean wasLastTailIncluded) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHeadIncluded == false && wasLastTailIncluded == false) {
			coinTossNoConsecutive(n - 1, ans + "H", true, false);
			coinTossNoConsecutive(n - 1, ans + "T", false, true);
		}

		else if (wasLastHeadIncluded) {
			coinTossNoConsecutive(n - 1, ans + "T", false, true);
		}

		else if (wasLastTailIncluded) {
			coinTossNoConsecutive(n - 1, ans + "H", true, false);
		}

	}

}
