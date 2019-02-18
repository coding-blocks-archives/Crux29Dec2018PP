package L12_Feb16.OOPS_Story1;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2019
 *
 */

public class PersonClient {

	public static void main(String[] args) throws Exception {

		System.out.println("hello");
		Person p = new Person("A", 10);

		try {
			System.out.println("in try");
			p.setAge(-10);
			System.out.println("bye");
		} catch (Exception e) {
			System.out.println("in catch");
		}
		
		System.out.println(p.getAge());

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
