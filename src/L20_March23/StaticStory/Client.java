package L20_March23.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class Client {

	public static void main(String[] args) {
		Student s = new Student("A");
		// Student s1 = new Student("B") ;
		// s.getRollNo() ;
		Student.getNumberStudents();
		System.out.println(s.numOfStudents);

		System.out.println(Math.pow(2, 3));

	}
}
