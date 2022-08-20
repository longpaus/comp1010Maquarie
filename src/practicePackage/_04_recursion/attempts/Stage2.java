package practicePackage._04_recursion.attempts;

public class Stage2 {


	/**
	 * 
	 * @param n
	 * @return the sum of the even digits in n
	 */
	public static int sumEvenDigits(int n) {
		if(n < 0) {
			n *= -1;
		}
		String s=String.valueOf(n);
		return sumEvenDigitsRecur(s, s.length() - 1);
	}
	public static int sumEvenDigitsRecur(String s,int count) {
		int value = Character.getNumericValue(s.charAt(count));
		if(count == 0) {
			if(value % 2 == 0) {
				return value;
			}
			return 0;
		}
		if((value % 2 == 0)) {
			return sumEvenDigitsRecur(s, count - 1) +  value;
		}else {
			return sumEvenDigitsRecur(s, count - 1);
		}
		
	}

	/**
	 * 
	 * @param n
	 * @param d: digit to count, d is between 0 and 9 (inclusive on both sides)
	 * @return the number of times digit d exists in integer n
	 * IMPORTANT countDigit(0, d) for any d should return 0
	 * 
	 * countDigit(10074, 0) = 2
	 * countDigit(38, 8) = 1
	 * countDigit(888, 8) = 3
	 * countDigit(12345, 6) = 0
	 * countDigit(0, 0) = 0 (NOT 1)
	 */
	public static int countDigit(int n, int d) {
		if(n == 0){
			return 0;
		}
		String s = String.valueOf(n);
		return countDigitRecur(s, s.length() - 1, d); 
	}

	public static int countDigitRecur(String num,int index,int d){
		int value = Character.getNumericValue(num.charAt(index));
		if(index == 0){
			if(value == d){
				return 1;
			}
			return 0;
		}
		if(value == d){
			return 1 + countDigitRecur(num,index - 1,d);
		}
		return countDigitRecur(num,index - 1,d);
	}

	/**
	 * 
	 * @param a
	 * @param b (assume b is more than or equal to 1)
	 * @return the product of a and b using ONLY addition operator (+).
	 * you cannot use the multiplication operator (*) 
	 * or the Math library
	 * HINT: multiplication is repeated addition
	 */
	public static int product(int a, int b) {
		if(b == 1){
			return a;
		}
		return a + product(a,b - 1);
	}

	/**
	 * tribonacci sequence is a variation of fibonacci sequence where the first three terms
	 * are 0, 0 and 1 and every subsequent term is the sum of the THREE terms
	 * before it
	 * @param n
	 * @return term at index n in tribonacci sequence
	 * 
	 * FOR EXAMPLE,
	 * tribonacci(0) = 0
	 * tribonacci(1) = 0
	 * tribonacci(2) = 1
	 * tribonacci(3) = 1
	 * tribonacci(4) = 2
	 * tribonacci(5) = 4
	 * tribonacci(6) = 7
	 * tribonacci(7) = 13
	 */
	public static int tribonacci(int n) {
		if(n < 2){
			return 0;
		}
		if(n == 2){
	        return 1;
	    }
		return tribonacciRecur(n, 0, 0, 1); //to be completed
	}
	public static int tribonacciRecur(int n,int num1, int num2,int num3){
		int value = num1 + num2 + num3; 
		if(n == 3){
			return value;
		}
		return tribonacciRecur(n - 1, num2, num3, value);
	}

	/**
	 * 
	 * @param n
	 * @return the smallest digit in the value passed
	 */
	public static int smallestDigit(int n) {
		return 0;
	}

	/**
	 * 
	 * @param n
	 * @return the smallest even digit in the value passed
	 * return 0 if the number doesn't have any even digits
	 */
	public static int smallestEvenDigit(int n) {
		return 0;	
	}

	/**
	 * 
	 * @param n
	 * @return the location of the highest even digit in the value passed.
	 * 1 if the highest even digit is the least significant digit,
	 * 2 if the highest even digit is the second-least significant digit, and so on, 
	 * return 0 if the number doesn't have any even digits
	 */
	public static int highestEvenDigitLocation(int n) {
		return 0;
	}

	/**
	 * 
	 * @param n
	 * @return the location of the smallest digit in the value passed.
	 * 1 if the smallest digit is the least significant digit,
	 * 2 if the smallest digit is the second-least significant digit, and so on, 
	 * return 0 if the number is 0.
	 */
	public static int smallestDigitLocation(int n) {
		return 0;
	}
}