package L21_March24;

import java.util.ArrayList;

import L20_March23.FxnGenerics.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Mar-2019
 *
 */

public class HeapGenericClient {

	public static void main(String[] args) {

		Car[] cars = new Car[5];
		cars[0] = new Car(10, 200, "Black");
		cars[1] = new Car(20, 100, "White");
		cars[2] = new Car(3, 50, "Grey");
		cars[3] = new Car(4, 278, "Yellow");
		cars[4] = new Car(34, 2900, "Red");

		HeapGeneric<Car> heapg = new HeapGeneric<>();

		for (int i = 0; i < cars.length; i++) {
			heapg.add(cars[i]);
		}

		while (!heapg.isEmpty()) {
			System.out.println(heapg.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);

		lists.get(3).add(2);
		lists.get(3).add(3);

		System.out.println(lists);

		System.out.println(mergeKSortedLists(lists));

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(3);
		arr.add(4);
		arr.add(9);
		arr.add(80);

		System.out.println(kLargestElements(arr, 3));

	}

	private static class Pair implements Comparable<Pair> {
		int item;
		int listNo;
		int idx;

		@Override
		public int compareTo(Pair o) {
			return o.item - this.item;
		}

	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {

			Pair np = new Pair();
			np.item = lists.get(i).get(0);
			np.idx = 0;
			np.listNo = i;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			// remove the pair with highest priority
			Pair rp = heap.remove();

			// ans store
			ans.add(rp.item);

			// update the pair and put in heap
			rp.idx++;

			if (rp.idx < lists.get(rp.listNo).size()) {
				rp.item = lists.get(rp.listNo).get(rp.idx);
				heap.add(rp);
			}

		}

		return ans;

	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			if (list.get(i) > heap.getHP()) {
				heap.remove();
				heap.add(list.get(i));
			}
		}

		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}

		return ans;

	}

}
