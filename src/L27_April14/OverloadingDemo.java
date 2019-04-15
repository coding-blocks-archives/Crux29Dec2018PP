package L27_April14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Apr-2019
 *
 */

public class OverloadingDemo {

	public static void main(String[] args) {

		int[] array = {2,3,4,5} ;
		int a = add(2,3);
		// System.out.println(add(2, 3.5));
	}

	public static int add(int a, int b) {
		System.out.println("in add");
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	public static double add(int a, double b) {
		return a + b;
	}

	public static int add(int a , int b , int... arr) { // variable arguments

		System.out.println(arr[0]);
		int sum = 0;

		for (int val : arr) {
			sum += val;
		}

		return sum;
	}

}
