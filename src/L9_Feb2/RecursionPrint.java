package L9_Feb2;

import java.util.ArrayList;

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
		// System.out.println(printPermutation("abc", ""));

		// printPermutation2("abc", "");

		// System.out.println(boardPath(0, 10, ""));

		// System.out.println(mazePath(0, 0, 2, 2, ""));

		lexicoCounting(9, 1000);

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
	
}
