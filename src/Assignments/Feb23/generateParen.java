package Assignments.Feb23;

public class generateParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		generate(6, 0, 0, "");

	}

	static int count = 0;

	public static void generate(int n, int open, int close, String asf) {

		if (open == n && close == n) {
			System.out.println(++count + " " + asf);
			return;
		}

		if (close > open || close > n || open > n) {
			return;
		}

		generate(n, open, close + 1, asf + ")");
		generate(n, open + 1, close, asf + "(");

	}

	public static void generate_dummy(int n, int open, int close, String asf) {

		if (close > open) {
			return;
		}

		if (n == 0) {
			if (open == close) {
				System.out.println(asf);

			}
			return;
		}

		generate_dummy(n - 1, open + 1, close, asf + "(");
		generate_dummy(n - 1, open, close + 1, asf + ")");

	}

}
