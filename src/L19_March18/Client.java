package L19_March18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Mar-2019
 *
 */

public class Client {

	public static void main(String[] args) {
		int[] arr = { 20, 25, 30, 10, 5, 15, 27, 19, 16 };

		AVLTree tree = new AVLTree();

		for (int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}

		tree.display();
	}
}
