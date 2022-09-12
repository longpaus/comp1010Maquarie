package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stage1.Match;

class MatchTest {
	Match m1, m2, m3;
	
	@BeforeEach
	public void run() {
		m1 = new Match("Chelsea", "Liverpool", 2, 1); 
		m2 = new Match("Leicester", "Man City", 3, 10); 
		m3 = new Match("Arsenal", "Tottenham", 1, 1); 
	}
	
	@Test
	void testMatch() {
		assertEquals("Leicester", m2.homeTeam);
		assertEquals("Man City", m2.awayTeam);
		assertEquals(3, m2.homeGoals);
		assertEquals(10, m2.awayGoals);
		
		m2 = new Match("Leicester", "Man City", 2, 5);
		assertEquals(5, m2.awayGoals);
		
	}

//	excluded from testing
//	@Test
//	void testGoalDifference() {
//		assertEquals(1, m1.goalDifference());
//		assertEquals(-3, m2.goalDifference());
//		assertEquals(0, m3.goalDifference());
//	}

	@Test
	void testWinner() {
		//run() executes again re-instantiating m1, m2, m3
		
		assertEquals(1, m1.winner()); //home team
		assertEquals(-1, m2.winner()); //away team
		assertEquals(0, m3.winner()); //draw
	}

}
