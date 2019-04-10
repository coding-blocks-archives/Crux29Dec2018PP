package L25_April7;

import java.util.HashMap;

import L21_March24.HeapGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class HuffmanCoding {

	private class Node implements Comparable<Node> {

		char ch;
		int cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}
	}

	HashMap<Character, String> encoder = new HashMap<>();
	HashMap<String, Character> decoder = new HashMap<>();

	public HuffmanCoding(String str) {

		// 1. create a freq map
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}

		// 2. create a new pair and put in heap
		HeapGeneric<Node> heap = new HeapGeneric<>();

		for (char key : fmap.keySet()) {

			Node nn = new Node();
			nn.ch = key;
			nn.cost = fmap.get(key);

			heap.add(nn);

		}

		// 3. remove two pairs, create a new pair and put in heap
		while (heap.size() != 1) {

			Node ln = heap.remove();
			Node rn = heap.remove();

			Node merged = new Node();
			merged.cost = ln.cost + rn.cost;
			merged.left = ln;
			merged.right = rn;

			heap.add(merged);

		}

		// 4. fill encoder decoder hashmap
		Node lastNode = heap.remove();

		fillEncoderDecoder(lastNode, "");

		System.out.println(encoder);
		System.out.println(decoder);

	}

	public void fillEncoderDecoder(Node node, String ans) {

		if (node.left == null && node.right == null) {
			encoder.put(node.ch, ans);
			decoder.put(ans, node.ch);

			return;

		}

		fillEncoderDecoder(node.left, ans + "0");
		fillEncoderDecoder(node.right, ans + "1");

	}

	public String encode(String str) {

		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			ans += encoder.get(ch);
		}

		return ans;

	}

	public String decode(String str) {

		String ans = "";
		String key = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			key += ch;

			if (decoder.containsKey(key)) {
				ans += decoder.get(key);
				key = "";
			}

		}

		return ans;

	}

}
