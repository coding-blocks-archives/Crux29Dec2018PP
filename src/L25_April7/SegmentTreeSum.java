package L25_April7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class SegmentTreeSum implements SegmentTreeI {

	@Override
	public int operation(int left, int right) {
		return left + right;
	}

	@Override
	public int defaultValue() {
		return 0;
	}

}
