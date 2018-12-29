
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class ConditionalDemo {

	public static void main(String[] args) {

		int marks = 80;
		int pack = 10;

		if (marks >= 90) {
			System.out.println("very good");
			System.out.println("excellent");
		} else if (marks >= 60) {
			System.out.println("avg");
		} else if (pack >= 5) {
			System.out.println("avgggg");
		} else {
			System.out.println("not good");
		}

		System.out.println("bye");
	}

}
