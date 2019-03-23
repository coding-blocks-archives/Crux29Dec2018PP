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

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put
		map.put("India", 100);
		map.put("SL", 20);
		map.put("Aus", 500);
		System.out.println(map);
		map.put("SL", 300);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("Bang"));

		// containsKey
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("Bang"));

		// remove
		System.out.println(map.remove("SL"));
		System.out.println(map.remove("Bang"));

		// map print
		System.out.println(map);

		// way 1
		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 2
		ArrayList<String> keysal = new ArrayList<>(map.keySet());

		for (String key : keysal) {
			System.out.println(key + " -> " + map.get(key));
		}

	}
}
