package pastAssignments.s2_2021.assignment2.stage_1_fresh_food;

/**
 * 
 * @author gauravgupta
 * this is the third class to complete, after TrayType and Tray
 */
public class Carton {
	public Tray[] trays;
	public String name;

	/**
	 * 
	 * @param name
	 * @param trays
	 * copy the parameters into the instance variables (reference copy, not instance copy).
	 * IMPORTANT: 
	 * if parameter for name is null, set the instance variable name to "-"
	 * if parameter for trays is null, se the instance variable to an empty array (not null) 
	 */
	public Carton(String name, Tray[] trays) {
		if(name == null) {
			this.name = "-";
		}
		else {
			this.name = name;
		}
		if(trays == null) {
			this.trays = new Tray[] {};
		}
		else {
			this.trays = trays;
		}
	}

	/**
	 * 
	 * @return the number of trays that are full.
	 */
	public int countFullTrays() {
		int r = 0;
		for(Tray t: trays) {
			if(t==null) {
				continue;
			}
			if(t.isFull()) { 
				r++;
			}
		}
		return r;
	}

	/**
	 * 
	 * @return true if all trays are full, false otherwise
	 */
	public boolean allTraysFull() {
		for(Tray t: trays) {
			if(t==null) {
				continue;
			}
			if(!t.isFull()) { 
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @return an array containing the indices, in ascending order, 
	 * of trays that are full
	 */
	public int[] getIndicesOfFullTrays() {
		int[] result = new int[countFullTrays()];
		int idx = 0;
		for(int i=0; i < trays.length; i++) {
			if(trays[i]==null) {
				continue;
			}
			if(trays[i].isFull()) {
				result[idx++] = i;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param other
	 * @return true if the calling object is identical to the parameter objects, false otherwise.
	 * that is they both have the same trays (albeit instance copies) in the same order.
	 */
	public boolean identical(Carton other) {
		if(other == null) {
			return false;
		}
		if(trays.length != other.trays.length) {
			return false;
		}
		for(int i=0; i < trays.length; i++) {
			if(trays[i]==null && other.trays[i]==null) {
				continue;
			}
			if(trays[i]==null || other.trays[i]==null) {
				return false;
			}
			if(!trays[i].equalTo(other.trays[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param other
	 * @return true if the calling object and the parameter objects have the same trays,
	 * even though in different order, false otherwise
	 */
	public boolean sameButRearranged(Carton other) {
		if(other == null) {
			return false;
		}
		if(trays.length != other.trays.length) {
			return false;
		}
		
		int null1=0, null2=0;
		
		for(int i=0; i < trays.length; i++) {
			if(other.trays[i]==null) {
				null2++;
			}
			
			if(trays[i]==null) {
				null1++;
				continue;
			}
			int c1 = countOccurrences(trays[i]);
			int c2 = other.countOccurrences(trays[i]);
			if(c1 != c2) {
				return false;
			}
		}
		
		return null1 == null2;
	}

	//assume tray != null
	private int countOccurrences(Tray tray) {
		int c = 0;
		for(Tray current: trays) {
			if(current==null) {
				continue;
			}
			if(current.equalTo(tray)) {
				c++;
			}
		}
		return c;
	}

	public String toString() {
		String result = name+":\n";
		for(Tray t: trays) {
			result = result + t + "\n";
		}
		return result;
	}
}
