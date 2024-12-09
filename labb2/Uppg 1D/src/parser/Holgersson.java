package parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {	
		public static void main(String[] args) throws FileNotFoundException {
		/*
        ArrayList<String> illegal = new ArrayList<>();
        try {
            Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/undantagsord.txt");
            while(scanner.hasNext()){
                illegal.add(scanner.next());
            }
        } catch (Exception FileNotFoundException) {
            System.out.println("icke giltig path");
        }
		*/
		
		
		String pathname = "input/nilsholg.txt";
		Scanner s = ScannerFactory.scannerForNaturalLanguage(pathname);
		
		//TextProcessor p = new GeneralWordCounter(illegal);
		TextProcessor p = new GeneralWordCounter();
		
		TextAnalyzer analyzer = new TextAnalyzer(p);
		String report = analyzer.analyzeText(s);
		System.out.println(report);
	}
}