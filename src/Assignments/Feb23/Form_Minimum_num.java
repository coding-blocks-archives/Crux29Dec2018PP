package Assignments.Feb23 ;

public class Form_Minimum_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Inc_Dec_sequence("IIIDDID"));

	}

	public static String Inc_Dec_sequence(String str) {

		if (str.length() > 9) {
			return "-1";
		}

		int count = 1;
		char[] result = new char[str.length() + 1];

		for (int i = 0; i <= str.length(); i++) {

			if (i == str.length() || str.charAt(i) == 'I') {

				for (int j = i - 1; j >= -1; j--) {
					result[j + 1] = (char) ('0' + count++);

					if (j >= 0 && str.charAt(j) == 'I') {
						break;
					}
				}
			}
		}

		return new String(result);
	}

}
