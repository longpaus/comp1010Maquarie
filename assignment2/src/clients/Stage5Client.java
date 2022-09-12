package clients;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;

import doNotModify.PrettyPrinterService;
import stage5.PastDecade;

public class Stage5Client {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int year = 9;
		String league = "laLiga";
		PastDecade lastTenYears = new PastDecade(league, year);
		System.out.println(lastTenYears);
		String[] overallTable = lastTenYears.getWeightedTable();
		int standing = 1;
		System.out.println("Last ten years' weighted standings (oldest first): ");
		DecimalFormat df = new DecimalFormat("00");
		for(String t: overallTable) {
			System.out.println((df.format(standing++))+". "+PrettyPrinterService.padRight(t, 20)+Arrays.toString(lastTenYears.getStandings(t)).replaceAll("null", "-"));
		}
		System.out.println();
		System.out.println("Weighted "+league+" table starting "+(2000+ year)+" (more weight for recent years): "+Arrays.toString(lastTenYears.getWeightedTable()));
	}
}
