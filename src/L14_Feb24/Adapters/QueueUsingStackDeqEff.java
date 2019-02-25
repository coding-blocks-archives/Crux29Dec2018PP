package L14_Feb24.Adapters;

import L13_Feb17.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Feb-2019
 *
 */

public class QueueUsingStackDeqEff {

	DynamicStack primary = new DynamicStack();

	public void enqueue(int item) throws Exception {

		try {

			DynamicStack helper = new DynamicStack();

			while (!primary.isEmpty()) {
				helper.push(primary.pop());
			}

			primary.push(item);

			while (!helper.isEmpty()) {
				primary.push(helper.pop());
			}

		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int dequeue(int item) throws Exception {

		try {
			return primary.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}

	public int getFront(int item) throws Exception {

		try {
			return primary.peek();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return primary.isEmpty();
	}

	public boolean isFull() {
		return primary.isFull();
	}

	public void display() {
		primary.display();
	}

}
