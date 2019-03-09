package L16_March3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Mar-2019
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		this.root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();
		nn.data = item;

		// no of children
		System.out.println("No of children for " + nn.data + " ?");
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {

			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(this.root);
		System.out.println("---------------------");
	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			ts += size(child);
		}

		return ts + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {

			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);

			if (cf)
				return true;
		}

		return false;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int i = 0;
		int j = node.children.size() - 1;

		while (i < j) {

			Node in = node.children.get(i);
			Node jn = node.children.get(j);

			node.children.set(i, jn);
			node.children.set(j, in);

			i++;
			j--;
		}

	}

	public void printAtLevel(int level) {
		printAtLevel(this.root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (count == level) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}
	}

	public void display2() {
		System.out.println("---------------------");
		display2(this.root);
		System.out.println("---------------------");
	}

	private void display2(Node node) {

		System.out.println("hii " + node.data);

		for (Node child : node.children) {
			System.out.println("Going Towards " + child.data);
			display2(child);
			System.out.println("Coming Back From " + child.data);
		}

		System.out.println("bye " + node.data);

	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		// self
		System.out.print(node.data + " ");

		// child
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
		System.out.println();
	}

	private void postorder(Node node) {

		// child
		for (Node child : node.children) {
			postorder(child);
		}

		// self
		System.out.print(node.data + " ");

	}

	public void linearize() {
		linearize(this.root);
	}

	private void linearize(Node node) {

		// smaller problem
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node tail = getTail(node.children.get(0));
			Node firstIndexChild = node.children.remove(1);
			tail.children.add(firstIndexChild);
		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);

		while (!queue.isEmpty()) {

			// remove
			Node rn = queue.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelOrderLW() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.add(this.root);

		while (!primary.isEmpty()) {

			// remove
			Node rn = primary.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();
			}
		}

		System.out.println();

	}

	public void levelOrderZZ() {

		int count = 1;

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.add(this.root);

		while (!queue.isEmpty()) {

			// remove
			Node rn = queue.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// child
			if (count % 2 == 0) {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			} else {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}
		}

		System.out.println();

	}

	private class HeapMover {

		int max = Integer.MIN_VALUE;
		int size = 0;
		int ht = 0;
		boolean find = false;

		Node pred;
		Node succ;

		int jl = Integer.MAX_VALUE;
	}

	public void multiSolver(int item) {

		HeapMover mover = new HeapMover();
		multiSolver(this.root, mover, 0, item);

		System.out.println("Max : " + mover.max);
		System.out.println("Ht : " + mover.ht);
		System.out.println("Size : " + mover.size);
		System.out.println("Find : " + mover.find);
		System.out.println("Pred : " + (mover.pred == null ? null : mover.pred.data));
		System.out.println("Succ : " + (mover.succ == null ? null : mover.succ.data));
		System.out.println("JL : " + mover.jl);
	}

	private void multiSolver(Node node, HeapMover mover, int count, int item) {

		mover.size++;

		if (node.data > mover.max) {
			mover.max = node.data;
		}

		if (count > mover.ht) {
			mover.ht = count;
		}

		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}

		if (node.data == item) {
			mover.find = true;
		}

		if (mover.find == false) {
			mover.pred = node;
		}

		if (node.data > item) {

			if (node.data < mover.jl) {
				mover.jl = node.data;
			}
		}

		for (Node child : node.children) {
			multiSolver(child, mover, count + 1, item);
		}

	}

}
