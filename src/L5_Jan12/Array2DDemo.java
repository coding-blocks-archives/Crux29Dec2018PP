package L5_Jan12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jan-2019
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];
		System.out.println(arr);

		System.out.println(arr.length);
		System.out.println(arr[0].length);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		arr[0][2] = 10;
		System.out.println(arr[0][2]);
		System.out.println(arr[0][3]);

		System.out.println(" -- Jagged Array --");
		int[][] jarr = new int[3][];

		System.out.println(jarr);

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[5];
		jarr[1] = new int[3];
		jarr[2] = new int[6];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

	}

}






