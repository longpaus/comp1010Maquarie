package pastAssignments.s2_2021.assignment2.stage_1_fresh_food;

/**
 * 
 * @author gauravgupta
 * the first of the classes to be implemented
 */
public class TrayType {
	public int capacity;
	public static final int MAX_TRAY_CAPACITY = 100;
	
	/**
	 * parameters have been intentionally been given
	 * the same name as parameters.
	 * 
	 * Golden rule is that when a parameter name
	 * is the same as an instance variable name,
	 * say x, 
	 * the parameter is referred to by x
	 * while the instance variable by this.x
	 * 
	 * first "constrain" the parameter in the range
	 * [1...MAX_TRAY_CAPACITY].
	 * "constraining in the range [1...MAX_TRAY_CAPACITY]" means,
	 * if parameter is less than 1, it should become 1
	 * if parameter is more than MAX_TRAY_CAPACITY, it should become MAX_TRAY_CAPACITY
	 * AND THEN, assign the value held by the parameter to the instance variable 
	 * @param capacity
	 */
	public TrayType(int capacity) {
		this.capacity = validate(capacity, 1, MAX_TRAY_CAPACITY);
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
		return capacity+"-fruit tray";
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 * 1 if capacity of calling object is more than capacity of parameter
	 * -1 if capacity of calling object is less than capacity of parameter
	 * 0 if capacity of calling object is equal to capacity of parameter
	 * 
	 */
	public int compareTo(TrayType other) {
		if(this.capacity > other.capacity) {
			return 1;
		}
		if(this.capacity < other.capacity) {
			return -1;
		}
		return 0;
	}
	
	public boolean equalTo(TrayType other) {
		return capacity == other.capacity;
	}
}
