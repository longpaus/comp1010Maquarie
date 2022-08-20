package practicePackage._04_recursion.attempts;

public class Stage1 {


	/**
	 * May be helpful for other methods
	 * 
	 * @param x
	 * @param n: assume n is more than or equal to 0
	 * @return x to the power of n
	 * IMPORTANT: for any integer x, x to the power of 0 is 1 
	 */
	public static int power(int x, int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return x;
		}
		
		return x*power(x,n - 1);
	}

	/**
	 * 
	 * @param start
	 * @param stop
	 * @return sum of all integers from start to stop (inclusive)
	 * return 0 if start is more than stop
	 */
	public static int sumRange(int start, int stop) {
		if(start > stop) {
			return 0;
		}
		if(start == stop) {
			return start;
		}
		return start + sumRange(start + 1, stop);
		 //to be completed
	}

	/**
	 * 
	 * @param n 
	 * @return sum of the squares of the first n positive integers 
	 * (1*1 + 2*2 + ... + n*n)
	 * return 0 if n is less than or equal to 0
	 */
	public static int sumSquares(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return n*n + sumSquares(n - 1);
	}

	/**
	 * 
	 * @param n 
	 * @return sum of all positive odd numbers till n (including n)
	 * (1 + 3 + 5+ ... (n or n-1))
	 * For example,
	 * if n = 8, return 1+3+5+7=16 
	 * if n = 5, return 1+3+5=9
	 * return 0 if n is less than or equal to 0
	 * 
	 * HINT: if the number is even, ignore it and return sumOdd(n-1)
	 */
	public static int sumOdd(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n % 2 != 0) {
			return n+ sumOdd(n - 1);
		}
		else {
			return sumOdd(n - 1);
		}
	}

	/**
	 * 
	 * @param n 
	 * @return sum of the squares of all positive odd numbers up to n.
	 * (note, n itself may or may not be an odd number)
	 * return 0 if n is less than or equal to 0
	 * For example:
	 * n = 6, return 5*5 + 3*3 + 1*1
	 * n = 7, return 7*7 + 5*5 + 3*3 + 1*1
	 * 
	 * HINT: If n is even, ignore it and return sumOddSquares(n-1)
	 */
	public static int sumOddSquares(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n % 2 == 0) {
			return sumOddSquares(n - 1);
		}
		else {
			return n*n + sumOddSquares(n - 1);
		}
	}

	/**
	 * 
	 * @param str
	 * @return true if str contains ONLY digits ('0' to '9'), false otherwise.
	 * 
	 * !!!!!!IMPORTANT!!!!!! return true if str is empty
	 * 
	 * return false if str is null.
	 * 
	 * HINT: you can check that a char ch is a digit using Character.isDigit(ch)
	 */
	public static boolean isNumeric(String str) {
		if(str == null) {
			return false;
		}
		if(str.length() == 0) {
			return true;
		}
		return isNumericRecur(str,str.length() - 1); //to be completed
	}
	
	public static boolean isNumericRecur(String str,int n) {
		if(Character.isDigit(str.charAt(n))) {
			if(n == 0) {
				return true;
			}
			return isNumericRecur(str, n - 1);
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param str
	 * @param target
	 * @return true if String str contains String target, false otherwise.
	 * return false if str is null or target is null
	 * IMPORTANT: You may not call the methods indexOf or lastIndexOf or contains from String class
	 */
	public static boolean containsStringString(String str, String target) {
		if(str == null || target == null) {
			return false;
		}
		if(str.length() == 0) {
			return false;
		}
		return containsStringRecursion(str, target,0, 0); //to be completed
	}
	
	
	public static boolean containsStringRecursion(String str, String target,int i,int count) {
		if(str.charAt(i) == target.charAt(count) && count == target.length()) {
			return true;
		}
		else if(str.charAt(i) != target.charAt(count) && i == str.length() - 1) {
			return false;
		}
		if(str.charAt(i) == target.charAt(count)) {
			if(count == target.length() - 1) {
				return true;
			}
			return containsStringRecursion(str,target,i + 1,count + 1);
		}else {
			return containsStringRecursion(str,target,i + 1,0);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}