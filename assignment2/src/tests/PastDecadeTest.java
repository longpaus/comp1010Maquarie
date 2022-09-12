package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stage5.PastDecade;

class PastDecadeTest {
	PastDecade lastTenYears;

	@BeforeEach
	public void run() throws FileNotFoundException {
		lastTenYears = new PastDecade("EPL", 9);
	}

	@Test
	void testGetStandings() {
		Integer[] arsenalStandings = lastTenYears.getStandings("Arsenal");

		assertNotNull(arsenalStandings);
		assertEquals("[3, 4, 3, 4, 4, 3, 2, 5, 6, 5]", Arrays.toString(arsenalStandings));

		Integer[] leicesterStandings = lastTenYears.getStandings("Leicester");

		assertNotNull(leicesterStandings);
		assertEquals("[null, null, null, null, null, 14, 1, 12, 9, 9]", Arrays.toString(leicesterStandings));

		Integer[] leedsStandings = lastTenYears.getStandings("Leeds");

		assertNotNull(leedsStandings);
		assertEquals("[null, null, null, null, null, null, null, null, null, null]", Arrays.toString(leedsStandings));
	}

	@Test
	void testGetWeightedStanding() {
		assertNotNull(lastTenYears.getWeightedStanding("Arsenal"));
		assertEquals(4.21, lastTenYears.getWeightedStanding("Arsenal"), 0.01);
		assertNotNull(lastTenYears.getWeightedStanding("Man City"));
		assertEquals(2.0, lastTenYears.getWeightedStanding("Man City"), 0.01);
		assertNotNull(lastTenYears.getWeightedStanding("Leicester"));
		assertEquals(8.95, lastTenYears.getWeightedStanding("Leicester"), 0.01);
		assertNotNull(lastTenYears.getWeightedStanding("West Ham"));
		assertEquals(11.3, lastTenYears.getWeightedStanding("West Ham"), 0.01);
		assertNull(lastTenYears.getWeightedStanding("Leeds"));
	}

	@Test
	void testGetWeightedTable() {
		assertNotNull(lastTenYears.getWeightedTable());
		assertEquals("[Man City, Chelsea, Tottenham, Arsenal, Man United, Liverpool, Everton, Leicester, Wolves, West Ham, Southampton, Crystal Palace, Stoke, Bournemouth, Newcastle, Swansea, Watford, West Brom, Burnley, Birmingham, Fulham, Norwich, Bolton, Aston Villa, Brighton, Blackburn, Sunderland, Wigan, Hull, Huddersfield, Cardiff, Blackpool, Reading, Middlesbrough, QPR, Portsmouth]",Arrays.toString(lastTenYears.getWeightedTable())); 
	}
}
