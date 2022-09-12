package stage1;

/**
 * 
 * @author gauravgupta
 *         class holds the most relevant information from a football game's
 *         result.
 *         For example, if Chelsea play at home ground against Liverpool (thus,
 *         we say, liverpool is playing "away" or is the away team while chelsea
 *         is the home team), and the score is Chelsea 2 - Liverpool 1, the
 *         home team has scored 2 goals and the away team has scored 1 goal.
 *         The home team ends up winning.
 */
public class Match {
	public String homeTeam, awayTeam;
	public int homeGoals, awayGoals;

	/**
	 * @param hTeam:  for home team
	 * @param aTeam:  for away team
	 * @param hGoals: for home goals
	 * @param aGoals: for away goals
	 */
	public Match(String hTeam, String aTeam, int hGoals, int aGoals) {
		homeTeam = hTeam;
		awayTeam = aTeam;
		homeGoals = hGoals;
		awayGoals = aGoals;
	}

	/**
	 * 
	 * @return 1 if home team wins, -1 if away team wins, 0 if draw
	 */
	public int winner() {
		return (homeGoals > awayGoals) ? 1 : (homeGoals < awayGoals) ? -1 : 0;
	}

	/**
	 * DO NOT MODIFY
	 * 
	 * @return goal difference (home team over away team)
	 */
	public int goalDifference() {
		return homeGoals - awayGoals;
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		return homeTeam + " " + homeGoals + " : " + awayGoals + " " + awayTeam;
	}
}
