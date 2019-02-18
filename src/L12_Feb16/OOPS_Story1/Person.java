package L12_Feb16.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2019
 *
 */

public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Invalid Age.");
		}

		this.age = age;
	}

}





