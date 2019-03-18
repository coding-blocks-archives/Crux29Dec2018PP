package Assignments.March16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Mar-2019
 *
 */

public class HoodiesCodingBlocks {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int q = scn.nextInt();

		ArrayList<Queue<Integer>> C = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			C.add(new LinkedList<>());
		}

		ArrayList<Integer> order = new ArrayList<>();

		for (int i = 0; i < q; i++) {

			char op = scn.next().charAt(0);

			if (op == 'E') {

				int cno = scn.nextInt();
				int rno = scn.nextInt();

				C.get(cno).add(rno);

				if (!order.contains(cno))
					order.add(cno);

			} else {

				int removedCourseNo = order.get(0) ;
				int removedRollNo = C.get(removedCourseNo).remove() ;
				
				if(C.get(removedCourseNo).isEmpty()) {
					order.remove(0) ;
				}
				
				System.out.println(removedCourseNo + " " + removedRollNo );
				
				
			}

		}

	}
}
