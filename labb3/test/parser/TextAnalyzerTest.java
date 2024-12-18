package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextAnalyzerTest {

    //MÅSTE ÄNDRA LIMIT OM DET INTE GÅR IGENOM
    @Test
    @DisplayName("Can find Nils in nils.txt ")
    void analyzeText() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        String result = analyzer.analyzeText(scanner);
        System.out.println(result);
        assertEquals("nils=2,", result);
    }

    //@Test
    //@DisplayName("Can find two mils and three norway in nils_norway.txt")

}