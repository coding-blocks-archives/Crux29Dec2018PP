package L14_Feb24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Feb-2019
 *
 */

public class Client {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);

		list.display();
		//
		// System.out.println(list.getAt(2));
		// System.out.println(list.getFirst());
		// System.out.println(list.getLast());
		//
		// System.out.println(list.removeFirst());
		// list.display();
		// list.addFirst(200);
		// System.out.println(list.removeLast());
		// list.display();

		// list.reverseDataIter();
		//
		// list.display();
		//
		// list.reversePointerIter();
		// list.display();
		//
		// list.reversePointerRec();
		// list.display();

		list.fold();
		list.display();

		list.addLast(900);
		list.addLast(800);
		list.addLast(700);
		list.display();

		System.out.println(list.mid());
		System.out.println(list.kthFromLast(3));

		list.display();
		list.kReverse(3);
		list.display();

		list.addLast(0);
		list.display();

		list.mergeSort();

		list.display();

		// list.createDummyList();

		System.out.println(list.detectRemoveLoop());
		list.display();

	}
}
