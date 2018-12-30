package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Reverse {

	public static void main(String[] args) {

		int n = 78654;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;
			ans = ans * 10 + rem;
			n = n / 10;

		}

		System.out.println(ans);

	}

}
