package parser;

import java.util.Scanner;


public class TextAnalyzer {

    TextProcessor processor;

    public TextAnalyzer(TextProcessor textProcessor) {
        processor = textProcessor;
    }

    public String analyzeText(Scanner s) {
        while (s.hasNext()) {
            this.processor.process(s.next().toLowerCase());
        }
        s.close();
        return this.processor.report();
    }
}