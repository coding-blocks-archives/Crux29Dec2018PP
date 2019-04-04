package L22_April2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Apr-2019
 *
 */

public class Client {

	public static void main(String[] args) {

//		String src = "abcdedefabc" ;
//		String pat = "def" ;
//		
//		System.out.println(wordMatching(src, pat));
		
		Set<Integer> ans = new HashSet<>() ;
		Trie trie = new Trie() ;
		
		trie.addWord("bee");
		trie.addWord("been");
		trie.addWord("arc");
		trie.addWord("ant");
//		trie.addWord("and");
		trie.addWord("an");
		
		
		trie.displayWords();
		
		trie.removeWord("an");
		
		trie.displayTrie();
		trie.removeWord("ant");
		trie.displayTrie();
	}

	public static int wordMatching(String src, String pat) {

		int i = 0;

		while (i <= src.length() - pat.length()) {

			int j = 0;

			while (j < pat.length()) {

				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}

				j++;
			}

			if (j == pat.length()) {
				return i;
			}

			i++;

		}

		return -1;
	}
}
