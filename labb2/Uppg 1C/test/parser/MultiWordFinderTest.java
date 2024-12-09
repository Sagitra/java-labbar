package parser;

import org.junit.jupiter.api.DisplayName;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MultiWordFinderTest {
    @Test
    @DisplayName("Tom lista")
    void noWordsTest() throws FileNotFoundException{
        //Importerar litsan med relevanta ord
        String[] lista = Holgersson.REGIONS;
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/empty.txt");
        TextProcessor processor = new MulitWordFinder(lista);
        TextAnalyzer analyzer = new TextAnalyzer(processor);

        //Kollar så att med ett tomt dokument så retuneras landskap: 0 för alla
        assertEquals("blekinge: 0" + "\n" + "bohuslän: 0"+ "\n" + "dalarna: 0"+ "\n" + "dalsland: 0"+ "\n" + "gotland: 0"+ "\n" + "gästrikland: 0"+ "\n" +
        "halland: 0"+ "\n" + "hälsingland: 0"+ "\n" + "härjedalen: 0"+ "\n" + "jämtland: 0"+ "\n" + "lappland: 0"+ "\n" + "medelpad: 0"+ "\n" + "närke: 0" + "\n" + "skåne: 0" + "\n" +"småland: 0"+ "\n" +
        "södermanland: 0"+ "\n" + "uppland: 0"+ "\n" + "värmland: 0"+ "\n" + "västerbotten: 0"+ "\n" + "västergötland: 0" + "\n" + "västmanland: 0"+ "\n" + "ångermanland: 0"+ "\n" +
        "öland: 0"+ "\n" + "östergötland: 0", analyzer.analyzeText(scanner));
    }

    @Test
    @DisplayName("En aV varje plus andra ord")
    void OneOfEachTest() throws FileNotFoundException{
        String[] lista = Holgersson.REGIONS;
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/oneOfEach.txt");
        TextProcessor processor = new MulitWordFinder(lista);
        TextAnalyzer analyzer = new TextAnalyzer(processor);

        //Kollar så att en lista med alla förutom dalarna kommer med. fler av vissa och ord som inte ska
        //Plockas upp är också med i listan
        assertEquals("blekinge: 3" + "\n" + "bohuslän: 2"+ "\n" + "dalarna: 0"+ "\n" + "dalsland: 1"+ "\n" + "gotland: 1"+ "\n" + "gästrikland: 1"+ "\n" +
        "halland: 1"+ "\n" + "hälsingland: 1"+ "\n" + "härjedalen: 1"+ "\n" + "jämtland: 1"+ "\n" + "lappland: 1"+ "\n" + "medelpad: 1"+ "\n" + "närke: 1" + "\n" + "skåne: 1" + "\n" +"småland: 1"+ "\n" +
        "södermanland: 1"+ "\n" + "uppland: 1"+ "\n" + "värmland: 1"+ "\n" + "västerbotten: 1"+ "\n" + "västergötland: 1" + "\n" + "västmanland: 1"+ "\n" + "ångermanland: 1"+ "\n" +
        "öland: 1"+ "\n" + "östergötland: 1", analyzer.analyzeText(scanner));
    }
}
