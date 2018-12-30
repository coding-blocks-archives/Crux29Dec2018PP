package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Pattern31 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		while (row <= n) {

			int val = n;
			int col = 1;
			while (col <= n) {
				if (row + col == n + 1) {
					System.out.print("*");
				} else {
					System.out.print(val);
				}
				val = val - 1;
				col = col + 1;
			}

			row = row + 1;
			System.out.println();
		}

	}

}
