//NAME
//STUDENT ID
//[] I declare that I haven't seen another person's code, and the submission is entirely your work.
//(put an x inside the square brackets to provide declaration)

//Example:
//Gaurav Gupta
//44040404
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.

package pastAssignments.s2_2021.assignment1.basic;
public class OrderingLogic {

	// the board variable needs to be public so that
	// it can be accessed by the JUnit test. Please
	// do not modify its visibility.
	public int[] data;

	/**
	 * instantiate array data to contain required items (See below for details)
	 * populate array data with randomized items between 10 and 90 (inclusive on both sides).
	 * @param size - the number of tiles on the board.
	 * if size is not positive, set it to 1 before proceeding.
	 * if size is more than 15, set it to 15 before proceeding.
	 * each item of the array should be assigned a random integer value between
	 * 1 and 90 (inclusive on both sides)
	 */
	public OrderingLogic(int size) {
		if(size < 1) {
			size = 1;
		}
		if(size > 15) {
			size = 15;
		}
		data = new int[size];
		for(int i = 0; i < size; i++) {
			data[i] = 1 + (int)(90*Math.random());
		}
	}

	/**
	 * 5 marks (Pass level)
	 * 
	 * Check if index i is a valid index, that is, if there
	 * is a tile on that location. Return false if the index
	 * is invalid or if a null value is encountered in that 
	 * index
	 * 
	 * @param i	- the index to check
	 * @return true if index i is a valid location that contains a Tile,
	 * false otherwise
	 */
	public boolean isValidIndex(int i) {
		return i >= 0 && i < data.length;
	}

	/**
	 * Remove the tile at index i moving all subsequent items "to the left".
	 * Do nothing if the index i is invalid
	 * @param idx
	 */
	public void remove(int idx) {
		if(isValidIndex(idx)) {
			int[] temp = new int[data.length - 1];
			for(int i=0; i < data.length; i++) {
				if(i < idx) {
					temp[i] = data[i];
				}
				if(i > idx) {
					temp[i-1] = data[i];
				}
			}
			data = temp;
		}
	}

	/**
	 * 
	 * @return true if the array is sorted in ascending OR descending order
	 */
	public boolean isSorted() {
		return (isAscending() || isDescending());
//		int f = 0;
//		for(int i=0; i < data.length - 1; i++) {
//			if(data[i] > data[i+1]) {
//				if(f == -1) {
//					return false;
//				}
//				f = 1;
//			}
//			if(data[i] < data[i+1]) {
//				if(f == 1) {
//					return false;
//				}
//				f = -1;
//			}
//		}
//		return true;
	}

		private boolean isAscending() {
			for(int i=0; i < data.length-1; i++) {
				if(data[i] > data[i+1]) {
					return false;
				}
			}
			return true;
		}

		private boolean isDescending() {
			for(int i=0; i < data.length-1; i++) {
				if(data[i] < data[i+1]) {
					return false;
				}
			}
			return true;
		}
	}
