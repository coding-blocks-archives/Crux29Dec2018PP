package L16_March3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Mar-2019
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 600 0 30 1 70 0 40 2 80 0 90 0
	public static void main(String[] args) {

		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.max());
	}
}
