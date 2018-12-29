
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Prime {

	public static void main(String[] args) {

		int n = 7;

		int div = 1;
		int factors = 0;

		while (div <= n) {

			if (n % div == 0) {
				factors = factors + 1;
			}

			div = div + 1;
		}

		if (factors == 2) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}

	}

}
