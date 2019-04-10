package L25_April7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 10, 3, -6, -4, 12, 13 };

		SegmentTree st = new SegmentTree(arr , new SegmentTreeMin());
		st.display();

		System.out.println(st.query(2, 6));
		System.out.println(st.query(0, 2));

		st.update(3, 13);

		System.out.println(st.query(0, 3));

	}
}
