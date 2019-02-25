package L14_Feb24.Adapters;

import L13_Feb17.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Feb-2019
 *
 */

public class StackUsingQueuePopEff {

	DynamicQueue primary = new DynamicQueue();

	public void push(int item) throws Exception {

		try {

			DynamicQueue helper = new DynamicQueue();
			helper.enqueue(item);

			while (!primary.isEmpty()) {
				helper.enqueue(primary.dequeue());
			}

			primary = helper;

		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}

	}

	public int pop() throws Exception {

		try {
			return primary.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int peek() throws Exception {

		try {
			return primary.getFront();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
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

	public void display() throws Exception {
		primary.display();
	}

}
