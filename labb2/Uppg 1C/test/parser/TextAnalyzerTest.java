package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextAnalyzerTest {
 
    @Test
    @DisplayName("Can find Nils in nils.txt ")
    void analyzeText() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        String[] wordsOfIntrest = {"nils"};
        TextProcessor textProcessor = new MulitWordFinder(wordsOfIntrest);
        TextAnalyzer analyzer = new TextAnalyzer(textProcessor);
        assertEquals("nils: 2", analyzer.analyzeText(scanner));
    }

    //@Test
    //@DisplayName("Can find two mils and three norway in nils_norway.txt")

}