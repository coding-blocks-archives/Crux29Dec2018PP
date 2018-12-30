package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class Pattern13 {

	public static void main(String[] args) {

		int n = 5;
		int nst = 1;
		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep for next row
			if (row <= n - 1) {
				nst = nst + 1;
			} else {
				nst = nst - 1;
			}
			System.out.println();
			row = row + 1;
		}

	}
}
