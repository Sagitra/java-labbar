package parser;

import java.io.FileNotFoundException;
import java.util.*;



public class TextAnalyzer {
    private GeneralWordCounter GWC;
    TextProcessor processor;

    public TextAnalyzer(String undantag) {
        GWC = new GeneralWordCounter(undantag);
        processor = GWC;
    }

    public String analyzeText(Scanner s) {
        while (s.hasNext()) {
            this.processor.process(s.next().toLowerCase());
        }
        s.close();
        return this.processor.report();
    }

    public List<Map.Entry<String, Integer>> getWordList(String path) throws FileNotFoundException{
        Scanner s = ScannerFactory.scannerForNaturalLanguage(path);
        while(s.hasNext()){
            this.processor.process(s.next().toLowerCase());
        }
        
        //GWC.process(analyzeText(s));
        return GWC.getWordList(); 
    }
}