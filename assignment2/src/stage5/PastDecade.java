package stage5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import stage3.*;
import stage4.*;

public class PastDecade {
	public PointsTable[] endOfSeasonTables;
	public int startYear;

	/**
	 * DO NOT MODIFY
	 * @param start
	 * @throws FileNotFoundException
	 */
	public PastDecade(String league, int start) throws FileNotFoundException {
		endOfSeasonTables = new PointsTable[10];
		DecimalFormat df = new DecimalFormat("00");
		startYear = start;
		for(int i=startYear; i < startYear+10; i++) {
			endOfSeasonTables[i-startYear] = new PointsTable(new Season(league, df.format(i)+df.format(i+1)+".csv"));
		}
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = "";
		for(PointsTable table: endOfSeasonTables) {
			result = result + table + "\n";
		}
		return result;
	}
	
	/**
	 * 
	 * @param team
	 * @return a list of the passed team's standings from oldest to newest.
	 * if a team doesn't appear in a particular season, null should be inserted
	 * for that season
	 */
	public Integer[] getStandings(String team) {
		return new Integer[0]; //dummy array returned. to be completed
	}
	
	/**
	 * D question
	 * @param team
	 * @return the weighted standing of the team passed as the parameter.
	 * the oldest season (first item in list endOfSeasonTables) has weight 1,
	 * the second-oldest season (second item in list endOfSeasonTables) has weight 2,
	 * ...
	 * the latest season (last item in list endOfSeasonTables) has weight endOfSeasonTables.size(),
	 * 
	 * Example (I wrote an explanation but the example is much better):
	 * 
	 * Return null if the club hasn't played during ANY season
	 * Note: It is possible that a club hasn't played some seasons during the last decade,
	 * in such a situation, that year should simply be ignored for the club.
	 * 
	 * For example, 
	 * Newcastle's standings are [null, 12, 5, 16, 10, 15, 18, null, 10, 13]
	 * null means they didn't play 09/10 16/17 seasons
	 * Their weighted standing would be:
	 * (2*12 + 3*5 + 4*16 + 5*10 + 6*15 + 7*18 + 9*10 + 10*13)/(2+3+4+5+6+7+9+10)
	 * 
	 * Brighton only played season 17/18 and 18/19.
	 * Hence their weighted standing would be (9*15 + 10*17)/(9+10) = 305/19 = 16.05 
	 */
	public Double getWeightedStanding(String team) {
		return 0.0; //to be completed
	}
	
	/**
	 * HD question
	 * @return a table with clubs ranked based on their weighted standings
	 */
	public String[] getWeightedTable() {
		return new String[0]; //dummy array returned. to be completed
	}
}
