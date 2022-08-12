package pastAssignments.s2_2021.assignment2.stage_2_parking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

import pastAssignments.s2_2021.assignment2.common.Graded;

//DO NOT MODIFY
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	public static ArrayList<String> methodsPassed = new ArrayList<String>();

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(1)
	@Graded(description = "testParkingTimeConstructor", marks=3)
	public void testParkingTimeConstructor() {
		ParkingTime time = new ParkingTime(10, 30);
		assertEquals(10, time.hour);
		assertEquals(30, time.minute);

		time = new ParkingTime(-1, 30);
		assertEquals(0, time.hour);
		assertEquals(30, time.minute);

		time = new ParkingTime(25, 30);
		assertEquals(23, time.hour);
		assertEquals(30, time.minute);

		time = new ParkingTime(16, -1);
		assertEquals(16, time.hour);
		assertEquals(0, time.minute);

		time = new ParkingTime(16, 60);
		assertEquals(16, time.hour);
		assertEquals(59, time.minute);

		time = new ParkingTime(-1, 61);
		assertEquals(0, time.hour);
		assertEquals(59, time.minute);

		time = new ParkingTime(-1, -1);
		assertEquals(0, time.hour);
		assertEquals(0, time.minute);

		time = new ParkingTime(24, 60);
		assertEquals(23, time.hour);
		assertEquals(59, time.minute);
		
		time = new ParkingTime(24, 00);
		assertEquals(23, time.hour);
		assertEquals(00, time.minute);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(2)
	@Graded(description = "testMinutesBetween", marks=3)
	public void testMinutesBetween() {
		ParkingTime time1 = new ParkingTime(18, 1);
		ParkingTime time2 = new ParkingTime(17, 29);
		assertEquals(32, time1.minutesBetween(time2));
		assertEquals(-32, time2.minutesBetween(time1));
		assertEquals(0, time1.minutesBetween(time1));

		time1 = new ParkingTime(18, 12);
		time2 = new ParkingTime(15, 12);
		assertEquals(180, time1.minutesBetween(time2));

		time1 = new ParkingTime(16, 14);
		time2 = new ParkingTime(16, 39);
		assertEquals(25, time2.minutesBetween(time1));
		assertEquals(-25, time1.minutesBetween(time2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(3)
	@Graded(description = "testParkingDateConstructor", marks=3)
	public void testParkingDateConstructor() {
		ParkingDate date = new ParkingDate(9, 8, 2021);
		assertEquals(9, date.day);
		assertEquals(8, date.month);
		assertEquals(2021, date.year);

		date = new ParkingDate(9, 13, 1999);
		assertEquals(9, date.day);
		assertEquals(12, date.month);
		assertEquals(2000, date.year);

		date = new ParkingDate(9, 0, 2022);
		assertEquals(9, date.day);
		assertEquals(1, date.month);
		assertEquals(2021, date.year);

		date = new ParkingDate(-4, 0, 18);
		assertEquals(1, date.day);
		assertEquals(1, date.month);
		assertEquals(2000, date.year);

		date = new ParkingDate(-1, 1, 2021);
		assertEquals(1, date.day);

		date = new ParkingDate(31, 1, 2021);
		assertEquals(31, date.day);

		date = new ParkingDate(31, 2, 2021);
		assertEquals(28, date.day);
		date = new ParkingDate(43, 2, 2018);
		assertEquals(28, date.day);
		date = new ParkingDate(43, 2, 2020);
		assertEquals(29, date.day);
		date = new ParkingDate(43, 2, 2012);
		assertEquals(29, date.day);

		date = new ParkingDate(43, 3, 2020);
		assertEquals(31, date.day);
		date = new ParkingDate(43, 3, 2021);
		assertEquals(31, date.day);
		// Remember to check every month.
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(4)
	@Graded(description = "testParkingDateDifferenceBetween", marks=3)
	public void testParkingDateDifferenceBetween() {
		ParkingDate date1 = new ParkingDate(5, 1, 2021);
		ParkingDate date2 = new ParkingDate(9, 1, 2021);
		assertEquals(4, date2.differenceBetween(date1));
		assertEquals(-4, date1.differenceBetween(date2));

		date1 = new ParkingDate(5, 1, 2021);
		date2 = new ParkingDate(3, 2, 2021);
		assertEquals(29, date2.differenceBetween(date1));
		assertEquals(-29, date1.differenceBetween(date2));

		date1 = new ParkingDate(5, 9, 2021);
		date2 = new ParkingDate(3, 2, 2015);
		assertEquals(-2406, date2.differenceBetween(date1));
		assertEquals(2406, date1.differenceBetween(date2));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(5)
	@Graded(description = "testParkingDateTimeMinutesBetween", marks=3)
	public void testParkingDateTimeMinutesBetween() {
		ParkingDateTime p1 = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(12, 00));
		ParkingDateTime p2 = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(11, 59));
		assertEquals(1, p1.minutesBetween(p2));
		assertEquals(-1, p2.minutesBetween(p1));

		p1 = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(12, 00));
		p2 = new ParkingDateTime(new ParkingDate(5, 4, 2021), new ParkingTime(11, 59));
		assertEquals(-129599, p1.minutesBetween(p2));
		assertEquals(129599, p2.minutesBetween(p1));

		p1 = new ParkingDateTime(new ParkingDate(5, 3, 2021), new ParkingTime(12, 02));
		p2 = new ParkingDateTime(new ParkingDate(20, 5, 2001), new ParkingTime(14, 36));
		assertEquals(10409606, p1.minutesBetween(p2));

		p1 = new ParkingDateTime(new ParkingDate(20, 3, 2021), new ParkingTime(18, 1));
		p2 = new ParkingDateTime(new ParkingDate(21, 3, 2021), new ParkingTime(17, 29));
		assertEquals(-1408, p1.minutesBetween(p2));

		p1 = new ParkingDateTime(new ParkingDate(31, 3, 2021), new ParkingTime(18, 1));
		p2 = new ParkingDateTime(new ParkingDate(1, 5, 2021), new ParkingTime(17, 29));
		assertEquals(-44608, p1.minutesBetween(p2));

		p1 = new ParkingDateTime(new ParkingDate(31, 3, 2020), new ParkingTime(18, 1));
		p2 = new ParkingDateTime(new ParkingDate(1, 5, 2021), new ParkingTime(17, 29));
		assertEquals(-570208, p1.minutesBetween(p2));

		p1 = new ParkingDateTime(new ParkingDate(31, 3, 2019), new ParkingTime(18, 1));
		p2 = new ParkingDateTime(new ParkingDate(1, 5, 2020), new ParkingTime(17, 29));
		assertEquals(-571648, p1.minutesBetween(p2));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(6)
	@Graded(description = "testParkingMeterConstructor", marks=3)
	public void testParkingMeterConstructor() {
		int[] rate = new int[] { 30, 28, 20, 12 };
		ParkingMeter meter = new ParkingMeter(null);
		assertNotNull(meter.hourlyRates);
		assertEquals(0, meter.hourlyRates.length);

		meter = new ParkingMeter(rate);
		assertEquals("[30, 28, 20, 12]", Arrays.toString(meter.hourlyRates));
		rate[0] = 1;
		assertEquals("[30, 28, 20, 12]", Arrays.toString(meter.hourlyRates));

		meter = new ParkingMeter(new int[] { 10, 70, 20 });
		assertEquals("[10, 70, 20]", Arrays.toString(meter.hourlyRates));
	
		int[] passedArray = new int[] { 3, -8, 7, 0 };
		meter = new ParkingMeter(passedArray);
		assertEquals("[3, 1, 7, 1]", Arrays.toString(meter.hourlyRates));
		assertEquals("[3, -8, 7, 0]", Arrays.toString(passedArray)); //passed array should not be modified
		
		passedArray = new int[] {0, -1, -2, -3, -4, -5, -6, -7, -8, -9};
		meter = new ParkingMeter(passedArray);
		assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", Arrays.toString(meter.hourlyRates));
		assertEquals("[0, -1, -2, -3, -4, -5, -6, -7, -8, -9]", Arrays.toString(passedArray)); //passed array should not be modified
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(7)
	@Graded(description = "testCalculateParkingFee", marks=3)
	public void testCalculateParkingFee() {
		ParkingMeter meter = new ParkingMeter(new int[] {30, 28, 20, 12 });
		ParkingDateTime end = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(11, 59));
		ParkingDateTime start = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(11, 59));
		assertEquals(0, meter.calculateParkingFee(start, end));

		end = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(12, 00));
		start = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(11, 59));
		assertEquals(30, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(5, 1, 2021), new ParkingTime(11, 59));
		assertEquals(0, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(14, 00));
		start = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(11, 1));
		assertEquals(78, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(14, 02));
		start = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(11, 1));
		assertEquals(90, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(23, 00));
		start = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(11, 1));
		assertEquals(98, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(15, 2, 2021), new ParkingTime(11, 2));
		start = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(11, 1));
		assertEquals(111, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(15, 2, 2021), new ParkingTime(11, 2));
		start = new ParkingDateTime(new ParkingDate(14, 2, 2021), new ParkingTime(11, 2));
		assertEquals(110, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		end = new ParkingDateTime(new ParkingDate(31, 12, 2021), new ParkingTime(23, 59));
		start = new ParkingDateTime(new ParkingDate(1, 1, 2000), new ParkingTime(0,0));
		assertEquals(192950, meter.calculateParkingFee(start, end));
		assertEquals(0, meter.calculateParkingFee(end, start));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(9)
	@Graded(description = "testGetParkingClientSampleOutputA", marks=3)
	public void testGetParkingClientSampleOutputA() {
		testParkingMeterConstructor();
		String expected = "Parking slip 1\r\n"
				+ "10:30, 1/1/2000 -- 15:20, 1/1/2000 $21\n"
				+ "Parking slip 2\n"
				+ "10:30, 5/2/2021 -- 8:20, 6/2/2021 $113\n";
		String actual = ParkingClient.getParkingClientSampleOutputA();
		
		//get rid of newlines and leading trailing spaces
		expected = expected.replaceAll("\n", "").replaceAll("\r", "").trim();
		actual = actual.replaceAll("\n", "").replaceAll("\r", "").trim();
		
		assertEquals(expected, actual);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if (currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score += graded.marks();
			result += graded.description() + " passed. Marks awarded: " + graded.marks() + "\n";
		}
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		if (result.length() != 0) {
			result = result.substring(0, result.length() - 1); // remove the last "\n"
		}
		System.out.println(result + "\n" + score);
	}
}
