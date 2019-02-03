package doubt_class;

import java.util.*;

public class FormBiggestNumber {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int test = s.nextInt();
		for (int i = 0; i < test; i++) {
			int size = s.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = s.nextInt();
			}
			biggestNO(arr);
			for (int val : arr) {
				System.out.print(val);
			}
			System.out.println();
		}

	}

	public static void biggestNO(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (compare(arr[j], arr[j + 1]) > 0) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int compare(int a, int b) {
		String s1 = a + "" + b;
		String s2 = b + "" + a;
		int v1 = Integer.valueOf(s1);
		int v2 = Integer.valueOf(s2);

		if (v1 > v2) {
			return -1;
		} else {
			return 1;
		}
	}
}