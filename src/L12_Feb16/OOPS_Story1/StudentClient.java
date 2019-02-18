package L12_Feb16.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Feb-2019
 *
 */

public class StudentClient {

	public static void main(String[] args) {

		// Student s = new Student();
		//
		// // get
		// System.out.println(s.name);
		// System.out.println(s.age);
		//
		// // set
		// s.age = 10;
		// s.name = "Ram";
		//
		// System.out.println(s.name);
		// System.out.println(s.age);
		//
		// Student s1 = s;
		// System.out.println(s1.name);
		// s1.name = "Rohit";
		//
		// System.out.println(s.name);
		// System.out.println(s1.name);
		//
		// s1 = new Student();
		//
		// Student s3 = new Student();
		// s3.age = 10;
		// s3.name = "A";
		//
		// Student s4 = new Student();
		// s4.age = 20;
		// s4.name = "B";
		//
		// // Test1(s3, s4);
		// System.out.println(s3.age + " " + s3.name);
		// System.out.println(s4.age + " " + s4.name);
		//
		// // Test2(s3, s4);
		// System.out.println(s3.age + " " + s3.name);
		// System.out.println(s4.age + " " + s4.name);
		//
		// int myAge = 30;
		// String myName = "C";
		//
		// // Test3(s3, s4.age, s4.name, myAge, myName);
		// System.out.println(s3.age + " " + s3.name);
		// System.out.println(s4.age + " " + s4.name);
		// System.out.println(myAge + " " + myName);
		//
		// s1.name = "Rohit";
		// s1.age = 20;
		//
		// s1.introduceYourself();
		// s1.sayHi("Ram");
		//
		// Student s2 = new Student();
		// s2.name = "ABC";
		// s2.age = 70;
		// s2.introduceYourself();

		Student s10 = new Student("A", 20);

		System.out.println(s10.name);
		System.out.println(s10.age);
		
		Student s11 = new Student() ;
		s11.age = -10 ;
		
		
	}

	public static void Test3(Student s, int age, String name, int myAge, String myName) {
		s.age = 0;
		s.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}

	public static void Test2(Student s1, Student s2) {

		s2 = new Student();
		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		s1 = new Student();
		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
	}

	public static void Test1(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}

}
