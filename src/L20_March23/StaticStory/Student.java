package L20_March23.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class Student {

	String name;
	int age;
	final int rollNo;
	static int numOfStudents;

	public Student(String name) {
		numOfStudents++;
		this.rollNo = numOfStudents;
		this.name = name;
	}

	// non static function, non static data member ? Yes
	// non static function, static data member ? Yes
	public int getRollNo() {
		// this.rollNo = 100 ;
		return numOfStudents;
		// return this.rollNo ;
	}

	// static this use ? No
	// static function non static data members ? No
	// static function static data member ? Yes
	public static int getNumberStudents() {
		return numOfStudents;
	}

}
