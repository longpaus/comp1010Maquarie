package stage3;

import stage1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;





public class Season {
	public Match[] matches;
	public int year;

	/**
	 * DO NOT MODIFY
	 * reads the data for a football season from the filename provided.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public Season(String league, String filename) throws FileNotFoundException {
		year = Integer.parseInt(filename.substring(0, 2));
		File source = new File(league + "/" + filename);
		Scanner scanner = new Scanner(source);
		scanner.nextLine(); // ignore header
		int count = 0;
		while (scanner.hasNextLine()) {
			scanner.nextLine();
			count++;
		}
		scanner.close();

		matches = new Match[count];

		scanner = new Scanner(source);
		scanner.nextLine(); // ignore header
		int i = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(",");
			Match m = new Match(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
			matches[i++] = m;
		}
		scanner.close();
	}

	/**
	 * DO NOT MODIFY
	 * 
	 * @return
	 */
	public int size() {
		return matches.length;
	}

	/**
	 * 
	 * @param idx
	 * @return the match at given index (null if index invalid)
	 */
	public Match getMatch(int idx) {
		if (this.size() - 1 < idx || idx < 0)
			return null;
		return matches[idx];
	}

	/**
	 * 
	 * @param idx
	 * @return name of the winner of the match at passed index
	 *         return "We're all winners!" if the match at passed index ended in a
	 *         draw.
	 *         return null if index is invalid
	 */
	public String getWinner(int idx) {
		Match match = this.getMatch(idx);

		return (match.winner() == 1) ? match.homeTeam : (match.winner() == -1) ? match.awayTeam : "We're all winners!";
	}

	/**
	 * 
	 * @param team
	 * @return number of games played at home by the team passed
	 */
	public int getHomeGameCount(String team) {
		int count = 0;
		for(Match match:matches){
			if(isStringEqual(match.homeTeam, team))
				count++;
		}
		return count;
	}
	private static boolean isStringEqual(String str1,String str2) {
		if(str1.length() != str2.length())
			return false;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param team
	 * @return number of games won at home by the team passed
	 */
	public int getHomeWinCount(String team) {
		int gamesWon = 0;
		for(Match match:matches){
			if(isStringEqual(match.homeTeam, team) && match.winner() == 1)
				gamesWon++;
		}
		return gamesWon;
	}

	/**
	 * 
	 * @param team
	 * @return number of away games played by the team passed
	 */
	public int getAwayGameCount(String team) {
		int count = 0;
		for(Match match:matches){
			if(isStringEqual(match.awayTeam, team))
				count++;
		}
		return count;
	}

	/**
	 * 
	 * @param team
	 * @return number of away games won by the team passed
	 */
	public int getAwayWinCount(String team) {
		int gamesWon = 0;
		for(Match match:matches){
			if(isStringEqual(match.awayTeam, team) && match.winner() == -1)
				gamesWon++;
		}
		return gamesWon;
	}

	/**
	 * 
	 * @return a list of all the matches that resulted in a draw
	 */
	public Match[] getMatchesDrawn() {
		int numDraw = 0;
		for(Match match:matches){
			if(match.winner() == 0)
				numDraw++;
		}
		Match[] draws = new Match[numDraw];
		for(int i = 0,j = 0; i < matches.length; i++){
			if(matches[i].winner() == 0)
				draws[j++] = matches[i];
		}
		return draws;
	}
	/**
	 * 
	 * @return an array containing the longest stretch of consecutive home wins.
	 *         return the first stretch in case of a tie.
	 */
	public Match[] longestStretchOfHomeWins() {
		Match[] draws = new Match[0];
		Match[] longest = new Match[0];
		for(Match match:matches){
			if(match.winner() == 1)
				draws = addMatch(draws, match);
			else
				draws = new Match[0];
			if(longest.length < draws.length)
				longest = cpyArr(draws);
		}
		return longest;
	}
	private static Match[] cpyArr(Match[] draws){
		Match[] newArr = new Match[draws.length];
		int i = 0;
		for(Match match:draws)
			newArr[i++] = match;
		return newArr;
	}
	private static Match[] addMatch(Match[] draws,Match match){
		Match[] newDraws = new Match[draws.length + 1];
		for(int i = 0; i < draws.length; i++){
			newDraws[i] = draws[i];
		}
		newDraws[draws.length] = match;
		return newDraws;
	}

	/**
	 * DO NOT MODIFY
	 * 
	 * @return season in "Season: YY/YY" format. For example "Season: 13/14"
	 */
	public String getSeasonYear() {
		DecimalFormat df = new DecimalFormat("00");
		return "Season " + df.format(year) + "/" + df.format(year + 1);
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = getSeasonYear() + ":\n";
		for (Match m : matches) {
			result += m.toString() + "\n";
		}
		return result;
	}
}
