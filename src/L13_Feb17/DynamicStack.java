package L13_Feb17;

import L12_Feb16.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Feb-2019
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) {
		if (isFull()) {

			int[] na = new int[this.data.length * 2];

			// copy
			for (int i = 0; i < this.data.length; i++) {
				na[i] = this.data[i];
			}

			// reference change
			this.data = na;

		}

		try {
			super.push(item);
		} catch (Exception e) {

		}

	}

}
