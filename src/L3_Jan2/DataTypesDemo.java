package L3_Jan2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class DataTypesDemo {

	public static void main(String[] args) {

		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// case 1
		// by = sh ;
		// by = in ;
		// by = lo;

		sh = by; // padding -> MSB
		// sh = in ;
		// sh = lo;

		in = by;
		in = sh;
		// in = lo;

		lo = by;
		lo = sh;
		lo = in;

		// case 2
		by = 10;
		by = (byte) 1060;
		System.out.println(by);

		by = 0;
		while (by <= 126) {
			System.out.println(by);
			by++;
		}

		// case 3
		lo = 10000000000L;
		System.out.println(lo);

		// case 4
		float fl = 5.5f;
		double db = 5.5;
		// fl = db;
		db = fl;

		// case 5
		in = (int) fl;
		System.out.println(in);
		fl = in;
		System.out.println(fl);

		// case 6
		boolean bl = true;

		// if(in) {
		//
		//
		// }

		if (in > 0) {

		}

		if (bl) {

		}

		// case 7
		char ch = 'a';
		System.out.println((int) ch);
		ch = 99;
		System.out.println(ch);
		ch = (char) in;
		in = ch;
		ch = 'c';

		ch = (char) (ch + 1);
		System.out.println(ch);

		// case 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");

	}

}
