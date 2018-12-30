package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class Pattern17 {

	public static void main(String[] args) {

		int n = 11;

		int nsp = 1;
		int nst = n / 2;

		int row = 1;
		while (row <= n) {

			// work

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
			System.out.println();
			row = row + 1;
		}

	}

}
