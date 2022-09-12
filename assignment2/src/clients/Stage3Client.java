package clients;

import java.io.FileNotFoundException;
import java.util.Arrays;

import stage3.*;

/**
 * DO NOT MODIFY
 * @author gauravgupta
 *
 */
public class Stage3Client {

	public static void main(String[] args) throws FileNotFoundException {
		Season season = new Season("laLiga", "2021.csv");
		System.out.println(season);
		System.out.println("Longest stretch of home wins: "+Arrays.toString(season.longestStretchOfHomeWins()));
	}

}
