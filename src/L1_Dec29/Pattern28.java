package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern28 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;

		int row = 1;
		int val = 1;
		while (row <= n) {

			val = row;
			
			// work			
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				if (cst <= nst / 2) {
					val = val + 1;
				} else {
					val = val - 1;
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
