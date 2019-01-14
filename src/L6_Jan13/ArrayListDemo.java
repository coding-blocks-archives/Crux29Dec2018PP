package L6_Jan13;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jan-2019
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		// add : O(1)
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		System.out.println(list);

		// size : O(1)
		System.out.println(list.size());

		// add At : 0 -> size : O(n)/O(1)
		list.add(2, 50);
		list.add(0, 60);
		System.out.println(list);

		// set : 0 -> size-1 : O(1)
		list.set(3, 100);
		System.out.println(list);

		// remove : 0 -> size-1 : O(n)/O(1)
		list.remove(2);
		System.out.println(list);

		// get : O(1)
		System.out.println(list.get(3));

		for (int val : list) {
			System.out.println(val);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
