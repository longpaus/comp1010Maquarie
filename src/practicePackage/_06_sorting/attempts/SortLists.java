package practicePackage._06_sorting.attempts;

import java.util.ArrayList;

public class SortLists {


	/**
	 * May be helpful for other methods
	 * 
	 *  @param list - a sorted list of unique values in ascending order
	 *  @return the list after the value is inserted. The list should stay 
	 * 			sorted and no duplicates should appear in the list
	 */
	public static ArrayList<Integer> insertUnique(ArrayList<Integer> list, int value) {
		int lo = 0, hi = list.size() - 1;
	    // This below check covers all cases , so need to check
	    // for mid=lo-(hi-lo)/2
	    while (hi - lo > 1) {
	        int mid = (hi + lo) / 2;
	        if (list.get(mid) < value) {
	            lo = mid + 1;
	        }
	        else {
	            hi = mid;
	        }
	    }
	    
		return null; //to be completed
	}

	/**
	 * 
	 * @param data - 2D array where every subarray contains a pair of numbers.
	 * @param n    - The input array only contains the numbers 0 - (n-1).
	 * @return 	A list of size n. Every sublist should contain the sorted numbers
	 * 			that is paired with the index. 
	 * 
	 * For example: 
	 * 
	 * the pair (1, 3) means that 1 should exist in the fourth subarray
	 * and 3 should exist in the second.
	 * 
	 * the pair (2, 0) means that 2 should exist in the first subarray
	 * and 0 should exist in the third.
	 * 
	 * If the pairs were (1, 3), (2, 1), (2, 0)
	 * the returned list should be [[2], [2, 3], [0, 1], [1]]
	 * 
	 */
	public static ArrayList<ArrayList<Integer>> sortInput(int[][] data, int n) {
		return null; //to be completed
	}
}