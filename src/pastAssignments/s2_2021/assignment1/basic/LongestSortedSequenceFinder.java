package pastAssignments.s2_2021.assignment1.basic;

public class LongestSortedSequenceFinder {
	public static int longestSortedSubsequence(int[] data) {
		return Math.max(longestAscendingSubsequence(data), longestDescendingSubsequence(data));
	}

	public static int longestAscendingSubsequence(int[] data) {
		return longestAscendingSubsequence(data,1, 1, data[0]);
	}

	private static int longestAscendingSubsequence(int[] data, int i, int cur, int val) {
		if(i == data.length) {
			return cur;
		}
		if(data[i] >= val) {
			int use = longestAscendingSubsequence(data, i+1, cur+1, data[i]);
			int ignore = longestAscendingSubsequence(data,i+1, cur, val);
			return Math.max(use, ignore);
		}
		int carry = longestAscendingSubsequence(data,i+1, cur, val);
		int reset = longestAscendingSubsequence(data,i+1, 1, data[i]);
		return Math.max(carry, reset);
	}
	
	public static int longestDescendingSubsequence(int[] data) {
		return longestDescendingSubsequence(data,1, 1, data[0]);
	}

	private static int longestDescendingSubsequence(int[] data, int i, int cur, int val) {
		if(i == data.length) {
			return cur;
		}
		if(data[i] <= val) {
			int use = longestDescendingSubsequence(data,i+1, cur+1, data[i]);
			int ignore = longestDescendingSubsequence(data,i+1, cur, val);
			return Math.max(use, ignore);
		}
		int carry = longestDescendingSubsequence(data,i+1, cur, val);
		int reset = longestDescendingSubsequence(data,i+1, 1, data[i]);
		return Math.max(carry, reset);
	}
}
