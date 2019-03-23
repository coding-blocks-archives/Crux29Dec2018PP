package L20_March23.ClassGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Feb-2019
 *
 */

public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size == 0;
	}

	// O(1)
	public T getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public T getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public T getAt(int idx) throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// O(n)
	public void display() {

		System.out.println("-----------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.println(temp.data + ", ");
			temp = temp.next;
		}

		// System.out.println(".");
		System.out.println("-----------------");
	}

	// O(1)
	public void addLast(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach with the existing linked list
		if (!isEmpty())
			this.tail.next = nn;

		// data members
		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	// O(1)
	public void addFirst(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = this.head;

		// data members
		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int idx, T item) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;

			// data members
			this.size++;

		}

	}

	// O(1)
	public T removeFirst() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		T rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public T removeLast() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		T rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;

			this.tail = sm2;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public T removeAt(int idx) throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;

		}

	}

}
