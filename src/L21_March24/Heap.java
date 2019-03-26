package L21_March24;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Mar-2019
 *
 */

public class Heap {

	ArrayList<Integer> data = new ArrayList<>();

	public void add(int item) {

		data.add(item);
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		int ith = data.get(i);
		int jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public int remove() {

		swap(0, data.size() - 1);
		int temp = data.remove(data.size() - 1);
		downheapify(0);
		return temp;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (rci < data.size() && data.get(rci) < data.get(mini)) {
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

	public int getHP() {
		return data.get(0);
	}

}
