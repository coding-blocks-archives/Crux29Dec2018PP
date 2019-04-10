package L25_April7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class SegmentTreeMin implements SegmentTreeI {

	@Override
	public int operation(int left, int right) {
		return Math.min(left, right) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE ;
	}

}
