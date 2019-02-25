package L13_Feb17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Feb-2019
 *
 */

public class DQClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue dq = new DynamicQueue();

		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		System.out.println(dq.dequeue());
		System.out.println(dq.dequeue());
		dq.enqueue(60);
		dq.enqueue(70);
		dq.enqueue(80);

		dq.display();

		// displayReverse(dq, 0);
		actualReverse(dq);

		dq.display();

		int[] arr = {13,15, 12, -2, 3, -1, -8, -6, 10, -7 };
		firstNegativeInteger(arr, 3);

	}

	public static void displayReverse(DynamicQueue q, int count) throws Exception {

		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);

		displayReverse(q, count + 1);

		System.out.println(temp);

	}

	public static void actualReverse(DynamicQueue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();
		actualReverse(q);
		q.enqueue(temp);

	}

	public static void firstNegativeInteger(int[] arr, int k) throws Exception {

		DynamicQueue queue = new DynamicQueue();

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				queue.enqueue(i);
			}
		}

		for (int i = k; i < arr.length; i++) {

			// first negative print
			if (queue.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(arr[queue.getFront()]);
			}

			// window update
			// useless remove / out of window
			if (!queue.isEmpty() && queue.getFront() <= i - k) {
				queue.dequeue();
			}

			// self element : insert only when it is -ve
			if (arr[i] < 0) {
				queue.enqueue(i);
			}

		}

		if (queue.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arr[queue.getFront()]);
		}
	}

	
}
