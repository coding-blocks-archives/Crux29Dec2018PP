import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class GCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int divident = scn.nextInt();
		int divisor = scn.nextInt();

		while (divident % divisor != 0) {

			int rem = divident % divisor;

			divident = divisor;
			divisor = rem;

		}

		System.out.println(divisor);

	}

}
