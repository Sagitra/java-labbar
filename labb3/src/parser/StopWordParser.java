package parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWordParser {

    public static String[] parse(String s) throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage(s);
        List<String> actualList = new ArrayList<>();
        scanner.forEachRemaining(actualList::add);
        return actualList.toArray(String[]::new);
    }
}
