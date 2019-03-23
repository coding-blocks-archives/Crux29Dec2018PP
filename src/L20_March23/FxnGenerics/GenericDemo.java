package L20_March23.FxnGenerics;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class GenericDemo {

	public static void main(String[] args) {

		Integer[] arr = { 10, 20, 30, 40, 50 };
		display(arr);

		String[] sarr = { "hello", "hi", "bye" };
		display(sarr);

		Car[] cars = new Car[5];
		cars[0] = new Car(10, 200, "Black");
		cars[1] = new Car(20, 100, "White");
		cars[2] = new Car(3, 50, "Grey");
		cars[3] = new Car(4, 278, "Yellow");
		cars[4] = new Car(34, 2900, "Red");

		// bubbleSort(cars);
		bubbleSort(cars, new CarSpeedComaparator());
		display(cars);
		bubbleSort(cars, new CarPriceComaparator());
		display(cars);
		bubbleSort(cars, new CarColorComaparator());

		display(cars);
	}

	public static <T> void display(T[] arr) {

		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("----------------");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}

	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comp) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (comp.compare(arr[j], arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}

	}

}
