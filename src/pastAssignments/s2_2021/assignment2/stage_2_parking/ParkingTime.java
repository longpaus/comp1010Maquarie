package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * 
 * this is the first class in stage 2 to be completed
 * 
 * @author gauravgupta
 * represents time in a 24-hour format
 */
public class ParkingTime {
	public int hour, minute;

	/**
	 * 
	 * @param hour
	 * @param minute
	 * 
	 * validate each parameter into corresponding instance variables
	 * 
	 * 
	 * for both hour and minute, any value less than 0 should result
	 * in corresponding instance variable becoming 0.
	 * 
	 * for hour, any value more than 23 should result in instance variable
	 * becoming 23.
	 * 
	 * for minute, any value more than 59 should result in instance variable
	 * becoming 59.
	 * 
	 * parameter for minute should be constrained in the range [0...59]
	 * 
	 * parameter for hour should be constrained in the range [0...23]
	 * 
	 */
	public ParkingTime(int hour, int minute) {
		this.hour = validate(hour, 0, 23);
		this.minute = validate(minute, 0, 59);
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

	public String toString() {
		if(minute<10)
			return hour+":0"+minute;
		return hour+":"+minute;
	}

	/**
	 * 
	 * @param other
	 * @return minutes between calling object and parameter object
	 * (positive if calling object is after parameter object,
	 * negative if calling object is before parameter object,
	 * zero if they represent the same time)
	 * 
	 * for example:
	 * 
	 * if calling object represents 18:01 
	 * and parameter object represents 17:29, return 32
	 * 
	 * if calling object represents 17:29 
	 * and parameter object represents 18:01, return -32 
	 * 
	 * if calling object and parameter object both represent 17:29, return 0 
	 */
	public int minutesBetween(ParkingTime other) {
		int s1 = hour*60 + minute;
		int s2 = other.hour*60 + other.minute;
		return s1 - s2; 
	}

//	/**
//	 * 
//	 * @param other
//	 * @return
//	 * 1 if calling object is after parameter object,
//	 * -1 if calling object is before parameter object,
//	 * 0 if they represent the same time
//	 */
//	public int compareTo(ParkingTime other) {
//		int s = minutesBetween(other);
//		if(s > 0) {
//			return 1;
//		}
//		if(s < 0) {
//			return -1;
//		}
//		return 0;
//	}
}
