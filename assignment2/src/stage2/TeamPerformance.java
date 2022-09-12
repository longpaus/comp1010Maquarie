package stage2;

import stage1.*;

import java.text.DecimalFormat;

import doNotModify.*;

public class TeamPerformance {
	public String name;
	public int gamesPlayed, gamesWon, gamesDrawn;
	public int goalsScored, goalsConceded;


	/**
	 * Some validation must be done.
	 * 
	 *  Games won cannot be more than games played.
	 *  Once games won has been set, games drawn cannot be more than games played less games won.
	 * 
	 * @param name: name of team
	 * @param played: number of games played
	 * @param won: number of games won
	 * @param drawn: number of games drawn
	 * @param gScored: goals scored
	 * @param gConceded: goals conceded
	 * 
	 * Note: we are NOT handling some boundary scenarios here 
	 * (for example, if goals scored = 0, games won cannot be more than 0,
	 * of if goals conceded = 0, games won + games drawn should be equal to games played) 
	 * 
	 */
	public TeamPerformance(String name, int played, int won, int drawn, int gScored, int gConceded) {
		//to be completed
	}

	/**
	 * DO NOT MODIFY
	 * assumption: gamesPlayed, gamesWon AND gamesDrawn set correctly.
	 * @return number of games lost
	 */
	public int getGamesLost() {
		return gamesPlayed - gamesWon - gamesDrawn;
	}

	/**
	 * When the first match is added for a team, we don't need to pass
	 * 1 for gamesPlayed and a value for gamesWon. We can calculate that 
	 * using goalsScored and goalsConceded.
	 * 
	 * populate TeamPerformance using parameters passed.
	 * set gamesWon and gamesDrawn based on goals scored and goals conceded.
	 * Think about how that will be done
	 * 
	 * @param name: name of team
	 * @param gScored: goals scored
	 * @param gConceded: goals conceded
	 */
	public TeamPerformance(String name, int gScored, int gConceded) {
		//to be completed
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("###");
		return PrettyPrinterService.padRight(name, 15)+"Games played: "+formatter.format(gamesPlayed)+". Games won: "+formatter.format(gamesWon)+". Games drawn: "+formatter.format(gamesDrawn)+". Games lost: "+formatter.format(getGamesLost())+". Points: "+formatter.format(3*gamesWon + gamesDrawn)+". Goal difference: "+formatter.format(goalsScored - goalsConceded);
	}

	/**
	 * DO NOT MODIFY
	 * @return points based on the formula that every win gets you 
	 * 3 points which every draw gets you 1 point
	 */
	public int getPoints() {
		return 3*gamesWon + gamesDrawn;
	}

	/**
	 * DO NOT MODIFY
	 * @return the goal difference (goals scored minus goals conceded)
	 */
	public int getGoalDifference() {
		return this.goalsScored - this.goalsConceded;
	}

	/**
	 * return 1 if calling object has more points than that of parameter object
	 * return -1 if calling object has less points than that of parameter object
	 * in case the two have the same number of points - 
	 * 		return 1 if calling object has a higher goal difference than that of parameter object
	 * 		return -1 if calling object has a lower goal difference than that of parameter object
	 * 		return 0 if calling object has the same goal difference as that of parameter object
	 */
	public int compareTo(TeamPerformance other) {
		return 0; //to be completed
	}

	/**
	 * add the match passed to the teams record.
	 * note that the team corresponding to the calling object 
	 * might be the home team or the away team (or neither!) in the game passed.
	 * 
	 * based on different scenarios, the several attributes of the calling object
	 * need to be updated.
	 *  
	 * for example, 
	 * if calling object represents Chelsea's team performance and the
	 * match passed was between Arsenal and Liverpool, nothing changes for the calling object.
	 * 
	 * if calling object represents Chelsea's team performance and the
	 * match passed was between Arsenal (Home) and Chelsea (Away), 
	 * Chelsea's gamesPlayed increases by 1, and then based on who won,
	 * gamesWon or gamesDrawn will be updated. If Chelsea lost, neither gets changed,
	 * and getGamesLost() will return the correct value (as gamesPlayed HAS increased by 1).
	 * Away goals for Chelsea need to be updated too.
	 * 
	 * Similar scenarios when Chelsea draws or wins away.
	 * 
	 * Similar scenarios when Chelsea wins, draws or loses at home.
	 * 
	 * Also, if the calling object doesn't match either the home team or the away team for the match,
	 * nothing should change.
	 * @param m: Match whose data should be added to teams performance
	 */
	public void addMatchRecord(Match m) {
		//to be completed
	}
}
