package practicePackage._05_arrayList.attempts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import serviceClasses.MathService;
import serviceClasses.Rectangle;

@SuppressWarnings("unused")
public class Stage3 {

	/**
	 * 
	 * @param list
	 * @param target
	 * @return the SECOND-LAST index at which target exists in the list passed.
	 *         return -1 if list is null or target doesn't exist TWICE in the list.
	 */
	public static int secondLastIndexOf(ArrayList<Integer> list, int target) {
		if (list == null) {
			return -1;
		}
		ArrayList<Integer> targetIdx = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == target) {
				targetIdx.add(i);
			}
		}
		return (targetIdx.size() >= 2) ? targetIdx.get(targetIdx.size() - 2) : -1;
	}

	/**
	 * Remove all negative items from the list
	 * 
	 * @param list
	 * 
	 *             For example,
	 * 
	 *             if list = [2, 4, 0, -1, -2, -3, 0, 4, -8, 3, 0, -1, -1],
	 *             it should become [2, 4, 0, 0, 4, 3, 0]
	 * 
	 *             TIP: use remove method and use the debugger to ensure that the
	 *             right item is being removed
	 */
	public static void removeNegatives(ArrayList<Integer> list) {
		ArrayList<Integer> positiveIdx = new ArrayList<>();
		list.clear();
	}

	/**
	 * 
	 * @param list
	 * @return true if the list contains three instances of target in a row, false
	 *         otherwise.
	 *         return false if list is null or if it contains less than 3 items
	 */
	public static boolean threeInARow(ArrayList<Integer> list, int target) {
		if (list == null || list.size() < 3) {
			return false;
		}
		for (int i = 0; i + 2 < list.size(); i++) {
			if (list.get(i) == list.get(i + 1) && list.get(i) == list.get(i + 2) && list.get(i) == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param list
	 * @return true if every item in the list occurs only once, false otherwise.
	 *         return true if list is empty, false if the list is null
	 * 
	 *         TIP: use of methods indexOf and lastIndexOf will make your life
	 *         oh-so-easy
	 */
	public static boolean allUnique(ArrayList<Integer> list) {
		if (list == null) {
			return false;
		}
		if (list.isEmpty()) {
			return true;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i != list.lastIndexOf(list.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param n
	 * @param init
	 * @param inc
	 * @return an list containing n items such that the first item is init,
	 *         and each item is inc more than the previous item.
	 *         return null if n is less than 0
	 * 
	 *         NOTE 1: take special care when n = 0, the method should return the
	 *         list {}
	 *         NOTE 2: inc can be negative too :)
	 */
	public static ArrayList<Integer> generatePatternedArray(int n, int init, int inc) {
		if (n < 0) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(init);
			init += inc;
		}
		return list;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if a and b have the same items in the same order,
	 *         false otherwise
	 *         return false if either of list passed is null
	 */
	public static boolean identical(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (b == null || a == null) {
			return false;
		}
		if (a.size() != b.size()) {
			return false;
		}
		for (int i = 0; i < b.size(); i++) {
			if (a.get(i) != b.get(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if a and b have the same items but not necessarily in the same
	 *         order,
	 *         false otherwise
	 *         return false if either of list passed is null
	 */
	public static boolean same(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null || b == null) {
			return false;
		}
		Collections.sort(a);
		Collections.sort(b);
		return identical(a, b) ? true : false;
	}

	/**
	 * 
	 * @param n
	 * @return an list containing items {1, 2, ..., n-1, n}
	 *         return null if n is less than 0
	 */
	public static ArrayList<Integer> generate(int n) {

		return null; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return an list containing the numbers of occurrences of all distinct items
	 *         in list
	 *         return null if the list is null.
	 */
	public static ArrayList<ArrayList<Integer>> getFrequencyTable(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : list) {
			map.computeIfPresent(num, (k, v) -> v + 1);
			map.computeIfAbsent(num, k -> 1);
		}
		ArrayList<ArrayList<Integer>> freqTable = new ArrayList<>();
		for (int num : list) {
			if (!isNumInFreqTable(freqTable, num)) {
				ArrayList<Integer> numInfo = new ArrayList<>();
				numInfo.add(num);
				numInfo.add(map.get(num));
				freqTable.add(numInfo);
			}
		}

		return freqTable;
	}

	private static boolean isNumInFreqTable(ArrayList<ArrayList<Integer>> freqTable, int num) {
		for (ArrayList<Integer> numInfo : freqTable) {
			if (num == numInfo.get(0)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param list
	 * @return the item that appears most in the list,
	 *         or the first item that does so in case of a tie
	 *         You may assume that list passed is NOT null
	 */
	public static int getMostFrequentItem(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> freqTable = getFrequencyTable(list);
		int mostRepeated = 0;
		int item = 0;
		for (ArrayList<Integer> numInfo : freqTable) {
			if (numInfo.get(1) > mostRepeated) {
				mostRepeated = numInfo.get(1);
				item = numInfo.get(0);
			}
		}
		return item;
	}

	/**
	 * 
	 * @param list
	 * @param end
	 * @return a sublist of list from the start of the list to index end
	 *         (inclusive),
	 *         return null if list is null or empty or end is invalid
	 */
	public static ArrayList<Integer> sublistUptoIndex(ArrayList<Integer> list, int end) {
		if (list == null || list.isEmpty() || end < 0 || end > list.size() - 1) {
			return null;
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i <= end; i++) {
			ans.add(list.get(i));
		}
		return ans;
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all negative items of list,
	 *         return null if list passed is null,
	 *         return an empty list if list passed is empty
	 */
	public static ArrayList<Integer> getNegatives(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Integer> negative = new ArrayList<>();
		for (int num : list) {
			if (num < 0) {
				negative.add(num);
			}
		}
		return negative;
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all items of list that are prime numbers,
	 *         return null if list passed is null,
	 *         return an empty list if list passed is empty
	 * 
	 *         TIP: Use isPrime from MathService class as:
	 *         MathService.isPrime(number to check)
	 */
	public static ArrayList<Integer> getPrimes(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Integer> prime = new ArrayList<>();
		for (int num : list) {
			if (MathService.isPrime(num)) {
				prime.add(num);
			}
		}
		return prime;
	}

	/**
	 * 
	 * @param list
	 * @return an list containing all non-positive items of list,
	 *         return null if list passed is null,
	 *         return an empty list if list passed is empty
	 */
	public static ArrayList<Integer> getWithoutPositives(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Integer> noPositive = new ArrayList<>();
		for (int num : list) {
			if (num <= 0) {
				noPositive.add(num);
			}
		}
		return noPositive;
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return a copy of the list passed as parameter (not the same reference),
	 *         return null if list passed is null,
	 *         return an empty list if list passed is empty
	 * 
	 *         TIP: use method getCopy from Stage2
	 */
	public static ArrayList<ArrayList<Integer>> getCopy(ArrayList<ArrayList<Integer>> list) {
		if (list == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> cpy = new ArrayList<>();
		for (ArrayList<Integer> subList : list) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int num : subList) {
				tmp.add(num);
			}
			cpy.add(tmp);
		}
		return cpy;
	}

	/**
	 * 
	 * @param list
	 * @param sub
	 * @return the last index at which sub starts in list
	 *         return -1 if sub has a higher length than list or there is no such
	 *         sub found in list
	 */
	public static int lastIndexOf(ArrayList<Integer> list, ArrayList<Integer> sub) {
		if (sub.size() > list.size()) {
			return -1;
		}
		int lastIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.size() - i < sub.size())
				break;
			int currSequenceLen = 0;
			for (int j = i, k = 0; k < sub.size(); k++) {
				if (list.get(j++) == sub.get(k))
					currSequenceLen++;
			}
			if (currSequenceLen == sub.size())
				lastIndex = i;

		}
		return lastIndex;
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of even items in non-null sublists of list,
	 *         return 0 if list is null or empty
	 */
	public static int totalNumberOfEvenItems(ArrayList<ArrayList<Integer>> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int total = 0;
		for (ArrayList<Integer> subList : list) {
			if (subList != null) {
				for (int num : subList) {
					if (num % 2 == 0) {
						total++;
					}
				}
			}
		}
		return total;
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of positive items in non-null sublists of list,
	 *         return 0 if list is null or empty
	 */
	public static int totalNumberOfPositiveItems(ArrayList<ArrayList<Integer>> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int total = 0;
		for (ArrayList<Integer> subList : list) {
			if (subList != null) {
				for (int num : subList) {
					if (num > 0) {
						total++;
					}
				}
			}
		}
		return total;
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the total number of unique items (items existing only once) within a
	 *         non-null sublist of list,
	 *         return 0 if list is null or empty
	 */
	public static int totalNumberOfUniqueItems(ArrayList<ArrayList<Integer>> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int totalUnique = 0;
		for (ArrayList<Integer> subList : list) {
			if (subList != null) {
				ArrayList<ArrayList<Integer>> freqTable = getFrequencyTable(subList);
				for (ArrayList<Integer> numInfo : freqTable) {
					if (numInfo.get(1) == 1)
						totalUnique++;
				}
			}
		}
		return totalUnique;
	}

	/**
	 * 
	 * @param list: a list of lists
	 * @return the number of non-null sublists in list,
	 *         return 0 if list is null or empty
	 */
	public static int countNonNullSublists(ArrayList<ArrayList<Integer>> list) {
		if(list==null||list.isEmpty()){
			return 0;
		}
		int count=0;
		for(ArrayList<Integer>subList:list){
			if(subList!=null){
				count++;
			}
		}
		return count; 
	}
}