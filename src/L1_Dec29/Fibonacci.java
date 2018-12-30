package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Fibonacci {

	public static void main(String[] args) {

		int n = 8;

		int a = 0;
		int b = 1;

		int count = 1;

		while (count <= n + 1) {

			System.out.println(a);
			int sum = a + b;
			a = b;
			b = sum;

			count = count + 1;
		}

	}

}
