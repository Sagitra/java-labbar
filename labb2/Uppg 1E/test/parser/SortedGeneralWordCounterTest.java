package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

public class SortedGeneralWordCounterTest {
    
    //Kom ihåg att ändra LIMIT
    @Test
    @DisplayName("3 Nils, 2 Norge")
    public void treNilsTvåNorge() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils_norway.txt");
        TextProcessor processor = new SortedGeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("nils: 3" + "\n" + "norge: 2", analyzer.analyzeText(scanner));
    }

    //Kom ihåg att ändra LIMIT
    @Test
    @DisplayName("Nils 2 och Norge 2")
    public void tvåNilsTvåNorge() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/Nils 2 och Norge 2.txt");
        TextProcessor processor = new SortedGeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("nils: 2" + "\n" + "norge: 2", analyzer.analyzeText(scanner));
    }

    @Test
    @DisplayName("tre ord")
    public void threeWordTest() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/threeWordTest.txt");
        TextProcessor processor = new SortedGeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("nils: 5" + "\n" + "norge: 3" + "\n" + "test: 2", analyzer.analyzeText(scanner));
    }
}
