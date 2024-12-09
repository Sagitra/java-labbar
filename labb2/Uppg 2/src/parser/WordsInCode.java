package parser;

import java.io.FileNotFoundException;
import java.util.*;

public class WordsInCode{
    public static void main(String args[]) throws FileNotFoundException{
        String pathname = "input/mindustry.txt";

        Scanner scanner = ScannerFactory.scannerForCode(pathname);

        TextProcessor p = new SortedGeneralWordCounter();
        TextAnalyzer textAnalyzer = new TextAnalyzer(p);
        String report = textAnalyzer.analyzeText(scanner);
        System.out.println(report);
    }
}