package L1_Dec29 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Dec-2018
 *
 */

public class ScopeDemo {

	public static void main(String[] args) {

		int val = 1;

		while (val <= 5) {
			System.out.println("hello");
			int sum = 100;
			val = val + 1;
		}

		System.out.println(val);
	}

}
