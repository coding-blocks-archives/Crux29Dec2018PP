package L13_Feb17.OOPS_Story2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Feb-2019
 *
 */

public class C extends P{

	int d = 20 ;
	int d2 = 200;
	
	public void fun() {
		System.out.println("In C Fun");
	}
	
	public void fun2() {
		System.out.println("In C Fun2");
	}
	
	@Override
	public String toString() {
		return "C Class to String " + d + " " + d2 ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
