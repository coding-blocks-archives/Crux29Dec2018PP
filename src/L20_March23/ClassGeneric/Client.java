package L20_March23.ClassGeneric;

import java.util.ArrayList;

import L20_March23.FxnGenerics.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		// Pair<String> pair = new Pair<>() ;
		Pair<Pair<String, Integer>, Character> pair = new Pair<>();

		pair.a = new Pair<>();

		pair.a.a = new String("hello");
		pair.a.b = 10;
		pair.b = 'a';
		
		System.out.println(pair.a);
		System.out.println(pair.a.a);
		System.out.println(pair.a.b);
		System.out.println(pair.b);

		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
		list.add(new ArrayList<>()) ;
		list.get(0).add(10) ;
		list.get(0).add(20) ;
		list.get(0).add(30) ;
		list.add(new ArrayList<>()) ;
		list.get(1).add(40) ;
		list.get(1).add(50) ;
		list.get(1).add(60) ;
		System.out.println(list.get(0)) ;
		System.out.println(list);
		
		Car[] cars = new Car[5];
		cars[0] = new Car(10, 200, "Black");
		cars[1] = new Car(20, 100, "White");
		cars[2] = new Car(3, 50, "Grey");
		cars[3] = new Car(4, 278, "Yellow");
		cars[4] = new Car(34, 2900, "Red");
		
		LinkedListGeneric<Car> ll = new LinkedListGeneric<>() ;
		
		ll.addLast(cars[0]);
		ll.addLast(cars[1]);
		ll.addFirst(cars[2]);
		ll.addLast(cars[3]);
		ll.addLast(cars[4]);
		
		ll.display();
		
		
		
		
		
		
		
		
		

	}
}
