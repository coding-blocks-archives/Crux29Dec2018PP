package L14_Feb24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Feb-2019
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
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
	public int getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {
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
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("-----------------");
	}

	// O(1)
	public void addLast(int item) {

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
	public void addFirst(int item) {

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
	public void addAt(int idx, int item) throws Exception {

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
	public int removeFirst() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		int rv = this.head.data;

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
	public int removeLast() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		int rv = this.tail.data;

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
	public int removeAt(int idx) throws Exception {

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

	public void reverseDataIter() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}
	}

	public void reversePointerIter() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {

			Node ahead = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		// head & tail swap
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	public void reversePointerRec() {
		reversePointerRec(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	private void reversePointerRec(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePointerRec(curr, curr.next);

		curr.next = prev;

	}

	public void reverseDataRecReturn() {
		reverseDataRecReturn(this.head, this.head, 0);
	}

	private Node reverseDataRecReturn(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = reverseDataRecReturn(left, right.next, count + 1);

		// swap
		if (count >= this.size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}

		return left.next;

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDataRecHeap() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;

		reverseDataRecHeap(mover, this.head, 0);

	}

	private void reverseDataRecHeap(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDataRecHeap(mover, right.next, count + 1);

		// swap
		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;

			mover.left = mover.left.next;

		}
	}

	public void fold() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;

		// fold(mover, this.head, 0);
		foldReturn(this.head, this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		if (count > size / 2) {
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;

			mover.left = ahead;
		}

		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	private Node foldReturn(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = foldReturn(left, right.next, count + 1);

		if (count > size / 2) {

			Node ahead = left.next;

			left.next = right;
			right.next = ahead;

			return ahead;
		}

		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

		return null;

	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;
	}

	private Node midNode() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow;
	}

	public int kthFromLast(int k) {

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;

		while (!this.isEmpty()) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;

			}

		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void removeDuplicatesSorted() {

	}

	public void createDummyList() throws Exception {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;

		// n5.next = getNodeAt(3);

		this.head = n1;

	}

	public LinkedList mergeTwoSortedLL(LinkedList other) {

		LinkedList merged = new LinkedList();

		Node ttemp = this.head;
		Node otemp = other.head;

		while (ttemp != null && otemp != null) {

			if (ttemp.data < otemp.data) {
				merged.addLast(ttemp.data);
				ttemp = ttemp.next;
			} else {
				merged.addLast(otemp.data);
				otemp = otemp.next;
			}

		}

		if (ttemp == null) {
			while (otemp != null) {
				merged.addLast(otemp.data);
				otemp = otemp.next;
			}
		}

		if (otemp == null) {
			while (ttemp != null) {
				merged.addLast(ttemp.data);
				ttemp = ttemp.next;
			}
		}

		return merged;

	}

	public void mergeSort() {

		if (this.size == 1) {
			return;
		}

		Node mid = midNode();
		Node midn = mid.next;

		LinkedList fh = new LinkedList();

		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();

		sh.head = midn;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;

		fh.mergeSort();
		sh.mergeSort();

		LinkedList sorted = fh.mergeTwoSortedLL(sh);

		this.head = sorted.head;
		this.tail = sorted.tail;

	}

	public boolean detectRemoveLoop() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}

		}

		if (slow == fast) {

			// cycle removal
			Node start = this.head;
			Node loop = slow;

			while (start.next != loop.next && loop.next != head) {

				start = start.next;
				loop = loop.next;

			}

			loop.next = null;

			return true;
		} else {
			return false;
		}

	}

}
