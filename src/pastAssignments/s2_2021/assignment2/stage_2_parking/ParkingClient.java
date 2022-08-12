package pastAssignments.s2_2021.assignment2.stage_2_parking;

/**
 * This is the last piece of code to be completed in stage 2.
 * Only after passing all other tests, should you attempt this.
 * @author gauravgupta
 *
 */
public class ParkingClient {

	public static void main(String[] args) {
		String output = getParkingClientSampleOutputA();
		System.out.println(output);
	}
	
	public static String getParkingClientSampleOutputA() {
		String result = "";
		result+=("Parking slip 1\n");
		
		//create a ParkingMeter object (meter) with the array {9,6,3,2}
		ParkingMeter meter = new ParkingMeter(new int[] {9,6,3,2});
		//create a start time (start) representing 10:30
		ParkingTime start = new ParkingTime(10,30);
		//create an end time (end) representing 15:20
		ParkingTime end = new ParkingTime(15,20);
		//create a parking slip (slip) with meter, startTime and endTime
		ParkingSlip slip = new ParkingSlip(meter, start, end);
		//concatenate the output of slip.toString() to the result (followed by "\n")
		result+=(slip+"\n");
		
		
		result+=("Parking slip 2\n");
		//create a ParkingMeter object (meter) with the array {20, 15, 15, 15, 12, 11, 10}
		meter = new ParkingMeter(new int[] {20, 15, 15, 15, 12, 11, 10});
		//create a start date (startDate) representing 5th feb 2021
		ParkingDate startDate = new ParkingDate(5, 2, 2021);
		//create a start time (startTime) representing 10:30
		ParkingTime startTime = new ParkingTime(10,30);
		//create a start date time (startDateTime) representing 10:30, 5th feb 2021
		ParkingDateTime startDateTime = new ParkingDateTime(startDate, startTime);
		//create a end date (endDate) representing 6th feb 2021
		ParkingDate endDate = new ParkingDate(6, 2, 2021);
		//create a end time (endTime) representing 8:20
		ParkingTime endTime = new ParkingTime(8,20);
		//create a end date time (endDateTime) representing 8:20, 6th feb 2021
		ParkingDateTime endDateTime = new ParkingDateTime(endDate, endTime);
		//create a parking slip (slip) with meter, startDateTime and endDateTime
		slip = new ParkingSlip(meter, startDateTime, endDateTime);
		//concatenate the output of slip.toString() to the result (followed by "\n")
		result+=(slip+"\n");
				
		//we can add more cases to negate any unfair advantage from hard-coding

		return result;
	}

}
