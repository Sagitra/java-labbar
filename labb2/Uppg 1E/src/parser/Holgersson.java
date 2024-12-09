package parser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {	
		public static void main(String[] args) throws FileNotFoundException {		
		String pathname = "input/nilsholg.txt";
		Scanner s = ScannerFactory.scannerForNaturalLanguage(pathname);
		
		//TextProcessor p = new GeneralWordCounter(illegal);
		TextProcessor p = new SortedGeneralWordCounter();
		
		TextAnalyzer analyzer = new TextAnalyzer(p);
		String report = analyzer.analyzeText(s);
		System.out.println(report);
	}
}