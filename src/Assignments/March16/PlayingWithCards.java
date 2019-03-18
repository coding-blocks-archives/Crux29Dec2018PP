package Assignments.March16;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Mar-2019
 *
 */

public class PlayingWithCards {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int q = scn.nextInt();

		ArrayList<Stack<Integer>> A = new ArrayList<>();

		for (int i = 0; i <= q; i++) {
			A.add(new Stack<>());
		}

		ArrayList<Stack<Integer>> B = new ArrayList<>();

		for (int i = 0; i <= q; i++) {
			B.add(new Stack<>());
		}

		for (int i = 0; i < n; i++) {
			A.get(0).push(scn.nextInt());
		}
		
		for(int i = 1 ; i <= q ; i++) {
			
			Stack<Integer> ps = A.get(i-1) ;
			
			while(!ps.isEmpty()) {
				
				int val = ps.pop() ;
				
				if(val % ithPrime(i) == 0) {
					B.get(i).push(val) ;
				}else {
					A.get(i).push(val) ;
				}
				
			}
		}
		
		// print
		for(int i=1 ; i <= q ; i++) {
			
			Stack<Integer> ps = B.get(i) ;
			
			while(!ps.isEmpty()) {
				System.out.println(ps.pop());
			}
		}
		
		while(!A.get(q).isEmpty()) {
			System.out.println(A.get(q).pop());
		}
		

	}

	public static int ithPrime(int i) {

		int count = 0;
		int n = 2;

		while (true) {

			if (isPrime(n)) {
				count++;
			}

			if (count == i) {
				return n;
			}

			n++;

		}

	}

	public static boolean isPrime(int n) {

		for (int div = 2; div <= Math.sqrt(n); div++) {
			if (n % div == 0) {
				return false;
			}
		}

		return true;
	}

}
