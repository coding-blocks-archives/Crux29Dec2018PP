package L6_Jan13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jan-2019
 *
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("hello");

		// char At
		System.out.println(sb.charAt(2));

		// length
		System.out.println(sb.length());

		// setCharAt
		sb.setCharAt(2, 'y');
		System.out.println(sb);

		// append
		sb.append("qwe");
		System.out.println(sb);

		// insert
		sb.insert(2, "abc");
		System.out.println(sb);

		// delete
		sb.deleteCharAt(3);
		System.out.println(sb);

		// sb -> string
		System.out.println(sb.toString());

		// string -> sb
		String str = "hello";
		StringBuilder sb1 = new StringBuilder(str);

	}

	public static String printChar() {

		StringBuilder sb = new StringBuilder("hello");

		return sb.toString();

	}

}
