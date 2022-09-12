package stage3;

import stage1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
		File source = new File(league+"/"+filename);
		Scanner scanner = new Scanner(source);
		scanner.nextLine(); //ignore header
		int count = 0;
		while(scanner.hasNextLine()) {
			scanner.nextLine();
			count++;
		}
		scanner.close();
		
		matches = new Match[count];
		
		scanner = new Scanner(source);
		scanner.nextLine(); //ignore header
		int i = 0;
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(",");
			Match m = new Match(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
			matches[i++] = m;
		}
		scanner.close();
	}

	/**
	 * DO NOT MODIFY
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
		return new Match("Foo", "Bar", 0, 0); //dummy object returned. to be completed
	}

	/**
	 * 
	 * @param idx
	 * @return name of the winner of the match at passed index
	 * return "We're all winners!" if the match at passed index ended in a  draw.
	 * return null if index is invalid
	 */
	public String getWinner(int idx) {
		return ""; //to be completed
	}

	/**
	 * 
	 * @param team
	 * @return number of games played at home by the team passed
	 */
	public int getHomeGameCount(String team) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param team
	 * @return number of games won at home by the team passed
	 */
	public int getHomeWinCount(String team) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param team
	 * @return number of away games played by the team passed
	 */
	public int getAwayGameCount(String team) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param team
	 * @return number of away games won by the team passed
	 */
	public int getAwayWinCount(String team) {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @return a list of all the matches that resulted in a draw
	 */
	public Match[] getMatchesDrawn() {
		return new Match[0]; //to be completed
	}
	
	/**
	 * 
	 * @return an array containing the longest stretch of consecutive home wins.
	 * return the first stretch in case of a tie.
	 */
	public Match[] longestStretchOfHomeWins() {
		return new Match[0]; //dummy array returned. to be completed
	}

	/**
	 * DO NOT MODIFY
	 * @return season in "Season: YY/YY" format. For example "Season: 13/14"
	 */
	public String getSeasonYear() {
		DecimalFormat df = new DecimalFormat("00");
		return "Season "+df.format(year)+"/"+df.format(year+1);
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = getSeasonYear()+":\n";
		for(Match m: matches) {
			result+=m.toString()+"\n";
		}
		return result;
	}
}
