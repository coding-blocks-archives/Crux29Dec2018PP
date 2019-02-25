package L14_Feb24.Adapters;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Feb-2019
 *
 */

public class StackUsingQueueClient {

	public static void main(String[] args) throws Exception {

		StackUsingQueuePopEff ds = new StackUsingQueuePopEff();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.push(60);
		ds.push(70);

		System.out.println(ds.pop());

		System.out.println("---");
		ds.display();

	}
}
