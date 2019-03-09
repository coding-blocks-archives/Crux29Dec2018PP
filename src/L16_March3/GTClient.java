package L16_March3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Mar-2019
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 600 0 30 1 70 0 40 2 80 0 90 0
	// 10 3 20 3 50 0 60 0 70 2 140 2 220 0 230 0 150 0 30 2 80 0 90 2 160 2 240 0
	// 250 0 170 0 40 2 100 0 110 2 200 2 280 0 290 0 210 0
	public static void main(String[] args) {

		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.find(800));
		System.out.println(gt.ht());

		// gt.preorder();
		// gt.postorder();
		// // gt.linearize();
		// gt.display();
		// gt.levelOrder();
		// gt.levelOrderLW();
		// gt.levelOrderZZ();

		gt.multiSolver(30);

	}
}
