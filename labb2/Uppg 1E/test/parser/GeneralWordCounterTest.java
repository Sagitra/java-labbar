package parser;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.DisplayName;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class GeneralWordCounterTest {
    
    @Test
    @DisplayName("Tom lista")
    public void kollaTomLista() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/empty.txt");
        TextProcessor processor = new GeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("", analyzer.analyzeText(scanner));
    }

    //Kom ihåg att ändra limit i GeneralWordCounter
    //limit = 2
    @Test
    @DisplayName("Hitta Nils")
    public void hittaNils() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        TextProcessor processor = new GeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("nils: 2", analyzer.analyzeText(scanner));
    }

    //Kom ihåg att ändra limit i GeneralWordCounter
    //Limit = 3
    @Test
    @DisplayName("Hitta Nils")
    public void hittaNilsMenInteNorge() throws FileNotFoundException{
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils_norway.txt");
        TextProcessor processor = new GeneralWordCounter();
        TextAnalyzer analyzer = new TextAnalyzer(processor);
        assertEquals("nils: 3", analyzer.analyzeText(scanner));
    }

}