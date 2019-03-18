package L19_March18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Mar-2019
 *
 */

public class AVLTree {

	private class Node {
		int data;
		Node left;
		Node right;
		int height;

		public Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	private Node root;

	private int ht(Node node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}

	private int bf(Node node) {
		if (node == null) {
			return 0;
		}

		return ht(node.left) - ht(node.right);
	}

	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item <= node.data) {
			node.left = insert(node.left, item);
		} else {
			node.right = insert(node.right, item);
		}

		node.height = Math.max(ht(node.left), ht(node.right)) + 1;

		int balancingFactor = bf(node);

		// LL Case
		if (balancingFactor > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// RR Case
		if (balancingFactor < -1 && item > node.right.data) {
			return leftRotate(node);
		}

		// LR Case
		if (balancingFactor > 1 && item > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RL Case
		if (balancingFactor < -1 && item < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	private Node rightRotate(Node c) {

		// capture
		Node b = c.left;
		Node T3 = b.right;

		// rotate
		b.right = c;
		c.left = T3;

		// ht
		c.height = Math.max(ht(c.left), ht(c.right)) + 1;
		b.height = Math.max(ht(b.left), ht(b.right)) + 1;

		return b;

	}

	private Node leftRotate(Node c) {

		// capture
		Node b = c.right;
		Node T2 = b.left;

		// rotate
		b.left = c;
		c.right = T2;

		// ht
		c.height = Math.max(ht(c.left), ht(c.right)) + 1;
		b.height = Math.max(ht(b.left), ht(b.right)) + 1;

		return b;

	}

}
