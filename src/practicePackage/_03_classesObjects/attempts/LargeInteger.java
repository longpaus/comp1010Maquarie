package practicePackage._03_classesObjects.attempts;

//stores an arbitrarily long integer as a String
//"347582769827982756984357640256360456305040350763507035808467865076085083078064708648"
public class LargeInteger {
	public String value;
	


	/**
	 * May be helpful for other methods
	 * 
	 * instance variable should take on the value of the parameter
	 * @param v: value intended for the instance variable
	 *
	 * if v is not purely numeric (HELPER METHOD PROVIDED), set value to "0"
	 * 
	 * since isNumeric is static, call it as: 
	 * LargeInteger.isNumeric(String to check)
	 */
	public void setValue(String v) {
		value = (isNumeric(v)) ? v : "0";
	}

	//DEFAULT CONSTRUCTOR, do not modify
	public LargeInteger() {
		value = "0"; //DO NOT MODIFY!!!
	}

	/**
	 * DO NOT MODIFY!!!
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if(str == null || str.isEmpty())
			return false;
		if(str.charAt(0) == '+' || str.charAt(0) == '-') {
			if(str.length() == 1)
				return false;
			else
				str = str.substring(1);
		}
		for(int i=0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @return the last digit of the number
	 * example: if value = "1729", return 9 (NOT '9'!!!)
	 */
	public int getLastDigit() {
		return Character.getNumericValue(value.charAt(value.length() - 1));
	}

	/**
	 * HD level
	 * @param other
	 * @return the result of adding calling object with parameter object
	 * for example:
	 * calling object represents "1729"
	 * parameter object represents "325"
	 * returned object represents "2054"
	 * 
	 * calling object represents "-4436933645896356356345030546035064079435397193472924925434"
	 * parameter object represents "945379723853759365972659347623753"
	 * returned object represents "-4436933645896356356345029600655340225676031220813577301681"

	 */
	public LargeInteger add(LargeInteger other) {
		LargeInteger sum = new LargeInteger();
		sum.setValue(findSum(value,other.value));
		return sum;
	}
	
	public static String findSum(String a, String b) {
		 int i = a.length();
		    int j = b.length();
		    int k = Math.max(i, j) + 1; // room for carryover
		    char[] c = new char[k];
		    for (int digit = 0; k > 0; digit /= 10) {
		        if (i > 0)
		            digit += a.charAt(--i) - '0';
		        if (j > 0)
		            digit += b.charAt(--j) - '0';
		        c[--k] = (char) ('0' + digit % 10);
		    }
		    for (k = 0; k < c.length - 1 && c[k] == '0'; k++) {/*Skip leading zeroes*/}
		    return new String(c, k, c.length - k);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}