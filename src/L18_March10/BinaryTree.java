package L18_March10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Mar-2019
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, false);
	}

	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}

		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		// create a new node
		Node nn = new Node();
		nn.data = pre[plo];

		// search plo in inorder
		int si = -1;

		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;
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

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class DiaPair {
		int height = -1;
		int diameter = 0;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private DiaPair diameter2(Node node) {

		if (node == null) {
			DiaPair bdp = new DiaPair();
			return bdp;
		}

		// rec result
		DiaPair ldp = diameter2(node.left);
		DiaPair rdp = diameter2(node.right);

		// self diameter
		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sp = ldp.height + rdp.height + 2;
		int fd = Math.max(sp, Math.max(ld, rd));

		// self height
		int fh = Math.max(ldp.height, rdp.height) + 1;

		// new pair
		DiaPair fdp = new DiaPair();
		fdp.diameter = fd;
		fdp.height = fh;

		return fdp;

	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced() {
		return isBalanced2(this.root).isBal;
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = Math.abs(ht(node.left) - ht(node.right));

		if (lb && rb && bf <= 1) {
			return true;
		} else {
			return false;
		}

	}

	private BalPair isBalanced2(Node node) {

		if (node == null) {
			BalPair bbp = new BalPair();
			return bbp;
		}

		BalPair lbp = isBalanced2(node.left);
		BalPair rbp = isBalanced2(node.right);

		BalPair mbp = new BalPair();

		int bf = Math.abs(lbp.ht - rbp.ht);

		if (lbp.isBal && rbp.isBal && bf <= 1) {
			mbp.isBal = true;
		} else {
			mbp.isBal = false;
		}

		mbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return mbp;
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);

	}

	private class Pair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	public void preorderI() {

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.node = this.root;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.getFirst();

			if (tp.selfDone == false) {

				System.out.print(tp.node.data + " ");
				tp.selfDone = true;

			} else if (tp.leftDone == false) {

				Pair np = new Pair();
				np.node = tp.node.left;

				if (np.node != null)
					stack.addFirst(np);

				tp.leftDone = true;

			} else if (tp.rightDone == false) {

				Pair np = new Pair();
				np.node = tp.node.right;

				if (np.node != null)
					stack.addFirst(np);

				tp.rightDone = true;

			} else {
				stack.removeFirst();
			}

		}
		System.out.println();

	}

	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	}

	public boolean isTreeBST() {
		return isTreeBST(this.root).isBST;
	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			BSTPair bp = new BSTPair();
			return bp;
		}

		BSTPair lp = isTreeBST(node.left);
		BSTPair rp = isTreeBST(node.right);

		BSTPair sp = new BSTPair();

		if (lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min) {
			sp.isBST = true;
		} else {
			sp.isBST = false;
		}

		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		return sp;

	}

	private class VOPair implements Comparable<VOPair> {

		int data;
		int vd;
		int hd;

		@Override
		public String toString() {
			return this.data + "";
		}

		@Override
		public int compareTo(VOPair o) {
			return this.hd - o.hd;
		}
	}

	public void verticalDisplay() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();
		verticalDisplay(this.root, map, 0, 0);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		for (int key : keys) {

			ArrayList<VOPair> list = map.get(key);
			// Collections.sort(list, new VOPairComparator());
			Collections.sort(list);

			System.out.println(key + "->" + list);
		}
	}

	private void verticalDisplay(Node node, HashMap<Integer, ArrayList<VOPair>> map, int vDist, int hDist) {

		if (node == null) {
			return;
		}

		VOPair np = new VOPair();
		np.data = node.data;
		np.hd = hDist;
		np.vd = vDist;

		if (!map.containsKey(vDist)) {
			map.put(vDist, new ArrayList<>());
		}

		map.get(vDist).add(np);

		verticalDisplay(node.left, map, vDist - 1, hDist + 1);
		verticalDisplay(node.right, map, vDist + 1, hDist + 1);
	}

	private class VOPairComparator implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			return o1.hd - o2.hd;
		}

	}

	private class IntegerComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.intValue() - o1.intValue();
		}

	}

	public void kFar(int k, int dst) {
		kFar(this.root, k, dst);
	}

	private int kFar(Node node, int k, int dst) {

		if (node == null) {
			return -1;
		}

		if (node.data == dst) {
			kDown(node, 0, k);
			return 0;
		}

		int ld = kFar(node.left, k, dst);

		if (ld != -1) {

			if (ld + 1 == k) {
				System.out.println(node.data);
			}

			kDown(node.right, 0, k - ld - 2);

			return ld + 1;
		}

		int rd = kFar(node.right, k, dst);

		if (rd != -1) {

			if (rd + 1 == k) {
				System.out.println(node.data);
			}

			kDown(node.left, 0, k - rd - 2);

			return rd + 1;
		}

		return -1;

	}

	private void kDown(Node node, int count, int k) {

		if (node == null) {
			return;
		}

		if (count == k) {
			System.out.println(node.data);
			return;
		}

		kDown(node.left, count + 1, k);
		kDown(node.right, count + 1, k);
	}

}
