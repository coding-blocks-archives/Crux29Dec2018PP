package L20_March23.FxnGenerics;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Mar-2019
 *
 */

public class CarSpeedComaparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
		return t.speed - o.speed ;
	}

}
