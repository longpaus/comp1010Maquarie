package practicePackage._03_classesObjects.attempts;

public class CarTrip {
	public double distance, time; //in kms and hours respectively
	
	


	/**
	 * May be helpful for other methods
	 * 
	 * @param d: value meant for distance
	 * @param t: value meant for time
	 * 
	 * assign the higher of 0 and d into distance
	 * assign the higher of 0 and t into time
	 */
	public CarTrip(double d, double t) {
		distance = (d > 0) ? d : 0;
		time = (t > 0) ? t : 0;
	}

	/**
	 * return details in the format "distance kms travelled in time hours"
	 * For example, if distance = 2.5, time = 1.2, return "2.5 kms travelled in 1.2 hours" 
	 */
	public String toString() {
		return String.format("%.1f kms travelled in %.1f hours", distance, time);
	}
}