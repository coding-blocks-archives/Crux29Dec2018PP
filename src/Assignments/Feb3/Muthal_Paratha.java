package doubt_class;

import java.util.Scanner;

public class Muthal_Paratha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int np = scn.nextInt();
		int nk = scn.nextInt();

		int[] cooks = new int[nk];

		for (int i = 0; i < nk; i++) {
			cooks[i] = scn.nextInt();
		}

		int lo = 0;
		int hi = Integer.MAX_VALUE;
		int ans = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(cooks, mid, np)) {

				hi = mid - 1;
				ans = mid;

			} else {
				lo = mid + 1;
			}

		}

		System.out.println(ans);

	}

	private static boolean isItPossible(int[] cooks, int mid, int np) {

		for (int i = 0; i < cooks.length; i++) {

			int count = 1;
			int time = 0;

			while (time + count * cooks[i] <= mid && np > 0) {

				time += count * cooks[i];
				np--;
				count++;
			}

			if (np == 0) {
				return true;
			}

		}
		return false;
	}

}
