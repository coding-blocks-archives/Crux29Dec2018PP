package L4_Jan5;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jan-2019
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[] array = takeInput();
		// display(array);

		// display(takeInput());

		// int[] arr = { 50, 40, 30, 20, 10 };
		// int ans = maximum(arr);
		// System.out.println(ans);
		// int item = scn.nextInt();
		// System.out.println(linearSearch(arr, item));
		// System.out.println(binarySearch(arr, item));

		// reverse(arr);
		// int[] ans = rotate(arr, -100);

		// int[] inv = inverse(arr);
		// display(inv);

		// bubbleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);
		// display(arr);

		int[] arr = new int[1000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		long start = System.currentTimeMillis();
		bubbleSort(arr);
		long end = System.currentTimeMillis();
		
		
		System.out.println(end - start);
	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Value for " + i + " th index ?");
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;

	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static void subsets(int[] arr) {

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) { // right side
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

	public static int[] rotate(int[] arr, int r) {

		r = r % arr.length;

		if (r < arr.length) {
			r = r + arr.length;
		}

		int[] na = new int[arr.length];

		for (int i = 0; i < na.length; i++) {

			if (i < r) {
				na[i] = arr[i + arr.length - r];
			} else {
				na[i] = arr[i - r];
			}

		}

		return na;

	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		for (int i = 0; i < inv.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;

		boolean flag = true;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					flag = false;
				}
			}

			if (flag)
				break;

		}

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			int min = counter;

			for (int j = counter + 1; j <= n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[counter];
			arr[counter] = arr[min];
			arr[min] = temp;

		}

	}

	public static void insertionSort(int[] arr) {

		int n = arr.length;

		for (int counter = 1; counter <= n - 1; counter++) {

			int temp = arr[counter];

			int j = counter - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;
		}

	}

}
