package clients;

import java.io.FileNotFoundException;

import stage3.Season;
import stage4.PointsTable;

/**
 * DO NOT MODIFY
 * @author gauravgupta
 *
 */
public class Stage4Client {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Season season = new Season("EPL", "1516.csv");

		PointsTable table = new PointsTable(season);
		
		System.out.println(table);
		System.out.println();
	}

}
