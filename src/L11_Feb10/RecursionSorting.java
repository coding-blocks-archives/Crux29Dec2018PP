package L11_Feb10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Feb-2019
 *
 */

public class RecursionSorting {

	public static void main(String[] args) {

		int[] arr = { 60, 80, 10, 30, 90, 120 };

		// int[] ans = mergeSort(arr, 0, arr.length - 1);
		QuickSort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				i++;
				k++;
			} else {
				merged[k] = two[j];
				j++;
				k++;
			}
		}

		if (i == one.length) {

			while (j < two.length) {
				merged[k] = two[j];
				j++;
				k++;
			}

		}

		if (j == two.length) {

			while (i < one.length) {
				merged[k] = one[i];
				i++;
				k++;
			}

		}

		return merged;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] sorted = mergeTwoSortedArrays(fh, sh);

		return sorted;

	}

	public static void QuickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int left = lo;
		int right = hi;

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		QuickSort(arr, lo, right);
		QuickSort(arr, left, hi);

	}

}
