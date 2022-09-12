package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stage3.Season;
import stage4.PointsTable;

class PointsTableTest {
	PointsTable blank;
	PointsTable table12, table15, table17;

	@BeforeEach
	public void run() throws FileNotFoundException {
		//blank = new PointsTable(new Season("0102blank.csv")); //blank season
		
		/**
		 * IMPORTANT: Correctness of PointsTable constructor depends upon the 
		 * correct implementation of addMatchEntry. Make sure testAddMatchEntry
		 * passes and only then will these objects be constructed correctly.
		 */
		table12 = new PointsTable(new Season("EPL", "1213.csv"));
		table15 = new PointsTable(new Season("EPL", "1516.csv"));
		table17 = new PointsTable(new Season("EPL", "1718.csv"));
	}
	
	@Test
	void testAddMatchEntry() {
		//if addMatchEntry is completed correctly, the constructor will work automatically
		assertEquals(20, table12.tableEntries.length);
		assertEquals(20, table15.tableEntries.length);
		assertEquals(20, table17.tableEntries.length);
		assertEquals("Season 12/13:\n"
				+ "Man United     Games played: 38. Games won: 28. Games drawn: 5. Games lost: 5. Points: 89. Goal difference: 43\n"
				+ "Man City       Games played: 38. Games won: 23. Games drawn: 9. Games lost: 6. Points: 78. Goal difference: 32\n"
				+ "Chelsea        Games played: 38. Games won: 22. Games drawn: 9. Games lost: 7. Points: 75. Goal difference: 36\n"
				+ "Arsenal        Games played: 38. Games won: 21. Games drawn: 10. Games lost: 7. Points: 73. Goal difference: 35\n"
				+ "Tottenham      Games played: 38. Games won: 21. Games drawn: 9. Games lost: 8. Points: 72. Goal difference: 20\n"
				+ "Everton        Games played: 38. Games won: 16. Games drawn: 15. Games lost: 7. Points: 63. Goal difference: 15\n"
				+ "Liverpool      Games played: 38. Games won: 16. Games drawn: 13. Games lost: 9. Points: 61. Goal difference: 28\n"
				+ "West Brom      Games played: 38. Games won: 14. Games drawn: 7. Games lost: 17. Points: 49. Goal difference: -4\n"
				+ "Swansea        Games played: 38. Games won: 11. Games drawn: 13. Games lost: 14. Points: 46. Goal difference: -4\n"
				+ "West Ham       Games played: 38. Games won: 12. Games drawn: 10. Games lost: 16. Points: 46. Goal difference: -8\n"
				+ "Norwich        Games played: 38. Games won: 10. Games drawn: 14. Games lost: 14. Points: 44. Goal difference: -17\n"
				+ "Fulham         Games played: 38. Games won: 11. Games drawn: 10. Games lost: 17. Points: 43. Goal difference: -10\n"
				+ "Stoke          Games played: 38. Games won: 9. Games drawn: 15. Games lost: 14. Points: 42. Goal difference: -11\n"
				+ "Southampton    Games played: 38. Games won: 9. Games drawn: 14. Games lost: 15. Points: 41. Goal difference: -11\n"
				+ "Aston Villa    Games played: 38. Games won: 10. Games drawn: 11. Games lost: 17. Points: 41. Goal difference: -22\n"
				+ "Newcastle      Games played: 38. Games won: 11. Games drawn: 8. Games lost: 19. Points: 41. Goal difference: -23\n"
				+ "Sunderland     Games played: 38. Games won: 9. Games drawn: 12. Games lost: 17. Points: 39. Goal difference: -13\n"
				+ "Wigan          Games played: 38. Games won: 9. Games drawn: 9. Games lost: 20. Points: 36. Goal difference: -26\n"
				+ "Reading        Games played: 38. Games won: 6. Games drawn: 10. Games lost: 22. Points: 28. Goal difference: -30\n"
				+ "QPR            Games played: 38. Games won: 4. Games drawn: 13. Games lost: 21. Points: 25. Goal difference: -30\n"
				+ "", table12.toString());
		assertEquals("Season 15/16:\n"
				+ "Leicester      Games played: 38. Games won: 23. Games drawn: 12. Games lost: 3. Points: 81. Goal difference: 32\n"
				+ "Arsenal        Games played: 38. Games won: 20. Games drawn: 11. Games lost: 7. Points: 71. Goal difference: 29\n"
				+ "Tottenham      Games played: 38. Games won: 19. Games drawn: 13. Games lost: 6. Points: 70. Goal difference: 34\n"
				+ "Man City       Games played: 38. Games won: 19. Games drawn: 9. Games lost: 10. Points: 66. Goal difference: 30\n"
				+ "Man United     Games played: 38. Games won: 19. Games drawn: 9. Games lost: 10. Points: 66. Goal difference: 14\n"
				+ "Southampton    Games played: 38. Games won: 18. Games drawn: 9. Games lost: 11. Points: 63. Goal difference: 18\n"
				+ "West Ham       Games played: 38. Games won: 16. Games drawn: 14. Games lost: 8. Points: 62. Goal difference: 14\n"
				+ "Liverpool      Games played: 38. Games won: 16. Games drawn: 12. Games lost: 10. Points: 60. Goal difference: 13\n"
				+ "Stoke          Games played: 38. Games won: 14. Games drawn: 9. Games lost: 15. Points: 51. Goal difference: -14\n"
				+ "Chelsea        Games played: 38. Games won: 12. Games drawn: 14. Games lost: 12. Points: 50. Goal difference: 6\n"
				+ "Everton        Games played: 38. Games won: 11. Games drawn: 14. Games lost: 13. Points: 47. Goal difference: 4\n"
				+ "Swansea        Games played: 38. Games won: 12. Games drawn: 11. Games lost: 15. Points: 47. Goal difference: -10\n"
				+ "Watford        Games played: 38. Games won: 12. Games drawn: 9. Games lost: 17. Points: 45. Goal difference: -10\n"
				+ "West Brom      Games played: 38. Games won: 10. Games drawn: 13. Games lost: 15. Points: 43. Goal difference: -14\n"
				+ "Crystal Palace Games played: 38. Games won: 11. Games drawn: 9. Games lost: 18. Points: 42. Goal difference: -12\n"
				+ "Bournemouth    Games played: 38. Games won: 11. Games drawn: 9. Games lost: 18. Points: 42. Goal difference: -22\n"
				+ "Sunderland     Games played: 38. Games won: 9. Games drawn: 12. Games lost: 17. Points: 39. Goal difference: -14\n"
				+ "Newcastle      Games played: 38. Games won: 9. Games drawn: 10. Games lost: 19. Points: 37. Goal difference: -21\n"
				+ "Norwich        Games played: 38. Games won: 9. Games drawn: 7. Games lost: 22. Points: 34. Goal difference: -28\n"
				+ "Aston Villa    Games played: 38. Games won: 3. Games drawn: 8. Games lost: 27. Points: 17. Goal difference: -49\n"
				+ "", table15.toString());
	}

	@Test
	void testTeamExists() {
		assertTrue(table12.teamExists("Arsenal"));
		assertTrue(table15.teamExists("Arsenal"));
		assertTrue(table17.teamExists("Arsenal"));

		assertTrue(table12.teamExists("Chelsea"));
		assertTrue(table15.teamExists("Chelsea"));
		assertTrue(table17.teamExists("Chelsea"));

		assertFalse(table12.teamExists("Leeds")); //what happened :( ?!
		assertFalse(table15.teamExists("Leeds"));
		assertFalse(table17.teamExists("Leeds"));

		assertFalse(table12.teamExists("Leicester"));
		assertTrue(table12.teamExists("QPR"));
		assertTrue(table15.teamExists("Leicester")); //OH YEAH!!!
		assertFalse(table17.teamExists("QPR"));
		assertTrue(table17.teamExists("Leicester"));
	}

	@Test
	void testGetTeamIndex() {
		assertEquals(0, table15.getTeamIndex("Leicester"));
		assertEquals(1, table15.getTeamIndex("Arsenal"));
		assertEquals(10, table15.getTeamIndex("Everton"));
		assertEquals(18, table15.getTeamIndex("Norwich"));
		assertEquals(19, table15.getTeamIndex("Aston Villa"));

		assertEquals(0, table17.getTeamIndex("Man City"));
		assertEquals(1, table17.getTeamIndex("Man United"));
		assertEquals(10, table17.getTeamIndex("Crystal Palace"));
		assertEquals(18, table17.getTeamIndex("Stoke"));
		assertEquals(19, table17.getTeamIndex("West Brom"));
	}

	@Test
	void testGetTeamByStanding() {
		assertNull(table15.getTeamByStanding(-1));
		assertNull(table15.getTeamByStanding(0));
		assertNull(table15.getTeamByStanding(21));

		assertNotNull(table15.getTeamByStanding(1));
		assertEquals("Leicester", table15.getTeamByStanding(1));

		assertNotNull(table15.getTeamByStanding(20));
		assertEquals("Aston Villa", table15.getTeamByStanding(20));

		assertNotNull(table15.getTeamByStanding(10));
		assertEquals("Chelsea", table15.getTeamByStanding(10));
	}

	@Test
	void testGetStanding() {
		assertNull(table15.getStanding("Leeds")); //not there

		assertNotNull(table15.getStanding("Arsenal"));
		assertEquals((Integer)2, table15.getStanding("Arsenal"));

		assertNotNull(table15.getStanding("Tottenham"));
		assertEquals((Integer)3, table15.getStanding("Tottenham"));

		assertNotNull(table15.getStanding("Arsenal"));
		assertEquals((Integer)17, table15.getStanding("Sunderland"));
	}


	@Test
	void testGetRelegatedTeams() {
		String[] relegated15 = table15.getRelegatedTeams(3);
		assertNotNull(relegated15);
		assertEquals("[Aston Villa, Norwich, Newcastle]", Arrays.toString(relegated15));

		String[] relegated17 = table17.getRelegatedTeams(4);
		assertNotNull(relegated17);
		assertEquals("[West Brom, Stoke, Swansea, Southampton]", Arrays.toString(relegated17));		
	}
}
