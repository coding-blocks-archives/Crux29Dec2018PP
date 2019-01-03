package L3_Jan3_Extra;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Jan-2019
 *
 */

public class Patterns {

	public static void main(String[] args) {

		Pattern20(5);

		// int ans = power(2, 6);
		// System.out.println(ans);
		// System.out.println(power(2, 7));
		// System.out.println(log(1024, 2));
	}

	public static void Pattern0(int n) {

		int row = 1;

		// no of rows
		while (row <= n) {

			System.out.print("*");

			System.out.println();
			row = row + 1;
		}
	}

	public static void Pattern1(int n, int n1) {

		int row = 1;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n1) {
				System.out.print("*");
				col = col + 1;
			}

			System.out.println();
			row = row + 1;
		}
	}

	public static void Pattern2(int n) {

		int row = 1;
		int nst = 1;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col = col + 1;
			}

			// prep
			System.out.println();
			nst = nst + 1;
			row = row + 1;

		}
	}

	public static void Pattern3(int n) {

		int row = 1;
		int nst = n;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col = col + 1;
			}

			// prep
			System.out.println();
			nst = nst - 1;
			row = row + 1;

		}
	}

	public static void Pattern4(int n) {

		int nsp = n - 1;
		int nst = 1;

		int row = 1;

		while (row <= n) {

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			row = row + 1;
			nsp = nsp - 1;
			nst = nst + 1;
			System.out.println();
		}

	}

	public static void Pattern7(int n) {

		int row = 1;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				if (row == 1 || row == n || col == 1 || col == n)
					System.out.print("*");
				else
					System.out.print(" ");

				col = col + 1;
			}

			System.out.println();
			row = row + 1;
		}
	}

	public static void Pattern8(int n) {

		int row = 1;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				if (row == col || row + col == n + 1)
					System.out.print("*");
				else
					System.out.print(" ");

				col = col + 1;
			}

			System.out.println();
			row = row + 1;
		}
	}

	public static void Pattern10(int n) {

		int nsp = 0;
		int nst = 2 * n - 1;

		int row = 1;

		while (row <= n) {

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			row = row + 1;
			nsp = nsp + 1;
			nst = nst - 2;
			System.out.println();
		}

	}

	public static void Pattern13(int n) {

		int nst = 1;
		int row = 1;

		while (row <= 2 * n - 1) {

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			if (row <= n - 1) {
				nst = nst + 1;
			} else {
				nst = nst - 1;
			}
			row = row + 1;
			System.out.println();
		}

	}

	public static void Pattern15(int n) {

		int nst = n;
		int nsp = 0;
		int row = 1;

		while (row <= 2 * n - 1) {

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			if (row <= n - 1) {
				nst = nst - 1;
				nsp = nsp + 2;
			} else {
				nst = nst + 1;
				nsp = nsp - 2;
			}
			row = row + 1;
			System.out.println();
		}

	}

	public static void Pattern19(int n) {

		int nst = n / 2 + 1;
		int nsp = -1;
		int row = 1;

		while (row <= n) {

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;

			if (row == 1 || row == n) {
				cst = 2;
			}

			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			if (row <= n / 2) {
				nst = nst - 1;
				nsp = nsp + 2;
			} else {
				nst = nst + 1;
				nsp = nsp - 2;
			}
			row = row + 1;
			System.out.println();
		}

	}

	public static void Pattern20(int n) {

		int nst = 1;
		int nsp = n / 2;
		int row = 1;

		while (row <= n) {

			// stars
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {

				if (cst == 1 || cst == nst)
					System.out.print("*");
				else
					System.out.print(" ");

				cst = cst + 1;
			}

			// prep
			if (row <= n / 2) {
				nst = nst + 2;
				nsp = nsp - 1;
			} else {
				nst = nst - 2;
				nsp = nsp + 1;
			}
			row = row + 1;
			System.out.println();
		}

	}

	public static void Pattern21(int n) {

		int nst = 1;
		int nsp = 2 * n - 3;
		int row = 1;

		while (row <= n) {

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;

			if (row == n)
				cst = 2;

			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			nst = nst + 1;
			nsp = nsp - 2;
			row = row + 1;
			System.out.println();
		}

	}

	public static void Pattern28(int n) {

		int nst = 1;
		int nsp = n - 1;
		int row = 1;

		while (row <= n) {

			int val = row;

			// stars
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" \t");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");

				if (cst <= nst / 2)
					val = val + 1;
				else
					val = val - 1;

				cst = cst + 1;
			}

			// prep
			nst = nst + 2;
			nsp = nsp - 1;
			row = row + 1;
			System.out.println();
		}

	}

	public static void PatternRhombus(int n) {

		int nst = 1;
		int nsp = n - 1;
		int row = 1;

		while (row <= 2 * n - 1) {

			int val;
			if (row <= n) {
				val = row;
			} else {
				val = 2 * n - 1 - row + 1;
			}

			// stars
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("\t");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");

				if (cst <= nst / 2)
					val = val + 1;
				else
					val = val - 1;

				cst = cst + 1;
			}

			// prep
			if (row <= n - 1) {
				nst = nst + 2;
				nsp = nsp - 1;
			} else {
				nst = nst - 2;
				nsp = nsp + 1;
			}
			row = row + 1;
			System.out.println();
		}

	}

	public static void PatternFib(int n) {

		int row = 1;
		int nst = 1;

		int a = 0;
		int b = 1;
		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= nst) {
				System.out.print(a + "\t");

				int sum = a + b;
				a = b;
				b = sum;

				col = col + 1;
			}

			// prep
			System.out.println();
			nst = nst + 1;
			row = row + 1;

		}
	}

	public static void PatternMountain(int n) {

		int nst = 1;
		int nsp = 2 * n - 3;
		int row = 1;

		while (row <= n) {

			int val = 1;

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");
				val = val + 1;
				cst = cst + 1;
			}

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" \t");
				csp = csp + 1;
			}

			cst = 1;
			val = val - 1;

			if (row == n) {
				cst = 2;
				val = val - 1;
			}

			while (cst <= nst) {
				System.out.print(val + "\t");
				val = val - 1;
				cst = cst + 1;
			}

			// prep
			nst = nst + 1;
			nsp = nsp - 2;
			row = row + 1;
			System.out.println();
		}

	}

	public static void PatternHourGlass(int n) {

		int nst = 2 * n + 1;
		int nsp = 0;

		int row = 1;

		while (row <= 2 * n + 1) {

			int val;

			if (row <= n + 1) {
				val = n - row + 1;
			} else {
				val = row - (n + 1);
			}

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp++;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + " ");

				if (cst <= nst / 2)
					val--;
				else
					val++;

				cst++;
			}

			// prep
			if (row <= n) {
				nst -= 2;
				nsp++;
			} else {
				nst += 2;
				nsp--;
			}
			System.out.println();
			row = row + 1;
		}

	}

	// x^n
	public static int power(int x, int n) {

		int product = 1;

		for (int i = 1; i <= n; i++) {
			product = product * x;
		}

		return product;

	}

	// log a base b
	public static int log(int a, int b) {

		// int count = 1;
		//
		// while (true) {
		//
		// int pans = power(b, count);
		//
		// if (pans >= a) {
		// break;
		// }
		//
		// count++;
		//
		// }
		//
		// return count;

		int count = 0;
		int pans = 1;

		while (pans < a) {

			count++;
			pans = power(b, count);

		}

		return count;

	}

}
