package L20_March23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class HashMapOps {

	public static void main(String[] args) {

		// System.out.println(highestFreqChar("aaaabaacccdefcccccccccccc"));
		//
		// int[] one = { 2, 10, 3, 3, 1, 2, 5, 10, 10, 20 };
		// int[] two = { 2, 15, 16, 3, 3, 5, 5, 10, 15 };
		//
		// System.out.println(intersection(one, two));

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6, 4 };

		longestConsecutiveSeq(arr);
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

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int maxCount = 0;
		int startingSeq = 0;
		
		ArrayList<Integer> keys = new ArrayList<>(map.keySet()) ;
		
		for (int i =0 ; i < keys.size() ; i++) {

			int key = keys.get(i) ;
			
			// check only the elements which are starting of a seq
			if (map.containsKey(key) && map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxCount) {
					maxCount = count;
					startingSeq = key;
				}

			}

		}

		for (int i = 0; i < maxCount; i++) {
			System.out.println(startingSeq + i);
		}

	}

}
