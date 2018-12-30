package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class Pattern20 {

	public static void main(String[] args) {

		int n = 11;

		int nsp = n / 2;
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
			System.out.println();
			row = row + 1;
		}

	}

}
