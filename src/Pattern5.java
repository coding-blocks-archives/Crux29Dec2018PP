
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern5 {

	public static void main(String[] args) {

		int n = 5;

		int nst = n;
		int nsp = 0;

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

			// update
			row = row + 1;
			nst = nst - 1;
			nsp = nsp + 1;
			System.out.println();

		}

	}

}
