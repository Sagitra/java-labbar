package parser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "input/nilsholg.txt";
		Scanner s = ScannerFactory.scannerForNaturalLanguage(pathname);

		//Inget ändrat mer än att vi nu kallar på multiword finder istället för singel
		TextProcessor p = new MulitWordFinder(REGIONS);
		TextAnalyzer analyzer = new TextAnalyzer(p);
		String report = analyzer.analyzeText(s);
		System.out.println(report);
	}

}