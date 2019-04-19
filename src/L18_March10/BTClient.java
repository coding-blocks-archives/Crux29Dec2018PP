package L18_March10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Mar-2019
 *
 */

public class BTClient {

	public static void main(String[] args) {

		// 10 true 20 true 40 false false true 50 false false true 30 false true 70
		// false false

		// 10 true 20 true 40 true 80 true 90 true 100 true 110 false false false false
		// false false true 50 false true 120 false true 130 false true 140 false false
		// true 30 true 60 false false true 70 false false

		// int[] pre = { 10, 20, 40, 50, 70, 30, 60 };
		// int[] in = { 40, 20, 50, 70, 10, 30, 60 };

		int[] pre = { 10, 20, 40, 80, 90, 190, 160, 50, 30, 60, 100, 120, 130, 140, 70 };
		int[] in = { 80, 40, 90, 190, 160, 20, 50, 10, 100, 60, 130, 120, 140, 30, 70 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		// System.out.println(bt.size());
		// System.out.println(bt.max());
		// System.out.println(bt.ht());
		// System.out.println(bt.find(50));
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameter2());
		//
		// System.out.println(bt.isBalanced());
		//
		// bt.preorder();
		// bt.preorderI();
		//
		// bt.verticalDisplay();

		bt.kFar(3, 20);
	}
}
