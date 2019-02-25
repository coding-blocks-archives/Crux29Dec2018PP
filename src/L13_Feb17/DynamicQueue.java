package L13_Feb17;

import L12_Feb16.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Feb-2019
 *
 */

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {

			int[] na = new int[this.data.length * 2];

			// copy
			for (int i = 0; i < this.size; i++) {

				int idx = (i + this.front) % this.data.length;
				na[i] = this.data[idx];

			}

			this.data = na;
			this.front = 0;

		}

		super.enqueue(item);

	}
}
