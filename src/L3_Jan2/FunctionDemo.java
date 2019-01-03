package L3_Jan2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class FunctionDemo {

	static int val = 80;

	public static void main(String[] args) {

		// Part-1
		System.out.println("----------- Part-1 -----------");
		addition(); // fxn calling
		subtraction();

		// Part-2
		System.out.println("----------- Part-2 -----------");
		int a = 4;
		int b = 9;
		additionParams(a, b);
		additionParams(5, 6);

		// Part-3
		System.out.println("----------- Part-3 -----------");
		int sum = additionParamsReturn(4, 10);
		System.out.println(sum);

		// Part-4
		System.out.println("----------- Part-4 -----------");
		int one = 10, two = 20;
		int summ = DemoScopes(one, two);
		System.out.println(summ);

		// Part-5
		System.out.println("----------- Part-5 -----------");
		System.out.println(val); // 80
		int val = 200;
		System.out.println(val); // 200
		System.out.println(FunctionDemo.val); // 80
		int ans = DemoGlobalScopes(one);
		System.out.println(FunctionDemo.val);
		System.out.println(ans);

		// Part 6 - Pass by value
		System.out.println("----------- Part-6 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int DemoGlobalScopes(int one) {
		val = 600;
		int val = 100;

		int sum = one + FunctionDemo.val;
		return sum;
	}

	public static int DemoScopes(int one, int another) {

		int sum = one + another;
		return sum;
	}

	// fxn definition
	public static void addition() {
		int a = 4;
		int b = 5;

		int sum = a + b;
		subtraction();
		System.out.println(sum);

	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);

	}

	public static int additionParamsReturn(int a, int b) {

		int sum = a + b;
		return sum;

	}

	// fxn definition
	public static void subtraction() {
		int a = 9;
		int b = 2;

		int sub = a - b;
		System.out.println(sub);
	}

}
