//DO NOT MODIFY

package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * YOU SHOULD NOT MODIFY THIS CLASS
 * @author gauravgupta
 *
 */
public class ParkingSlip {
	public ParkingDateTime start, end;
	public ParkingMeter meter;
	
	public ParkingSlip(ParkingMeter meter, ParkingDateTime start, ParkingDateTime end) {
		this.meter = meter;
		this.start = start;
		this.end = end;
	}
	
	public ParkingSlip(ParkingMeter meter, ParkingTime startTime, ParkingTime endTime) {
		this.meter = meter;
		ParkingDate date = new ParkingDate();
		this.start = new ParkingDateTime(date, startTime);
		this.end = new ParkingDateTime(date, endTime);
	}
	
	public String toString() {
		return start + " -- " + end + " $"+meter.calculateParkingFee(start, end);
	}
}
