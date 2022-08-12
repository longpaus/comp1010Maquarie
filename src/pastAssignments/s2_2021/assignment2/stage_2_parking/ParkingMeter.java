package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * This is the fourth class in stage 2
 * (after ParkingTime, ParkingDate, ParkingDateTime) to be completed
 * @author gauravgupta
 *
 */
public class ParkingMeter {
	/*
	 * hourlyRates contains the hourly rates in the form: 
	 * {first hour rate, second hour rate, third hour rate....}
	 * All subsequent hours are charged at $1 per hour.
	 * 
	 * For example, if hourlyRates = {30, 28, 20, 12}, it's
	 * $30 for the first hour (or part of)
	 * $28 for the second hour (or part of)
	 * $20 for the third hour (or part of)
	 * $12 for the fourth hour (or part of)
	 * 
	 * If you park for one hour or less, you pay $30,
	 * OTHERWISE, If you park for two hours or less, you pay $58,
	 * OTHERWISE, If you park for three hours or less, you pay $78,
	 * OTHERWISE, If you park for four hours or less, you pay $90,
	 * OTHERWISE, If you park for five hours or less, you pay $91,
	 * OTHERWISE, If you park for six hours or less, you pay $92,
	 * OTHERWISE, If you park for seven hours or less, you pay $92,
	 * ...
	 */
	public int[] hourlyRates;

	/**
	 * CREATE AN INSTANCE COPY (not a reference copy)
	 * of the array passed as parameter into the instance variable array.
	 * 
	 * if a particular value in the passed array is less than 1,
	 * a 1 should be assigned to the corresponding index in the instance variable array.
	 * 
	 * contents of passed array should NOT be modified.
	 * 
	 * If the parameter array is null, the instance variable array should
	 * be initialized to an empty array (not a null array)
	 * @param hourlyRates
	 */
	public ParkingMeter(int[] hourlyRates) {
		if(hourlyRates == null) {
			this.hourlyRates = new int[]{};
		}
		else {
			this.hourlyRates = new int[hourlyRates.length];
			for(int i=0; i < hourlyRates.length; i++) {
				if(hourlyRates[i] <= 0) {
					this.hourlyRates[i] = 1;
				}
				else {
					this.hourlyRates[i] = hourlyRates[i];
				}
			}
		}
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return the parking fee based on the hourly rate.
	 * hours (or part of) beyond the number of hours addressed 
	 * by the array are charged at $1 per hour
	 */
	public int calculateParkingFee(ParkingDateTime start, ParkingDateTime end) {
		int minutes = end.minutesBetween(start);
		//System.out.println(start+" "+end+" "+minutes);
		if(minutes <= 0) {
			return 0;
		}
		int fee = 0;
		int i = 0;
		while(minutes > 0 && i < hourlyRates.length) {
			minutes-=60;
			if(minutes < 0) {
				minutes = 0;
			}
			fee+=hourlyRates[i++];
		}
		fee+=minutes/60;
		if(minutes%60 != 0) {
			fee++; 
		}
		return fee;
	}
}
