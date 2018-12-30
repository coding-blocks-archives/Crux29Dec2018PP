package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern11 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;

		int row = 1;
		while (row <= n) {

			// work
			// first work for spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// then work for stars
			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				cst = cst + 1;
			}

			// update
			row = row + 1;
			nst = nst + 2;
			nsp = nsp - 1;
			System.out.println();

		}

	}

}
