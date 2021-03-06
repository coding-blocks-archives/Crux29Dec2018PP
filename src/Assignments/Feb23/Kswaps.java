package Assignments.Feb23;

import java.util.Scanner;

public class Kswaps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.next();
		char[] arr = str.toCharArray();

		System.out.println(BiggestNum(arr, scn.nextInt()));

	}

	public static String BiggestNum(char[] arr, int k) {

		long max = Integer.valueOf(new String(arr));
		if (k == 0)
			return max + "";

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] > arr[i]) {

					swap(arr, i, j);

					long rec = Integer.valueOf(BiggestNum(arr, k - 1));
					max = Math.max(max, rec);

					swap(arr, i, j);
				}
			}
		}

		return max + "";

	}

	public static void swap(char[] arr, int ith, int jth) {

		char temp = arr[ith];
		arr[ith] = arr[jth];
		arr[jth] = temp;
	}

}
