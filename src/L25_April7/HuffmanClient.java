package L25_April7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Apr-2019
 *
 */

public class HuffmanClient {

	public static void main(String[] args) {

		String str = "aaaabcddddd";

		HuffmanCoding hc = new HuffmanCoding(str);

		System.out.println(hc.encode("abcdddd"));
		System.out.println(hc.decode("111001010000"));
	}
}
