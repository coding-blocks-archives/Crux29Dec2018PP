package doubt_class;

import java.util.Scanner;

public class CB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		scn.nextInt();

		String str = scn.next();

		int count = 0;

		boolean[] visited = new boolean[str.length()];

		for (int len = 1; len <= str.length(); len++) {
			for (int si = 0; si <= str.length() - len; si++) {

				int ei = si + len;

				String ss = str.substring(si, ei);

				if (isValid(visited, si, ei) && isCBno(Integer.valueOf(ss))) {

					count++;

					for (int i = si; i < ei; i++) {
						visited[i] = true;
					}

				}

			}
		}

		System.out.println(count);

	}

	public static boolean isValid(boolean[] visited, int si, int ei) {

		for (int i = si; i < ei; i++) {

			if (visited[i]) {
				return false;
			}
		}

		return true;
	}

	public static boolean isCBno(int num) {

		if (num == 0 || num == 1) {
			return false;
		}

		int[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		for (int i = 0; i < arr.length; i++) {

			if (num == arr[i]) {
				return true;
			}

			if (num % arr[i] == 0) {
				return false;
			}
		}

		return true;

	}

}
