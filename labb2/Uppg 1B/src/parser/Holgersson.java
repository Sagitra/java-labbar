package parser;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "input/nilsholg.txt";
		Scanner scanner = ScannerFactory.scannerForNaturalLanguage(pathname);

		//Lista med ord som vi är ute efter
		final String[] ordlista = {"nils", "norge"};

		//Skapandet av arraylisten som ska hålla koll på alla Textprocessors
		List<TextProcessor> ListOFprocess = new ArrayList<>();
		
		//Skapar SingelWordCounter för alla de intressanta orden och lägger
		//Till den till vår attaylist
		for(int i = 0; i < ordlista.length; i++){
			ListOFprocess.add(new SingleWordCounter(ordlista[i]));
		}

		//TextAnalyser har blivit justerad för att kunna ta in arraylist istället
		//för endast ett objekt
		TextAnalyzer analyzer = new TextAnalyzer(ListOFprocess);
		String report = analyzer.analyzeText(scanner);
		System.out.println(report);
	}

}