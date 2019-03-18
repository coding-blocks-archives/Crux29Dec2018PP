package Assignments.March16;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Mar-2019
 *
 */

public class Histogram {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		long[] arr = new long[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		Stack<Integer> stack = new Stack<>();
		long maxArea = Integer.MIN_VALUE;

		long pArea = 0;

		int i = 0;

		while (i < arr.length) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {

				int top = stack.pop();

				if (stack.isEmpty()) {

					int R = i;
					pArea = R * arr[top];

				} else {
					int L = stack.peek();
					int R = i;

					pArea = (R - L - 1) * arr[top];

				}

				if (pArea > maxArea) {
					maxArea = pArea;
				}

			}

		}

		while (!stack.isEmpty()) {

			int top = stack.pop();

			if (stack.isEmpty()) {

				int R = i;
				pArea = R * arr[top];

			} else {
				int L = stack.peek();
				int R = i;

				pArea = (R - L - 1) * arr[top];

			}

			if (pArea > maxArea) {
				maxArea = pArea;
			}

		}

		System.out.println(maxArea);
	}
}
