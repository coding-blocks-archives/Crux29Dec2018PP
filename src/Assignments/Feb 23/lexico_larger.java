package doubt_class;

public class lexico_larger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		permt_Eff("bca", "", false);

	}

	public static void permt(String ques, String ans, String orig) {

		if (ques.length() == 0) {

			if (ans.compareTo(orig) > 0) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);

			permt(ros, ans + ch, orig);
		}

	}

	public static void permt_Eff(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {

			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			String ros = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				permt_Eff(ros, ans + ch, true);
			} else {

				if (ch > ques.charAt(0)) {
					permt_Eff(ros, ans + ch, true);
				} else if (ch == ques.charAt(0)) {
					permt_Eff(ros, ans + ch, false);
				}
			}

		}

	}

}
