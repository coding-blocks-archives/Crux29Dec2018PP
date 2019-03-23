package L20_March23;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class HashMapOps {

	public static void main(String[] args) {

		System.out.println(highestFreqChar("aaaabaacccdefcccccccccccc"));

		int[] one = { 2, 10, 3, 3, 1, 2, 5, 10, 10, 20 };
		int[] two = { 2, 15, 16, 3, 3, 5, 5, 10, 15 };

		System.out.println(intersection(one, two));
	}

	public static char highestFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) {

				int of = map.get(ch);
				int nf = of + 1;
				map.put(ch, nf);

			} else {
				map.put(ch, 1);
			}
		}

		int maxFreq = 0;
		char maxChar = ' ';

		for (Character key : map.keySet()) {

			int val = map.get(key);

			if (val > maxFreq) {
				maxFreq = val;
				maxChar = key;

			}

		}

		return maxChar;

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();

		// create freq map using first array
		for (int i = 0; i < one.length; i++) {

			int val = one[i];

			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);
			} else {
				map.put(val, 1);
			}

		}

		// iterate on second array
		for (int j = 0; j < two.length; j++) {

			int val = two[j];

			// check which are already present in map
			if (map.containsKey(val)) {

				ans.add(val);

				map.put(val, map.get(val) - 1);

				if (map.get(val) == 0) {
					map.remove(val);
				}

			}

		}

		return ans;

	}
}
