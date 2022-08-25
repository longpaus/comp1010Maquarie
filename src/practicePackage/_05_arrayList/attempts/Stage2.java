package practicePackage._05_arrayList.attempts;

import java.util.ArrayList;

import serviceClasses.*;

public class Stage2 {

	/**
	 * 
	 * @param list
	 * @return the sum of all negatives items of the list
	 *         return 0 if list is null or empty
	 */
	public static int sumNegatives(ArrayList<Integer> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int sum = 0;
		for (int num : list) {
			if (num < 0) {
				sum += num;
			}
		}
		return sum; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return the number of times target exists in the list
	 *         return 0 if list is null or empty
	 */
	public static int count(ArrayList<Integer> list, int target) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int result = 0;
		for (int num : list) {
			if (num == target) {
				result++;
			}
		}
		return result; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high (assume low is less than or equal to high)
	 * @return true if there is at least one item in the list that is in the range
	 *         [low ... high]
	 *         return false if list is null or empty
	 */
	public static boolean containsInRange(ArrayList<Integer> list, int low, int high) {
		if (list == null || list.isEmpty()) {
			return false;
		}
		for (int num : list) {
			if (num >= low && low <= high) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param list
	 * @return the number of prime numbers in the list
	 *         return 0 if list is null or empty
	 * 
	 *         IMPORTANT: you can (and should) use the helper
	 *         method isPrime(int) from class MathService as
	 *         MathService.isPrime(value_to_check)
	 */
	public static int countPrimes(ArrayList<Integer> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int numPrime = 0;
		for (int num : list) {
			if (MathService.isPrime(num)) {
				numPrime++;
			}
		}
		return numPrime; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all the items in the list are prime numbers, false otherwise
	 *         return false if list is null
	 *         return true if the list is empty (because technically, every item in
	 *         the list IS prime)
	 * 
	 *         IMPORTANT: you can (and should) use the helper
	 *         method isPrime(int) from class MathService as
	 *         MathService.isPrime(value_to_check)
	 */
	public static boolean allPrimes(ArrayList<Integer> list) {
		if (list == null) {
			return false;
		}
		for (int num : list) {
			if (!MathService.isPrime(num)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * change each item of the list to its square.
	 * 
	 * if list is null or empty, do nothing
	 * 
	 * TIP: use set and get methods.
	 * 
	 * @param list
	 * 
	 *             For example,
	 * 
	 *             if list = [3,0,-2,6], it should become [9, 0, 4, 36]
	 */
	public static void squareUp(ArrayList<Integer> list) {
		if (list == null) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) * list.get(i));
		}
	}

	/**
	 * 
	 * @param list
	 * @return the sum of all odd items of the list passed.
	 *         return 0 if the list is null
	 */
	public static int sumOdd(ArrayList<Integer> list) {
		if (list == null) {
			return 0;
		}
		int sum = 0;
		for (int num : list) {
			if (num % 2 != 0) {
				sum += num;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the sum of all items of the list passed that are multiples of n.
	 *         return 0 if the list is null
	 */
	public static int sumMultiples(ArrayList<Integer> list, int n) {
		if (list == null) {
			return 0;
		}
		int sum = 0;
		for (int num : list) {
			if (num % n == 0) {
				sum += num;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return sum of all items of the list passed that lie in the number range
	 *         [low...high]
	 */
	public static int sumInRange(ArrayList<Integer> list, int low, int high) {
		int sum = 0;
		for (int num : list) {
			if (num >= low && num <= high) {
				sum += num;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 * @return the sum of all items at even indices of the list passed
	 */
	public static int sumEvenIndexedItems(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				sum += list.get(i);
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 *             reset any negative value(s) in the list passed to zero.
	 */
	public static void resetNegatives(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 0) {
				list.set(i, -1 * list.get(i));
			}
		}
	}

	/**
	 * 
	 * @param list
	 * @return the number of odd numbers in the list passed.
	 *         return 0 if the list is null.
	 */
	public static int countOdd(ArrayList<Integer> list) {
		if (list == null) {
			return 0;
		}
		int numOdd = 0;
		for (int num : list) {
			if (num % 2 != 0) {
				numOdd++;
			}
		}
		return numOdd;
	}

	/**
	 * 
	 * @param list
	 * @return the number of negative (less than 0) numbers in the list passed.
	 *         return 0 if the list is null.
	 */
	public static int countNegatives(ArrayList<Integer> list) {
		if (list == null) {
			return 0;
		}
		int numNegative = 0;
		for (int num : list) {
			if (num < 0) {
				numNegative++;
			}
		}
		return numNegative;
	}

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the number of items in the list passed of which n is a multiple.
	 *         return 0 if the list is null.
	 */
	public static int countFactors(ArrayList<Integer> list, int n) {
		if (list == null) {
			return 0;
		}
		int numItems = 0;
		for (int num : list) {
			if (num % n == 0) {
				numItems++;
			}
		}
		return numItems;
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return number of times target exists in the list passed.
	 *         return 0 if list is null.
	 */
	public static int countOccurrences(ArrayList<Integer> list, int target) {
		if (list == null) {
			return 0;
		}
		int result = 0;
		for (int num : list) {
			if (num == target) {
				result++;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @param startIndex
	 * @return true if target exists at index startIndex or later in the list
	 *         passed, false otherwise.
	 *         return false if list is null or target doesn't exist in the list
	 *         starting at index startIndex.
	 */
	public static boolean containsFromIndex(ArrayList<Integer> list, int target, int startIndex) {
		if (list == null) {
			return false;
		}
		for (int i = startIndex; i < list.size(); i++) {
			if (list.get(i) == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @param startIndex
	 * @param endIndex
	 * @return true if target exists in the index range [startIndex...endIndex] at
	 *         which target exists in the list passed, false otherwise.
	 *         return false if list is null or target doesn't exist in the list in
	 *         the index range [startIndex...endIndex].
	 * 
	 */
	public static boolean containsBetweenIndices(ArrayList<Integer> list, int target, int startIndex, int endIndex) {
		if (list == null) {
			return false;
		}
		for (int i = startIndex; i <= endIndex; i++) {
			if (list.get(i) == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param list
	 * @param endIndex
	 * @return sum of all items at index endIndex or lower in the list passed.
	 *         return 0 if list is null.
	 */
	public static int sumUptoIndex(ArrayList<Integer> list, int endIndex) {
		if (list == null) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i <= endIndex; i++) {
			sum += list.get(i);
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @return sum of all even numbers at index startIndex or later.
	 *         return 0 if list is null.
	 */
	public static int sumEvenFromIndex(ArrayList<Integer> list, int startIndex) {
		if (list == null) {
			return 0;
		}
		int sum = 0;
		for (int i = startIndex; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				sum += list.get(i);
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param list
	 * @param endIndex
	 * @return product of all positive items up to index endIndex.
	 *         return 1 if list is null or if no positive items exist up to index
	 *         endIndex.
	 */
	public static int productPositivesUptoIndex(ArrayList<Integer> list, int endIndex) {
		if (list == null) {
			return 1;
		}
		int product = 1;
		for (int i = 0; i <= endIndex; i++) {
			if (list.get(i) > 0) {
				product *= list.get(i);
			}
		}
		return product;
	}

	/**
	 * 
	 * @param list
	 * @param key
	 * @param startIndex
	 * @param endIndex
	 * @return number of times key exists in the list between the indices startIndex
	 *         and endIndex.
	 *         return 0 if list is null or if key doesn't exist between indices
	 *         startIndex and endIndex.
	 */
	public static int countOccurrencesBetweenIndices(ArrayList<Integer> list, int key, int startIndex, int endIndex) {
		return 0; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are positive (more than 0), false
	 *         otherwise.
	 *         return false if the list is null.
	 */
	public static boolean allPositives(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are zero, false otherwise.
	 *         return false if the list is null.
	 */
	public static boolean allZeroes(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one positive (more than 0) value in the
	 *         array, false otherwise.
	 *         return false if the list is null.
	 */
	public static boolean containsPositive(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one zero in the array, false otherwise.
	 *         return false if the list is null.
	 */
	public static boolean containsZero(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list is in ascending order, false otherwise.
	 *         return false if the list is null.
	 */
	public static boolean isAscending(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are the same, false otherwise.
	 *         return false if the list is null.
	 */
	public static boolean isUnchanged(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list contains the same number of positive (more than 0)
	 *         and negative (less than 0) items.
	 *         return false if list is null.
	 */
	public static boolean isBalanced(ArrayList<Integer> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if at least 1 item of the list is a valid digit ('0' to '9'),
	 *         false otherwise.
	 *         return false if list is null.
	 */
	public static boolean containsDigit(ArrayList<Character> list) {
		return false; // to be completed
	}

	/**
	 * 
	 * @param list
	 * @return a copy of the list.
	 *         NOTE: the list returned SHOULD NOT refer to the same collection
	 *         that the list passed refers to.
	 *         In other words
	 *         if you update the values in the list returned,
	 *         the values in the list passed should not change.
	 */
	public static ArrayList<Integer> getCopy(ArrayList<Integer> list) {
		return null; // to be completed
	}
}