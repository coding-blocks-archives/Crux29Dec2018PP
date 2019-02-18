package L12_Feb16.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2019
 *
 */

public class Student {

	String name = "P";
	int age = 80;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student() {
		age = 10;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);

	}

}
