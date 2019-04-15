package L21_March24;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Mar-2019
 *
 */

public class HeapGeneric<T extends Comparable<T>> {

	HashMap<T, Integer> map = new HashMap<>(); // prims

	ArrayList<T> data = new ArrayList<>();

	public void add(T item) {

		data.add(item);
		map.put(item, data.size() - 1); // prims
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

		map.put(ith, j); // prims
		map.put(jth, i); // prims

	}

	public T remove() {

		swap(0, data.size() - 1);
		T temp = data.remove(data.size() - 1);
		map.remove(temp); // prims
		downheapify(0);
		return temp;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public T getHP() {
		return data.get(0);
	}

	// t priority > +ve
	// t priority < -ve
	private int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public int size() {
		return this.data.size();
	}

	public void updatePriority(T t) {

		// n
		// int si = -1;
		//
		// for (int i = 0; i < data.size(); i++) {
		// if (data.get(i) == t) {
		// si = i;
		// break;
		// }
		// }

		int si = map.get(t);

		upheapify(si);

	}

}
