package L22_April2;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Apr-2019
 *
 */

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> table;

		public Node(char ch) {

			this.ch = ch;
			this.eow = false;
			table = new HashMap<>();

		}
	}

	private Node root;

	public Trie() {
		this.root = new Node('*');
	}

	public void addWord(String word) {
		addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {

		if (word.length() == 0) {
			parent.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean isCharPresent = parent.table.containsKey(ch);

		if (isCharPresent) {
			addWord(parent.table.get(ch), row);
		} else {

			Node nn = new Node(ch);
			parent.table.put(ch, nn);

			addWord(nn, row);
		}

	}

	public boolean searchWord(String word) {
		return searchWord(this.root, word);
	}

	private boolean searchWord(Node parent, String word) {

		if (word.length() == 0) {
			return parent.eow;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean isCharPresent = parent.table.containsKey(ch);

		if (isCharPresent) {
			return searchWord(parent.table.get(ch), row);
		} else {
			return false;
		}

	}

	public void removeWord(String word) {
		removeWord(this.root, word);
	}

	private void removeWord(Node parent, String word) {

		if (word.length() == 0) {
			parent.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean isCharPresent = parent.table.containsKey(ch);

		if (isCharPresent) {
			Node child = parent.table.get(ch);
			removeWord(child, row);

			if (child.eow == false && child.table.size() == 0) {
				parent.table.remove(ch);
			}

		} else {
			return;
		}

	}

	public void displayWords() {

		System.out.println("-----------------");
		displayWords(this.root, "");
		System.out.println("-----------------");
	}

	private void displayWords(Node parent, String wsf) {

		if (parent.eow) {
			System.out.println(wsf);
		}

		for (char ch : parent.table.keySet()) {
			displayWords(parent.table.get(ch), wsf + ch);
		}
	}

	public void displayTrie() {
		System.out.println("-----------------");
		displayTrie(this.root);
		System.out.println("-----------------");
	}

	private void displayTrie(Node parent) {

		String str = parent.ch + " -> ";

		for (char key : parent.table.keySet()) {
			str += key + ", ";
		}

		str += ".";
		System.out.println(str);

		for (char ch : parent.table.keySet()) {
			displayTrie(parent.table.get(ch));
		}
	}

	public boolean prefixWord(String word) {
		return prefixWord(this.root, word);
	}

	private boolean prefixWord(Node parent, String word) {

		if (word.length() == 0) {
			return true;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean isCharPresent = parent.table.containsKey(ch);

		if (isCharPresent) {
			return prefixWord(parent.table.get(ch), row);
		} else {
			return false;
		}

	}

	
}
