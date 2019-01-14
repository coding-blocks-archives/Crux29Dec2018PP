package L6_Jan13;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jan-2019
 *
 */

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";
		System.out.println(str);

		// length
		System.out.println(str.length());

		// charAt
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(str.length() - 1));

		// substring
		System.out.println(str.substring(2, 4)); // ll
		System.out.println(str.substring(1, 5)); // ello
		// System.out.println(str.substring(4, 3)); // exception
		System.out.println(str.substring(2, 2).length()); // blank
		System.out.println(str.substring(1)); // ello

		// concatenate
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// indexOf
		System.out.println("halabchl".indexOf("el"));

		// starts with
		System.out.println(str.startsWith("Hel"));
		System.out.println(str.startsWith("hel"));

		// equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2)); // true true
		System.out.println((s1 == s3) + ", " + s1.equals(s3)); // true true
		System.out.println((s1 == s4) + ", " + s1.equals(s4)); // false true

		str = "codingblocks";
		Scanner scn = new Scanner(System.in);
		// String s = scn.next();
		String s7 = str.substring(6);
		System.out.println(s7 == "blocks");

		str = str.replace('o', 'a');
		System.out.println(str);

		appendString();

	}

	public static void appendString() {

		long start = System.currentTimeMillis();

		String str = "";
		for (int i = 1; i <= 100000; i++) {
			str = str + i;
		}

		System.out.println(System.currentTimeMillis() - start);

	}

}
