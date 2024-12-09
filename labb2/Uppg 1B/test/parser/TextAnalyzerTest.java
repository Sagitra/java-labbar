package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextAnalyzerTest {

    @Test
    @DisplayName("Can find Nils in nils.txt ")
    void findNils() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        List<TextProcessor> processors = new ArrayList<>();
        processors.add(new SingleWordCounter("nils"));
        TextAnalyzer analyzer = new TextAnalyzer(processors);
        assertEquals("nils: 2", analyzer.analyzeText(scanner));
    }

    @Test
    @DisplayName("Can find two mils and three norway in nils_norway.txt")
    void findNilsAndNorge() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils_norway.txt");
        List<TextProcessor> processors = new ArrayList<>();
        processors.add(new SingleWordCounter("nils"));
        processors.add(new SingleWordCounter("norge"));
        TextAnalyzer analyzer = new TextAnalyzer(processors);
        assertEquals("nils: 3" + "\n" + "norge: 2", analyzer.analyzeText(scanner));
    }

}