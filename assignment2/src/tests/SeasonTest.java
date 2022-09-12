package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stage1.Match;
import stage3.Season;

class SeasonTest {
	Season s11, s14, s15, s16;

	@BeforeEach
	public void run() throws FileNotFoundException {
		s11 = new Season("EPL", "1112.csv");
		s14 = new Season("EPL", "1415.csv");
		s15 = new Season("EPL", "1516.csv");
		s16 = new Season("EPL", "1617.csv");
	}

	@Test
	void testGetMatch() {
		assertNull(s15.getMatch(-1));
		assertNull(s15.getMatch(s15.size()));


		Match m1 = s15.getMatch(0);
		assertNotNull(m1);
		assertEquals("Bournemouth", m1.homeTeam);
		assertEquals("Aston Villa", m1.awayTeam);
		assertEquals(0, m1.homeGoals);
		assertEquals(1, m1.awayGoals);


		Match m2 = s15.getMatch(s15.size()-1);
		assertNotNull(m1);
		assertEquals("Man United", m2.homeTeam);
		assertEquals("Bournemouth", m2.awayTeam);
		assertEquals(3, m2.homeGoals);
		assertEquals(1, m2.awayGoals);

		Match m3 = s15.getMatch(18);
		assertNotNull(m1);
		assertEquals("Man City", m3.homeTeam);
		assertEquals("Chelsea", m3.awayTeam);
		assertEquals(3, m3.homeGoals);
		assertEquals(0, m3.awayGoals);
	}

	@Test
	void testGetWinner() {
		assertEquals("Aston Villa", s15.getWinner(0));
		assertEquals("We're all winners!", s15.getWinner(1)); //chelsea drew against swansea
		assertEquals("Man City", s15.getWinner(18));
		assertEquals("Man United", s15.getWinner(s15.size()-1));
	}

	@Test
	void testGetHomeGameCount() {
		assertEquals(19, s15.getHomeGameCount("Chelsea"));
		assertEquals(19, s15.getHomeGameCount("Man City"));
	}

	@Test
	void testGetHomeWinCount() {
		assertEquals(5, s15.getHomeWinCount("Chelsea"));
		assertEquals(12, s15.getHomeWinCount("Man City"));
	}

	@Test
	void testGetAwayGameCount() {
		assertEquals(19, s15.getAwayGameCount("Chelsea"));
		assertEquals(19, s15.getAwayGameCount("Man City"));
	}

	@Test
	void testGetAwayWinCount() {
		assertEquals(7, s15.getAwayWinCount("Chelsea"));
		assertEquals(7, s15.getAwayWinCount("Man City"));
	}
	
	@Test
	void testGetMatchesDrawn() {
		Match[] drawnMatches = s15.getMatchesDrawn();
		assertNotNull(drawnMatches);
		assertEquals(107, drawnMatches.length);
		assertEquals("Chelsea 2 : 2 Swansea", drawnMatches[0].toString());
		assertEquals("West Brom 1 : 1 Liverpool", drawnMatches[drawnMatches.length-1].toString());
		assertEquals("[Chelsea 2 : 2 Swansea, Everton 2 : 2 Watford, Newcastle 2 : 2 Southampton, Tottenham 2 : 2 Stoke, Watford 0 : 0 West Brom, Leicester 1 : 1 Tottenham, Man United 0 : 0 Newcastle, Norwich 1 : 1 Stoke, Sunderland 1 : 1 Swansea, Watford 0 : 0 Southampton, Arsenal 0 : 0 Liverpool, Aston Villa 2 : 2 Sunderland, Bournemouth 1 : 1 Leicester, Tottenham 0 : 0 Everton, West Brom 0 : 0 Southampton, Stoke 2 : 2 Leicester, Swansea 0 : 0 Everton, Liverpool 1 : 1 Norwich, Newcastle 2 : 2 Chelsea, West Ham 2 : 2 Norwich, Bournemouth 1 : 1 Watford, Sunderland 2 : 2 West Ham, Everton 1 : 1 Liverpool, Swansea 2 : 2 Tottenham, Southampton 2 : 2 Leicester, Tottenham 0 : 0 Liverpool, Liverpool 1 : 1 Southampton, Man United 0 : 0 Man City, Crystal Palace 0 : 0 Man United, Newcastle 0 : 0 Stoke, West Ham 1 : 1 Everton, Arsenal 1 : 1 Tottenham, Aston Villa 0 : 0 Man City, Swansea 2 : 2 Bournemouth, Bournemouth 3 : 3 Everton, Leicester 1 : 1 Man United, Norwich 1 : 1 Arsenal, Tottenham 0 : 0 Chelsea, West Ham 1 : 1 West Brom, Man United 0 : 0 West Ham, Southampton 1 : 1 Aston Villa, West Brom 1 : 1 Tottenham, Everton 1 : 1 Crystal Palace, Norwich 1 : 1 Everton, West Ham 0 : 0 Stoke, Liverpool 2 : 2 West Brom, Newcastle 1 : 1 Aston Villa, Swansea 0 : 0 West Ham, Aston Villa 1 : 1 West Ham, Bournemouth 0 : 0 Crystal Palace, Chelsea 2 : 2 Watford, Crystal Palace 0 : 0 Swansea, Man United 0 : 0 Chelsea, Leicester 0 : 0 Man City, Leicester 0 : 0 Bournemouth, Everton 1 : 1 Tottenham, Newcastle 3 : 3 Man United, Chelsea 2 : 2 West Brom, Liverpool 3 : 3 Arsenal, Man City 0 : 0 Everton, Aston Villa 1 : 1 Leicester, Chelsea 3 : 3 Everton, Stoke 0 : 0 Arsenal, Sunderland 1 : 1 Bournemouth, West Brom 0 : 0 Aston Villa, West Ham 2 : 2 Man City, Arsenal 0 : 0 Southampton, West Brom 1 : 1 Swansea, Watford 0 : 0 Chelsea, Liverpool 2 : 2 Sunderland, Swansea 1 : 1 Crystal Palace, Chelsea 1 : 1 Man United, Norwich 2 : 2 West Ham, Watford 0 : 0 Bournemouth, Leicester 2 : 2 West Brom, Sunderland 2 : 2 Crystal Palace, Chelsea 1 : 1 Stoke, Southampton 1 : 1 Sunderland, Tottenham 2 : 2 Arsenal, Norwich 0 : 0 Man City, Chelsea 2 : 2 West Ham, Newcastle 1 : 1 Sunderland, Liverpool 1 : 1 Tottenham, Stoke 2 : 2 Swansea, Sunderland 0 : 0 West Brom, West Ham 2 : 2 Crystal Palace, Watford 1 : 1 Everton, West Ham 3 : 3 Arsenal, Crystal Palace 0 : 0 Everton, Everton 1 : 1 Southampton, Arsenal 1 : 1 Crystal Palace, Leicester 2 : 2 West Ham, Newcastle 1 : 1 Man City, Liverpool 2 : 2 Newcastle, Sunderland 0 : 0 Arsenal, Tottenham 1 : 1 West Brom, Stoke 1 : 1 Sunderland, Man United 1 : 1 Leicester, Chelsea 2 : 2 Tottenham, Aston Villa 0 : 0 Newcastle, Bournemouth 1 : 1 West Brom, Man City 2 : 2 Arsenal, Liverpool 1 : 1 Chelsea, Chelsea 1 : 1 Leicester, Swansea 1 : 1 Man City, Watford 2 : 2 Sunderland, West Brom 1 : 1 Liverpool]", Arrays.toString(drawnMatches).trim());
	}
	
	@Test
	void testLongestStretchOfHomeWins() {
		assertEquals("[Southampton 4 : 0 Arsenal, Stoke 2 : 0 Man United, Swansea 1 : 0 West Brom, Tottenham 3 : 0 Norwich, Arsenal 2 : 0 Bournemouth]", Arrays.toString(s15.longestStretchOfHomeWins()));
		assertEquals("[Man United 3 : 1 Chelsea, Sunderland 4 : 0 Stoke, Tottenham 4 : 0 Liverpool, Arsenal 3 : 0 Bolton, Chelsea 4 : 1 Swansea, Liverpool 2 : 1 Wolves, Man City 2 : 0 Everton, Newcastle 3 : 1 Blackburn]", Arrays.toString(s11.longestStretchOfHomeWins()));
	}
}
