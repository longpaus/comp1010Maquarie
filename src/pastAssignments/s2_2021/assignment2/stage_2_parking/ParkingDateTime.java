package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * this is the third class after ParkingTime, ParkingDate to be completed in stage 2.
 * @author gauravgupta
 *
 */
public class ParkingDateTime {
	public ParkingDate date;
	public ParkingTime time;
	public final int MINUTES_IN_DAY = 1440;
	
	/**
	 * 
	 * @param date
	 * @param time
	 */
	public ParkingDateTime(ParkingDate date, ParkingTime time) {
		this.date = date;
		this.time = time;
	}
	
	public String toString() {
		return time + ", " + date;
	}
	
	/**
	 * 
	 * @param other
	 * @return the minutes between the calling object and parameter object
	 * (positive if calling object represents a (date, time) after that represented by parameter object,
	 * negative if calling object represents a (date, time) before that represented by parameter object,
	 * zero if calling object and parameter object represent the same (date, time))
	 * 
	 * for example,
	 * if calling object represents 18:01 on a given date, and parameter object represents
	 * 17:29 on the same date, return 32
	 * 
	 * if calling object represents 18:01 on a given date, and parameter object represents
	 * 17:29 on the next day, return -1408
	 */
	public int minutesBetween(ParkingDateTime other) {
		int d = date.differenceBetween(other.date);
		if(d > 0) {
			int t = time.minutesBetween(other.time);
			if(t >= 0) {
				return d*MINUTES_IN_DAY + t;
			}
			else {
				return (d-1)*MINUTES_IN_DAY + (MINUTES_IN_DAY + t);
			}
		}
		else if(d == 0) {
			return time.minutesBetween(other.time);
		}
		else return other.minutesBetween(this)*-1;
	}
}
