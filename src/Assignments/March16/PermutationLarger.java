package Assignments.March16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Mar-2019
 *
 */

public class PermutationLarger {

	public static void main(String[] args) {

		permutation("bac", "", false);
	}

	public static void permutation(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			if (isLarger)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				permutation(roq, ans + ch, true);
			} else {

				if (ch < ques.charAt(0)) {
					// no call
				} else if (ch == ques.charAt(0)) {
					permutation(roq, ans + ch, false);
				} else {
					permutation(roq, ans + ch, true);
				}

			}

		}

	}

}
