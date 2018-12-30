package L1_Dec29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern1 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				System.out.print("*");
				col = col + 1;
			}

			// update
			row = row + 1;
			System.out.println();

		}

	}

}
