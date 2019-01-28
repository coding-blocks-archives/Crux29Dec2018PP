package L8_Jan20;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// // System.out.println(getSS("abc"));
		// System.out.println(KPC("145"));
		// System.out.println(Permutation("abcd").size());

		// System.out.println(getBoardPath16(0, 10));
		// System.out.println(getMazePath(0, 0, 2, 3));
		System.out.println(getMazePathDMM(0, 0, 2, 3).size());

		System.out.println(coinToss(3));
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}

		return mr;
	}

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSSAscii(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
			mr.add((int) ch + val);

		}

		return mr;
	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> KPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = KPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		// for (int i = 0; i < code.length(); i++) {
		//
		// for (String val : rr) {
		// mr.add(code.charAt(i) + val);
		// }
		// }

		for (String val : rr) {
			for (int i = 0; i < code.length(); i++) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> Permutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = Permutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {

				mr.add(val.substring(0, i) + ch + val.substring(i));
			}

		}

		return mr;

	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(dice + val);
			}

		}

		return mr;

	}

	public static ArrayList<String> getBoardPath16(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			if ((curr == 0 && (dice == 1 || dice == 6)) || curr != 0) {
				ArrayList<String> rr = getBoardPath16(curr + dice, end);

				for (String val : rr) {
					mr.add(dice + val);
				}
			}

		}

		return mr;

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		return mr;
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);

		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int move = 1; move <= ec - cc; move++) {
			ArrayList<String> rrh = getMazePathDMM(cr, cc + move, er, ec);

			for (String val : rrh) {
				mr.add("H" + move + val);
			}
		}

		for (int move = 1; move <= er - cr; move++) {
			ArrayList<String> rrv = getMazePathDMM(cr + move, cc, er, ec);

			for (String val : rrv) {
				mr.add("V" + move + val);
			}
		}

		for (int move = 1; move <= ec - cc && move <= er - cr; move++) {
			ArrayList<String> rrd = getMazePathDMM(cr + move, cc + move, er, ec);

			for (String val : rrd) {
				mr.add("D" + move + val);
			}

		}
		return mr;

	}

	public static ArrayList<String> coinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;

	}

}
