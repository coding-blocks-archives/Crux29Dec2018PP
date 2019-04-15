package L27_April14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Apr-2019
 *
 */

public abstract class DS {

	public int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public abstract void display();
}
