package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class Pattern14 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = 1;

		int row = 1;
		while (row <= 2 * n - 1) {

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
			if (row <= n - 1) {
				nst = nst + 1;
				nsp = nsp - 1;
			} else {
				nst = nst - 1;
				nsp = nsp + 1;
			}
			System.out.println();
			row = row + 1;
		}

	}

}
