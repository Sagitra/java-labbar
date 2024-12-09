package parser;

import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextAnalyzerPerformanceTest {
    
    @Test
    @DisplayName("General Nils")
    public void GeneralNils() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/nilsholg.txt");
        String exclude = "input/undantagsord.txt";
        TextProcessor processor = new GeneralWordCounter(exclude);
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("General Mindusrty")
    public void GeneralMindusrty() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/mindustry.txt");
        String exclude = "input/reserved.txt";
        TextProcessor processor = new GeneralWordCounter(exclude);
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Sorted Nils")
    public void SortedNils() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/nilsholg.txt");
        String exclude = "input/undantagsord.txt";
        TextProcessor processor = new SortedGeneralWordCounter(exclude);
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        String result = analyzer.analyzeText(scanner);
        System.out.println(result);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Sorted Mindusrty")
    public void SortedMindusrty() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForCode("input/mindustry.txt");
        String exclude = "input/reserved.txt";
        TextProcessor processor = new SortedGeneralWordCounter(exclude);
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }
    
}
