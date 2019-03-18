package L19_March17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Mar-2019
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);
		bst.display();

		System.out.println(bst.max());
		System.out.println(bst.size());
		System.out.println(bst.find(70));
		System.out.println(bst.ht());

		bst.printInRange(25, 65);

		System.out.println();
		bst.printDec();

		// bst.replaceWithSumLarger();
		bst.display();

		bst.add(80);
		bst.add(45);

		bst.display();

		bst.remove(60);
		bst.display();

	}
}
