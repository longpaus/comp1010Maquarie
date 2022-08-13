package practicePackage._02_arrays.attempts;


import java.util.*;
import java.util.Hashtable;

public class Stage4 {

	/**
	 * 
	 * @param a
	 * @param b
	 * @return number of items that belong to both a and b
	 *         {30,10,30,30,10,20,40}, {60,10,10,10,10,30,50} should return 3
	 *         since both arrays contain two 10s and one 30.
	 *         return 0 if either array is null
	 */

	public static int[] deleteIndexInArr(int[] array, int index) {
		int[] copy = new int[array.length - 1];

		for (int i = 0, j = 0; i < array.length; i++) {
			if (i != index) {
				copy[j++] = array[i];
			}
		}
		return copy;
	}

	public static int intersection(int[] a, int[] b) {
		if (a == null || b == null) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					result++;
					b = deleteIndexInArr(b, j);
					break;
				}
			}
		}
		return result; // to be completed
	}

	/**
	 * 
	 * @param data
	 * @return the longest sequence in ascending order.
	 *         return the sequence that occurs first in case of a tie.
	 *         for example,
	 *         if data = {10, 70, 20, 50, 50, 80}, return {20, 50, 50, 80}
	 *         if data = {70, 70, 20, 10, 80, 20}, return {70, 70}
	 *         if data = {50, 40, 30, 30}, return {30, 30}
	 *         if data = null, return null
	 *         if data = {}, return {}
	 */
	
	public static int[] addElementToArr(int[] arr,int element) {
		int [] newArr = new int[arr.length + 1];
		for(int i = 0; i < newArr.length; i++){
			if(i == newArr.length - 1){
				newArr[i] = element;
			}else{
				newArr[i] = arr[i];
			}
		}
		return newArr;
	}

	public static int[] getLongestAscendingSequence(int[] data) {
		if(data == null) {
			return null;
		}
		if(data.length == 0) {
			return new int[0];
		}
		int [] sequence = new int[0];
		 HashMap map = new HashMap();
		int longest = 0;
		for(int num : data){
			if(sequence.length == 0 || sequence[sequence.length - 1] <= num){
				sequence = addElementToArr(sequence, num);
			}
			else if(sequence[sequence.length - 1] > num){
				if(!map.containsKey(sequence.length)){
					map.put(sequence.length,sequence);
				}
				if(sequence.length > longest){
					longest = sequence.length;
				}
				sequence = new int[0];
				sequence = addElementToArr(sequence, num);
			}
		}
		if(!map.containsKey(sequence.length)){
			map.put(sequence.length,sequence);
		}
		return (int[])map.get(longest);
	}

	/**
	 * 
	 * @param data
	 * @return the longest sequence of the same item.
	 *         return the sequence that occurs first in case of a tie.
	 *         for example,
	 *         if data = {10, 30, 30, 30, 30, 50, 50, 80}, return {30, 30, 30, 30}
	 *         if data = {70, 70, 90, 90, 80, 80}, return {70, 70}
	 *         if data = {50, 40, 30, 20}, return {50}
	 *         if data = null, return null
	 *         if data = {}, return {}
	 */
	public static int[] getLongestUnchangedSequence(int[] data) {
		return new int[0]; // to be completed
	}

	/**
	 * 
	 * @param data
	 *             sort the array in descending order,
	 *             do nothing if the array is null or has fewer than 2 items
	 */
	public static void sortDesc(int[] data) {
		if (data == null || data.length < 2) {
			return;
		}
		for (int i = 0; i + 1 < data.length; i++) {
			if (data[i] < data[i + 1]) {
				int tmp = data[i];
				data[i] = data[i + 1];
				data[i + 1] = tmp;
				i = -1;
			}
		}
	}

	/**
	 * 
	 * @param data
	 * @param asc
	 *             if the array is already sorted (either ascending or descending),
	 *             do nothing regardless of asc,
	 *             otherwise sort the array in ascending order if asc is true,
	 *             otherwise sort the array in descending order
	 */
	public static boolean checkIfSorted(int[] data, boolean ascending) {
		for (int i = 0; i + 1 < data.length; i++) {
			if (ascending && data[i] > data[i + 1]) {
				return false;
			}
			if (!ascending && data[i] < data[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void sortIfNeeded(int[] data, boolean asc) {
		if(data == null || data.length == 0) {
			return;
		}
		boolean ascending = (data[0] < data[data.length - 1]) ? true : false;
		if(checkIfSorted(data, ascending)){
			return;
		}
		if(asc){
			for (int i = 0; i + 1 < data.length; i++) {
				if (data[i] > data[i + 1]) {
					int tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
					i = -1;
				}
			}
		}
		else{
			sortDesc(data);
		}
	}

	/**
	 * 
	 * @param a: sorted in ascending order
	 * @param b: sorted in ascending order
	 * @return an array containing the common items from a and b.
	 *         If array a contains p occurrences of an item and array b contains q
	 *         occurrences of the same item,
	 *         the array returned must have Math.min(p, q) occurrences of that item.
	 */
	public static int[] getCommonItemsSorted(int[] a, int[] b) {
		int numCommonItems = intersection(a,b);
		int [] commonItems = new int[numCommonItems];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					commonItems[index] = a[i];
					index++;
					b = deleteIndexInArr(b, j);
					break;
				}
			}
		}
		return commonItems; // to be completed
	}

	/**
	 * 
	 * @param data
	 * @return true if there are no common items between any two subarrays of the
	 *         array passed, false otherwise.
	 */
	public static boolean noCommonItems(int[][] data) {
		for(int row1 = 0; row1 < data.length; row1++){
			for(int row2 = 0; row2 < data.length; row2++){
				if(row1 != row2){
					int[] a = data[row1];
					int[] b = data[row2];
					if(intersection(a, b) != 0){
						return false;
					}
				}
			}
		}
		return true; // to be completed
	}

	/**
	 * in math, a "set" is defined as a collection of **distinct** items.
	 * Thus, {1,7,2,9} is a set, but {1,7,2,1,9} is not (since 1 occurs multiple
	 * times).
	 * 
	 * @param data
	 * @return a "set" obtained from the passed array. the order of the items should
	 *         be
	 *         the order in of the first occurrences of the items in the passed
	 *         array.
	 *         for example,
	 *         if data = {1,7,2,1,9,7,9,9}, return {1,7,2,9}
	 *         if data = {7,2,1,1,9,7,9,9}, return {7,2,1,9}
	 */
	public static boolean isElementInArr(int[] data,int element){
		for(int num : data){
			if(num == element){
				return true;
			}
		}
		return false;
	}
	public static int[] getSet(int[] data) {
		if(data == null) {
			return null;
		}
		int[] numbers = new int[0];
		for(int num : data){
			if(!isElementInArr(numbers, num)){
				numbers = addElementToArr(numbers, num);
			}
		}
		return numbers; // to be completed
	}

	/**
	 * 
	 * say, there are n players that enter a tournament.
	 * assume n is a power of 2 (so 1, 2, 4, 8, 16...)
	 * the tournament has knock-out format.
	 * 
	 * so if 8 players enter:
	 * 
	 * round 1: p1 vs p2, p3 vs p4, p5 vs p6, p7 vs p8
	 * round 2 (as an example): p2 vs p3, p5 vs p8
	 * round 3 (as an example): p3 vs p8
	 * winner p3
	 * 
	 * now, i keep the information in an array. 0 represents loss, 1 represents win
	 * 
	 * the above scenario is represented in the following array.
	 * i have spaced it out based on rounds.
	 * 
	 * {0,1,1,0,0,1,0,1, 0,1,0,1, 1,0}
	 * 
	 * Your job is that given a valid array, determine which player won (in this
	 * case: 3)
	 * 
	 * Some more examples (pretty trivial, for 16 players this time):
	 * 
	 * {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0, 1,0,1,0,1,0,1,0, 1,0,1,0, 1,0}
	 * winner would be player 1
	 * 
	 * {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1, 0,1,0,1,0,1,0,1 0,1,0,1, 0,1}
	 * winner would be player 16
	 * 
	 * @param results
	 *                assume in valid format. that is, exactly one of results[2*i],
	 *                results[2*i+1] for all i, is 1
	 *                also assume that results.length = 2*n-2 where n represents
	 *                number of players. You may assume that n is a power of 2.
	 * @return player number who won the tournament (return 1 for the first player,
	 *         2 for the second player, and so on)
	 * 
	 *         CHALLENGE: Time complexity should be O(log n)
	 */
	public static int winner(int[] results) {
		return 0;
	}
}