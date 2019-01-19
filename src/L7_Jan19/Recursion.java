package L7_Jan19;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jan-2019
 *
 */

public class Recursion {

	public static void main(String[] args) {

		System.out.println("hi");
		System.out.println("bye");
		// PDI(5);
		// System.out.println(factorial(5));
		// System.out.println(fibonacci(200));
		int[] arr = { 10, 20, 30, 40, 30 };
		// displayRevArr(arr, 0);
		System.out.println(firstOccurence(arr, 0, 30));

	}

	public static void PD(int n) {

		if (n == 1) {
			return;
		}

		System.out.println(n);

		PD(n - 1);

	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		PI(n - 1);
		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);

	}

	public static int factorial(int n) {

		// base case
		if (n == 1) {
			return 1;
		}

		// smaller problem
		int fnm1 = factorial(n - 1);

		// self work
		int fn = fnm1 * n;

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);
		int pn = pnm1 * x;
		return pn;
	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void displayArr(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);

		displayArr(arr, vidx + 1);

	}

	public static void displayRevArr(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayRevArr(arr, vidx + 1);
		System.out.println(arr[vidx]);

	}

	public static int firstOccurence(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		int val = firstOccurence(arr, vidx + 1, item);

		return val;

	}

	public static int lastOccurence(int[] arr, int vidx, int item) {

	}

}
