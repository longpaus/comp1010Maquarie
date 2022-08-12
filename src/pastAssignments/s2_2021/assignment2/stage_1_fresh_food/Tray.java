package pastAssignments.s2_2021.assignment2.stage_1_fresh_food;

/**
 * 
 * @author gauravgupta
 * this the second class after TrayType to be completed and requires
 * the constructor of test for TrayType constructor to pass before you can begin it.
 */
public class Tray {
	public TrayType type;
	public int quantity;
	
	/**
	 * 
	 * @param type
	 * @param quantity
	 * assign parameters to corresponding instance variables.
	 * you should make reference copies of objects (not instance copies)
	 * constrain parameter quantity in the range [0...type.capacity]
	 * before copying it into instance variable quantity.
	 * see TrayType constructor javadoc to see the meaning of "constrain".
	 */
	public Tray(TrayType type, int quantity) {
		this.type = type;
		this.quantity = validate(quantity, 0, type.capacity);
	}

	private int validate(int val, int min, int max) {
		if(val < min) {
			val = min;
		}
		if(val > max) {
			val = max;
		}
		return val;
	}
	
	public String toString() {
		return type+" containing "+quantity+" fruits";
	}

	public boolean isFull() {
		return quantity == type.capacity;
	}
	
	public boolean equalTo(Tray other) {
		return type.compareTo(other.type) == 0 && quantity == other.quantity;
	}
}
