package doubt_class;

import java.util.ArrayList;

public class CodesOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "1125";
		System.out.println(codes(str));

//		System.out.println();

	}

	public static ArrayList<String> codes(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		String ch1 = str.substring(0, 1);

		int val1 = Integer.valueOf(ch1);
		char temp = (char) (val1 + 'a' - 1);
		String ros1 = str.substring(1);

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr1 = codes(ros1);

		for (String val : rr1) {

			mr.add(temp + val);
		}

		if (str.length() >= 2) {

			String ch2 = str.substring(0, 2);
			int val2 = Integer.valueOf(ch2);

			if (val2 <= 26) {
				char temp2 = (char) (val2 + 'a' - 1);

				String ros2 = str.substring(2);

				ArrayList<String> rr2 = codes(ros2);

				for (String val : rr2) {

					mr.add(temp2 + val);
				}
			}
		}

		return mr;

	}

}
