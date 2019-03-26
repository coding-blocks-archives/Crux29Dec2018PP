package L21_March24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Mar-2019
 *
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();
		int[] arr = { 5, 10, 2, 3, 7, 8, 90 };

		for (int val : arr) {
			heap.add(val);
		}
		heap.display();

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
	}
}




