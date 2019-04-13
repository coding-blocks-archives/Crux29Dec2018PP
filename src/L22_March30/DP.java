package L22_March30;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Mar-2019
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 3;
		// System.out.println(fibonacci(n));
		// System.out.println(fibonacciTD(n, new int[n + 1]));
		// System.out.println(FibonaaciBU(n));
		// System.out.println(FibonacciBUSE(n));

		// System.out.println(boardPath(0, n));
		// System.out.println(boardPathTD(0, n, new int[n]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));
		// System.out.println(mazePathBUSED(n, n));

		// String s1 = "abcdefgbchdgvuhdufvhgekuiyfhweuif7i3w";
		// String s2 = "abcddscbhjsdgcfyuegufhweuiyfw7u";
		//
		// int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		//
		// for (int i = 0; i < strg.length; i++) {
		// for (int j = 0; j < strg[0].length; j++) {
		// strg[i][j] = -1;
		// }
		// }
		// System.out.println(LCSTD(s1, s2, strg));

		// System.out.println(EditDistanceTD(s1, s2, strg));
		// System.out.println(EditDistanceBU(s1, s2));

		// int[] arr = { 1, 2, 3, 4, 5 };
		//
		// // System.out.println(MCM(arr, 0, arr.length - 1));
		// System.out.println(MCMBU(arr));
		// System.out.println(MCMTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));

		int[] arr = new int[100];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		// int[] arr = { 2, 3, 5, 1, 4, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// System.out.println(WineProblem(arr, 0, arr.length - 1, 1));
		// System.out.println(WineProblemTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(wineProblemBU(arr));

		// int[] wt = { 1, 3, 4, 5 };
		// int[] price = { 1, 4, 5, 7 };

		int[] wt = new int[100];
		int[] price = new int[100];

		for (int i = 0; i < wt.length; i++) {
			wt[i] = i + 1;
			price[i] = i + 2;
		}

		int cap = 100000;
		// System.out.println(Knapsack(wt, price, 0, cap));
		// System.out.println(KnapsackTD(wt, price, 0, cap, new int[wt.length][cap +
		// 1]));
		// System.out.println(KnapsackBU(wt, price, cap));

		// int[] arr = { 40, 60, 20 };
		// System.out.println(Mixtures(arr, 0, arr.length - 1));

		String src = "bjdshjsvhehfuweufgweuihfuweghui";
		String pattern = "**************************************";
		// System.out.println(wildcardMatching(src, pattern));
		// System.out.println(wildcardMatchingBU(src, pattern));

		// int[] arr = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };

		// System.out.println(RodCutTD(arr, arr.length - 1, new int[arr.length]));
		// System.out.println(RodCutBU(arr, arr.length - 1));

		// for (int i = 1; i <= 10; i++) {
		// System.out.println(catalanNumber(1000, new int[1001]));
		System.out.println(catalanNumberBU(100000));
		// }

		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// ans store
		strg[n] = fn;

		return fn;

	}

	public static int FibonaaciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibonacciBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += boardPath(curr + dice, end);
		}

		return sum;
	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = sum;

		return sum;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {

			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];

		}

		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;
		}

		return strg[0];
	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];

	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];

	}

	public static int mazePathBUSED(int er, int ec) {

		int diag = 0;
		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = sum;
				}
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);

				}

			}
		}

		return strg[0][0];

	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		// reuse
		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;

		if (ch1 == ch2) {
			ans = LCSTD(ros1, ros2, strg) + 1;
		} else {
			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);

			ans = Math.max(o1, o2);
		}

		strg[s1.length()][s2.length()] = ans; // store
		return ans;

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {

			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			ans = Math.min(r, Math.min(i, d)) + 1;

		}

		return ans;

	}

	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, strg);
		} else {

			int i = EditDistanceTD(ros1, s2, strg);
			int d = EditDistanceTD(s1, ros2, strg);
			int r = EditDistanceTD(ros1, ros2, strg);

			ans = Math.min(r, Math.min(i, d)) + 1;

		}

		strg[s1.length()][s2.length()] = ans;
		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];
					strg[row][col] = Math.min(r, Math.min(i, d)) + 1;

				}

			}
		}

		return strg[0][0];

	}

	public static int MCM(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(arr, si, k);
			int sp = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, strg);
			int sp = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fp + sp + sw;

					if (total < min) {
						min = total;
					}

				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int ssell = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int esell = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(ssell, esell);

		return ans;

	}

	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int ssell = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int esell = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(ssell, esell);

		strg[si][ei] = ans;

		return ans;

	}

	public static int wineProblemBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = n - (ei - si + 1) + 1;

				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {

					int ssell = strg[si + 1][ei] + arr[si] * yr;
					int esell = strg[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(ssell, esell);

					strg[si][ei] = ans;

				}

			}

		}

		return strg[0][n - 1];

	}

	public static int Knapsack(int[] wt, int[] price, int vidx, int cap) {

		if (vidx == wt.length) {
			return 0;
		}

		int exclude = Knapsack(wt, price, vidx + 1, cap); // no

		int include = 0;

		if (cap >= wt[vidx])
			include = Knapsack(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx]; // yes

		int ans = Math.max(include, exclude);

		return ans;

	}

	public static int KnapsackTD(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int exclude = KnapsackTD(wt, price, vidx + 1, cap, strg); // no

		int include = 0;

		if (cap >= wt[vidx])
			include = KnapsackTD(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx]; // yes

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;

		return ans;

	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {

		int nr = wt.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 1; row < nr; row++) {

			for (int col = 1; col < nc; col++) {

				int include = 0;

				if (col >= wt[row - 1]) {
					include = price[row - 1] + strg[row - 1][col - wt[row - 1]];
				}

				int exclude = strg[row - 1][col];

				int ans = Math.max(include, exclude);

				strg[row][col] = ans;

			}

		}

		return strg[nr - 1][nc - 1];

	}

	public static int Mixtures(int[] arr, int si, int ei) {

		if (si == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = Mixtures(arr, si, k);
			int sp = Mixtures(arr, k + 1, ei);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int ans = fp + sp + sw;

			if (ans < min) {
				min = ans;
			}

		}

		return min;

	}

	public static int color(int[] arr, int si, int ei) {

		int c = 0;

		for (int i = si; i <= ei; i++)
			c += arr[i];

		return c % 100;
	}

	public static boolean wildcardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char schar = src.charAt(0);
		char pchar = pattern.charAt(0);

		String sros = src.substring(1);
		String pros = pattern.substring(1);

		boolean ans;

		if (pchar == '?' || schar == pchar) {
			ans = wildcardMatching(sros, pros);
		} else if (pchar == '*') {
			ans = wildcardMatching(src, pros) || wildcardMatching(sros, pattern);
		} else {
			ans = false;
		}

		return ans;
	}

	public static boolean wildcardMatchingBU(String src, String pattern) {

		boolean[][] strg = new boolean[src.length() + 1][pattern.length() + 1];

		for (int row = strg.length - 1; row >= 0; row--) {

			for (int col = strg[0].length - 1; col >= 0; col--) {

				if (row == strg.length - 1 && col == strg[0].length - 1) {
					strg[row][col] = true;
				} else if (row == strg.length - 1) {

					if (pattern.charAt(col) == '*') {
						strg[row][col] = strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}

				} else if (col == strg[0].length - 1) {
					strg[row][col] = false;
				} else {

					if (pattern.charAt(col) == src.charAt(row) || pattern.charAt(col) == '?') {
						strg[row][col] = strg[row + 1][col + 1];
					} else if (pattern.charAt(col) == '*') {
						strg[row][col] = strg[row + 1][col] || strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}

				}

			}

		}

		return strg[0][0];

	}

	public static int RodCutTD(int[] price, int n, int[] strg) {

		if (strg[n] != 0) {
			return strg[n];
		}

		int max = price[n];

		int left = 1;
		int right = n - 1;

		while (left <= right) {

			int fh = RodCutTD(price, left, strg);
			int sh = RodCutTD(price, right, strg);

			int total = fh + sh;

			if (total > max) {
				max = total;
			}

			left++;
			right--;

		}

		strg[n] = max;

		return max;

	}

	public static int RodCutBU(int[] price, int n) {

		int[] strg = new int[n + 1];

		for (int i = 1; i < price.length; i++) {

			int max = price[i];

			int left = 1;
			int right = i - 1;

			while (left <= right) {

				int fh = strg[left];
				int sh = strg[right];

				int total = fh + sh;

				if (total > max) {
					max = total;
				}

				left++;
				right--;

			}

			strg[i] = max;

		}

		return strg[n];
	}

	public static int catalanNumber(int n, int[] strg) {

		if (n <= 1) {
			return 1;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			ans += catalanNumber(i - 1, strg) * catalanNumber(n - i, strg);
		}

		strg[n] = ans;
		return ans;
	}

	public static int catalanNumberBU(int n) {

		int[] strg = new int[n + 1];
		strg[0] = strg[1] = 1;

		for (int i = 2; i <= n; i++) {

			int ans = 0;
			for (int j = 1; j <= i; j++) {
				ans += strg[j - 1] * strg[i - j];
			}

			strg[i] = ans;

		}

		return strg[n];
	}

}
