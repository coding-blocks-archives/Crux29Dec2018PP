package L25_April7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class SegmentTree {

	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;

		@Override
		public String toString() {
			return "[" + si + "-" + ei + "] : " + this.data + " ";
		}
	}

	private Node root;
	private SegmentTreeI segmentTreeI;

	public SegmentTree(int[] arr, SegmentTreeI segmentTreeI) {

		this.segmentTreeI = segmentTreeI;
		this.root = construct(arr, 0, arr.length - 1);

	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo == hi) {
			Node ln = new Node();
			ln.si = lo;
			ln.ei = hi;
			ln.data = arr[lo];
			return ln;
		}

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;

		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);

		nn.data = segmentTreeI.operation(nn.left.data, nn.right.data);

		return nn;

	}

	public void display() {
		System.out.println("-----------------");
		display(this.root);
		System.out.println("-----------------");
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

	public int query(int qsi, int qei) {
		return query(this.root, qsi, qei);
	}

	private int query(Node n, int qsi, int qei) {

		if (n.si >= qsi && n.ei <= qei) { // full contribution
			return n.data;
		} else if (n.ei < qsi || n.si > qei) { // no contribution
			return segmentTreeI.defaultValue();
		} else { // overlapping

			int lquery = query(n.left, qsi, qei);
			int rquery = query(n.right, qsi, qei);

			int queryres = segmentTreeI.operation(lquery, rquery);

			return queryres;
		}

	}

	public void update(int idx, int item) {

		update(this.root, idx, item);
	}

	private int update(Node n, int idx, int item) {

		if (n.si == idx && n.ei == idx) {
			n.data = item;
			return n.data;
		} else if (idx >= n.si && idx <= n.ei) {

			int lupdate = update(n.left, idx, item);
			int rupdate = update(n.right, idx, item);

			n.data = segmentTreeI.operation(lupdate, rupdate);

			return n.data;
		} else {
			return n.data;
		}

	}

}
