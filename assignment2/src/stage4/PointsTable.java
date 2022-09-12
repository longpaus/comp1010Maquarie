package stage4;

import stage1.*;
import stage2.*;
import stage3.*;

public class PointsTable {
	public Season data;
	public TeamPerformance[] tableEntries;
	
	/**
	 * DO NOT MODIFY
	 * @return the number of entries in team performance list.
	 */
	public int size() {
		return tableEntries.length;
	}

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = data.getSeasonYear()+":\n";
		for(TeamPerformance tp: tableEntries) {
			if(tp!=null) {
				result+=tp.toString()+"\n";
			}
		}
		return result;
	}

	/**
	 * DO NOT MODIFY
	 * load the season using addMatchEntry
	 * 
	 * IMPORTANT: Complete addMatchEntry method for this constructor
	 * and any other method in this class to work
	 * @param season
	 */
	public PointsTable(Season season) {
		data = season;
		
		tableEntries = new TeamPerformance[getNumberOfTeams(season)];
		
		for(int i=0; i < season.size(); i++) {
			addMatchEntry(season.getMatch(i)); 
			//addMatchEntry is the only other method inside PointsTable being called
		}
	}

	/**
	 * DO NOT MODIFY
	 * @param season
	 * @return number of teams given a complete record of matches played during a complete season.
	 * It is assumed that each team plays every other team exactly once
	 */
	public int getNumberOfTeams(Season season) {
		/*
		 * to get the number of teams from number of games,
		 * we use the quadratic equation. 
		 * and you thought math was useless!
		 * 
		 * roots of equation: ax^2 + bx + c = 0
		 * are
		 * (-b  +/- root(b2 -4*a*c))/(2*a)
		 * 
		 * Our equation is:
		 * 
		 * nTeams * nTeams - nTeams = nMatches
		 * and therefore a = 1, b = -1, c = -nMatches
		 * 
		 */
		int c = -season.size();		
		int b = -1;
		int a =  1;
		int D = b*b - 4*a*c;
		int d  = (int)(Math.sqrt(D));
		int n1 = (-b - d)/(2*a); 
		int n2 = (-b + d)/(2*a); 
		int nTeams;
		if(n1 > 0) {
			nTeams = n1;
		}
		else {
			nTeams = n2;
		}
		return nTeams;
	}
	
	/**
	 * 
	 * This is the all-important method to be completed!
	 * add a match so that the corresponding team performances are, if already exists then updated, 
	 * otherwise added after the last non-null entry in the array tableEntries
	 * 
	 * if a team performance entry for the home team already exists, it should be updated
	 * if a team performance entry for the home team already does not exist, it should be added
	 * 
	 * same goes for the away team
	 * 
	 * At the end of the function, call the sort() function so that the points table remains sorted.
	 * @param m: match played
	 */
	public void addMatchEntry(Match m) {
		//to be completed
	}
	
	/**
	 * DO NOT MODIFY
	 * Sorts the array tableEntries from best (top of table) to worst (bottom of table) positions 
	 * (highest to lowest points)
	 */
	public void sort() {
		for(int i=0; i < tableEntries.length && tableEntries[i] != null; i++) {
			int bestIndex = i;
			for(int k=i+1; k < tableEntries.length && tableEntries[k]!=null; k++) {
				if(tableEntries[k].compareTo(tableEntries[bestIndex]) == 1) {
					bestIndex = k;
				}
			}
			TeamPerformance temp = tableEntries[i];
			tableEntries[i] = tableEntries[bestIndex];
			tableEntries[bestIndex] = temp;
		}
	}

	/**
	 * IMPORTANT! Proceed to this method ONLY AFTER addMatchEntry test passes
	 * @param team
	 * @return true if there is a record for the given team (case insensitive)
	 * in tableEntries, false otherwise.
	 */
	public boolean teamExists(String team) {
		return false; //to be completed
	}

	/**
	 * IMPORTANT! Proceed to this method ONLY AFTER addMatchEntry test passes
	 * @param team
	 * @return true index at which there is a record for the given team 
	 * (case insensitive) in tableEntries, -1 if no record exists.
	 */
	public int getTeamIndex(String team) {
		return 0; //to be completed
	}

	/**
	 * IMPORTANT! Proceed to this method ONLY AFTER addMatchEntry test passes
	 * @param standing
	 * @return team with given standing
	 */
	public String getTeamByStanding(int standing) {
		return ""; //to be completed
	}

	/**
	 * IMPORTANT! Proceed to this method ONLY AFTER addMatchEntry test passes
	 * @param team
	 * @return the standing of the passed team.
	 * note that the team at index 0 has standing 1,
	 * team at index 1 has standing 2, and so on.
	 */
	public Integer getStanding(String team) {
		return 0; //to be completed
	}
	
	/**
	 * IMPORTANT! Proceed to this method ONLY AFTER addMatchEntry test passes
	 * Assume there are at least three teams in the table
	 * The bottom three teams are relegated
	 * @param n number of bottom teams to be relegated
	 * @return a list containing the names of the bottom three teams
	 * (in order of appearance in the table from top to bottom)
	 */
	public String[] getRelegatedTeams(int n) {
		return new String[0]; //dummy array returned. to be completed
	}
}
