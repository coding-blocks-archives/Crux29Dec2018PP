
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern2 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;

		int row = 1;
		while (row <= n) {

			// work
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col = col + 1;
			}

			// update
			row = row + 1;
			nst = nst + 1;
			System.out.println();

		}

	}

}
