package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * 
 * this is the second class in stage 2 to be completed (After ParkingTime)
 * @author gauravgupta
 * a class that represents a date (calendar, not romantic)
 */
public class ParkingDate {
	public int day, month, year;

	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * 
	 * validate parameters before assigning to instance variables.
	 * 
	 * the order in which the values should be assigned to the instance variables is:
	 * 
	 * 1. month and year (in whichever order), and ONLY THEN,
	 * 2. day
	 * 
	 * this means, you can be assured that month and year have been assigned values
	 * before you try and set the date (because that will be important).
	 * 
	 * year should be constrained between 2000 and 2021
	 * month should be constrained between 1 and 12
	 * day should be constrained between 1 and M where
	 * M is the maximum number of days in the constrained/validated month and year.
	 * 
	 * For example, 
	 * if month = 4, year = anything, M = 30
	 * if month = 3, year = anything, M = 31
	 * if month = 2, year is a leap year, M = 29
	 * if month = 2, year is nOT a leap year, M = 28
	 * 
	 */
	public ParkingDate(int day, int month, int year) {
		this.month = validate(month, 1, 12);
		this.year = validate(year, 2000, 2021);
		this.day = validate(day, 1, maxDaysInCurrentMonth());
	}

	private int validate(int val, int min, int max) {
		if(val < min) {
			val = min;
		}
		if(val > max) {
			val = max;
		}
		return val;
	}

	public ParkingDate() {
		this(1,1,2000);
	}

	private static boolean isLeapYear(int year) {
		return (year%4==0 && year%100!=0) || year%400==0;
	}

	public String toString() {
		return day+"/"+month+"/"+year;
	}

	/**
	 * 
	 * @return number of whole days passed since millenium (00:00:00, 01/01/2000)
	 * excluding the current day
	 * 
	 * for example, 
	 * if it's 4th january, 2000, 3 days have passed since 1st january, 2000
	 * if it's 5th january, 2001, 370 days have passed since 1st january, 2000
	 */
	private int daysPassedSinceMillenium() {
		int result = 0;
		for(int i=2000; i < year; i++) {
			result+=365;
			if(isLeapYear(i)) {
				result++;
			}
		}
		for(int mm=1; mm < month; mm++) {
			ParkingDate temp = new ParkingDate(1, mm, year);
			result+=temp.maxDaysInCurrentMonth();
		}
		return result + day - 1;
	}

	/**
	 * 
	 * @param other
	 * @return difference between calling object and parameter object
	 * (positive when calling object is after parameter object,
	 * negative when calling object is before parameter object,
	 * zero when they represent the same date)
	 * 
	 * for example,
	 * 
	 * if calling object represents 5th january, 2020,
	 * and parameter object represents 9th january, 2020, return 4
	 *  
	 * if calling object represents 9th january, 2020,
	 * and parameter object represents 5th january, 2020, return -4 
	 */
	public int differenceBetween(ParkingDate other) {
		int d1 = daysPassedSinceMillenium();
		int d2 = other.daysPassedSinceMillenium();
		return d1 - d2;
	}

	private int maxDaysInCurrentMonth() {
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if(month != 2) {
			return 31;
		}
		if(isLeapYear(year)) {
			return 29;
		}
		return 28;
	}

//	/**
//	 * 
//	 * @param other
//	 * @return
//	 * 1 when calling object is after parameter object,
//	 * -1 when calling object is before parameter object,
//	 * 0 when they represent the same date
//	 */
//	public int compareTo(ParkingDate other) {
//		int d = differenceBetween(other);
//
//		if(d > 0) {
//			return 1;
//		}
//		if(d < 0) {
//			return -1;
//		}
//		return 0;
//	}
}
