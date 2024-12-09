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
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("General Mindusrty")
    public void GeneralMindusrty() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/mindustry.txt");
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Sorted Nils")
    public void SortedNils() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/nilsholg.txt");
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        String result = analyzer.analyzeText(scanner);
        System.out.println(result);
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("Sorted Mindusrty")
    public void SortedMindusrty() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForCode("input/mindustry.txt");
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        String result = analyzer.analyzeText(scanner);
        assertFalse(result.isEmpty());
    }
    
}
