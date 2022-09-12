package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stage1.Match;
import stage2.TeamPerformance;

class TeamPerformanceTest {
	TeamPerformance liverpool, manCity, chelsea, tottenham, arsenal;
	TeamPerformance stoke, fulham, sunderland;

	@BeforeEach
	public void run() {
		liverpool = new TeamPerformance("Liverpool", 10, 8, 0, 28, 15); 

		manCity = new TeamPerformance("Man City", 10, 10, 0, 25, 4);

		chelsea = new TeamPerformance("Chelsea", 10, 0, 10, 0, 0);

		tottenham = new TeamPerformance("Tottenham", 10, 7, 3, 19, 12); //same points as liverpool, but lower goal difference

		arsenal = new TeamPerformance("Arsenal", 10, 7, 3, 20, 13); //same points AND goalDifference as Tottenham

		//second constructor
		stoke = new TeamPerformance("Stoke", 0, 3); 
		fulham = new TeamPerformance("Fulham", 1, 0); 
		sunderland = new TeamPerformance("Sunderland", 4, 4);
	}

	@Test
	void testTeamPerformanceStringIntIntIntInt() {
		/**
		 * the test for the constructor determines if each setter is implemented correctly.
		 * there are no separate tests for the setters. use the debugger to trace in case 
		 * there are failures
		 */
		assertEquals("Liverpool", liverpool.name);
		assertEquals("Man City", manCity.name);
		assertEquals("Chelsea", chelsea.name);
		assertEquals("Tottenham", tottenham.name);
		assertEquals("Arsenal", arsenal.name);

		
		assertEquals(0, liverpool.gamesDrawn);
		assertEquals(10, manCity.gamesWon);
		assertEquals(0, chelsea.goalsScored);
		assertEquals(0, chelsea.goalsConceded);

		assertEquals("Chelsea", chelsea.name);
		assertEquals(19, tottenham.goalsScored);
		assertEquals(13, arsenal.goalsConceded);
	}

	@Test
	void testTeamPerformanceStringIntInt() {
		//stoke lost
		assertEquals("Stoke", stoke.name);
		assertEquals(1, stoke.gamesPlayed);
		assertEquals(0, stoke.gamesWon);
		assertEquals(0, stoke.gamesDrawn);
		assertEquals(0, stoke.goalsScored); //negative becomes 0
		assertEquals(3, stoke.goalsConceded);

		//fulham won
		assertEquals("Fulham", fulham.name);
		assertEquals(1, fulham.gamesPlayed);
		assertEquals(1, fulham.gamesWon);
		assertEquals(0, fulham.gamesDrawn);
		assertEquals(1, fulham.goalsScored); 
		assertEquals(0, fulham.goalsConceded); //negative becomes 0

		//sunderland drew
		assertEquals("Sunderland", sunderland.name);
		assertEquals(1, sunderland.gamesPlayed);
		assertEquals(0, sunderland.gamesWon);
		assertEquals(1, sunderland.gamesDrawn);
	}

	@Test
	void testCompareTo() {
		//Man City on top with 30 points
		assertEquals(1, manCity.compareTo(liverpool));
		assertEquals(1, manCity.compareTo(chelsea));
		assertEquals(1, manCity.compareTo(tottenham));

		assertEquals(-1, chelsea.compareTo(tottenham));

		assertEquals(-1, chelsea.compareTo(liverpool)); //on points
		assertEquals(-1, tottenham.compareTo(liverpool)); //same points -> on goal difference
		assertEquals(0, tottenham.compareTo(arsenal)); //same points, same goal difference
	}

	@Test
	void testAddMatchRecord() {
		//before the match: 
		//Man City: played 10, won 10, drawn 0, goals scored: 25, goals conceded: 4 (30 points)
		//Liverpool: played 10, won 8, drawn 0, goals scored: 18, goals conceded: 15 (24 points)
		Match m1 = new Match("Man City", "Liverpool", 1, 2); 
		liverpool.addMatchRecord(m1);
		manCity.addMatchRecord(m1);

		assertEquals(27, liverpool.getPoints());
		assertEquals(11, liverpool.gamesPlayed);
		assertEquals(9, liverpool.gamesWon);
		assertEquals(0, liverpool.gamesDrawn);
		assertEquals(30, liverpool.goalsScored);
		assertEquals(16, liverpool.goalsConceded);

		assertEquals(30, manCity.getPoints());
		assertEquals(11, manCity.gamesPlayed);
		assertEquals(10, manCity.gamesWon);
		assertEquals(0, manCity.gamesDrawn);
		assertEquals(26, manCity.goalsScored);
		assertEquals(6, manCity.goalsConceded);
		
		//before the match: 
		//Stoke: played 1, won 0, drawn 0, goals scored: 0, goals conceded: 3 (0 points)
		//Arsenal: played 10, won 7, drawn 3, goals scored: 20, goals conceded: 13 (24 points)
		Match m2 = new Match("Stoke", "Arsenal", 5, 0); 
		arsenal.addMatchRecord(m2);
		stoke.addMatchRecord(m2);

		assertEquals(3, stoke.getPoints());
		assertEquals(2, stoke.gamesPlayed);
		assertEquals(1, stoke.gamesWon);
		assertEquals(0, stoke.gamesDrawn);
		assertEquals(5, stoke.goalsScored);
		assertEquals(3, stoke.goalsConceded);
		
		assertEquals(24, arsenal.getPoints());
		assertEquals(11, arsenal.gamesPlayed);
		assertEquals(7, arsenal.gamesWon);
		assertEquals(3, arsenal.gamesDrawn);
		assertEquals(20, arsenal.goalsScored);
		assertEquals(18, arsenal.goalsConceded);

		//before the match: 
		//Tottenham: played 10, won 7, drawn 3, goals scored: 19, goals conceded: 12  (24 points)
		//Chelsea: played 10, won 0, drawn 10, goals scored: 0, goals conceded: 0 (10 points)
		Match m3 = new Match("Tottenham", "Chelsea", 3, 3); 
		tottenham.addMatchRecord(m3);
		chelsea.addMatchRecord(m3);
		
		assertEquals(25, tottenham.getPoints());
		assertEquals(11, tottenham.gamesPlayed);
		assertEquals(7, tottenham.gamesWon);
		assertEquals(4, tottenham.gamesDrawn);
		assertEquals(22, tottenham.goalsScored);
		assertEquals(15, tottenham.goalsConceded);
		
		assertEquals(11, chelsea.getPoints());
		assertEquals(11, chelsea.gamesPlayed);
		assertEquals(0, chelsea.gamesWon);
		assertEquals(11, chelsea.gamesDrawn);
		assertEquals(3, chelsea.goalsScored);
		assertEquals(3, chelsea.goalsConceded);
		
		arsenal.addMatchRecord(m3); //arsenal didn't play that match so no change should occur
		assertEquals(24, arsenal.getPoints());
		assertEquals(11, arsenal.gamesPlayed);
		assertEquals(7, arsenal.gamesWon);
		assertEquals(3, arsenal.gamesDrawn);
		assertEquals(20, arsenal.goalsScored);
		assertEquals(18, arsenal.goalsConceded);	
	}
}
