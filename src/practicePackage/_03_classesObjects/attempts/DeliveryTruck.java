package practicePackage._03_classesObjects.attempts;

import java.security.Identity;
import java.util.Arrays;

public class DeliveryTruck {
	public Box[] boxes;

	public static Box[] deleteIndexInArr(Box[] boxes, int index) {
		Box[] newArr = new Box[boxes.length - 1];
		for (int i = 0, j = 0; i < boxes.length; i++) {
			if (i != index) {
				newArr[j++] = boxes[i];
			}
		}
		return newArr;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * P
	 * 
	 * @return total volume of all the boxes
	 */
	public int totalVolume() {
		int volume = 0;
		for (Box box : boxes) {
			volume += box.volume();
		}
		return volume;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * HD
	 * 
	 * @return the number of boxes that are "identical"
	 *         Please refer to Box class about how to check for identical boxes.
	 * 
	 *         For example, if you have boxes of:
	 *         1 x 3 x 2, 1 x 2 x 3, 2 x 1 x 3, 10 x 10 x 10, 4 x 4 x 5, 2 x 3 x 1
	 *         and 5 x 4 x 4
	 *         all four boxes with one of the sides = 1 are identical
	 *         and both boxes with one of the sides = 5 are identical
	 *         so return 6 (4+2)
	 */

	public int countIdenticalBoxes() {
		int indentical = 0;
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes.length; j++) {
				if (i != j && boxes[i].compareToAdvanced(boxes[j]) == 0) {
					indentical++;
					boxes = deleteIndexInArr(boxes, j);
					break;
				}
			}
		}
		return 2 * indentical;
	}

	/**
	 * Do not modify
	 * 
	 * create an instance copy of array parcels into boxes.
	 * also, each item of boxes should be an instance copy of the corresponding item
	 * in parcels.
	 * 
	 * @param parcels
	 */
	public DeliveryTruck(Box[] parcels) {
		boxes = new Box[parcels.length];
		for (int i = 0; i < parcels.length; i++)
			boxes[i] = new Box(parcels[i]);
	}

	/**
	 * P
	 * 
	 * @param vol
	 * @return true if the truck contains any box with given volume, false otherwise
	 */
	public boolean contains(int vol) {
		for (Box box : boxes) {
			if (box.volume() == vol)
				return true;
		}
		return false;
	}

	/**
	 * Make a copy of the given box and add to the end of the
	 * 
	 * @param b
	 *          append Box b to the end of the array.
	 *          IMPORTANT: the current items should remain unchanged.
	 *          so if boxes[0] refers to instance X before adding b,
	 *          boxes[0] should refer to the same instance X after adding b,
	 *          same for boxes[1], boxes[2] ... boxes[boxes.length-1] (all items
	 *          before adding b)
	 */
	public void add(Box b) {


		Box[] tmp = new Box[boxes.length + 1];

		for (int i = 0; i < boxes.length; i++) {
			tmp[i] = boxes[i];
		}
		Box newB = new Box(b);
		tmp[tmp.length - 1] = newB;
		boxes = tmp;

	}
}