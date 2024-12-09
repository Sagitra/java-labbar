package parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFactory {

/**
* This scanner uses regular expressions to express how the text should be split into words.
* You don't really need to know how this works, at the moment.
     * But check out the links below if you want to learn more.
     * Learn more about scanners: <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html">...</a>.
* Learn more about regular expressions <a href="https://en.wikipedia.org/wiki/Regular_expression">...</a>
*
     * @return a scanner for parsing regular text
     *
* @throws FileNotFoundException
* @param pathname
*/
    public static Scanner scannerForNaturalLanguage(String pathname) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathname));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
        return s;
    }
    public static Scanner scannerForCode(String pathname) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathname));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|\\d|\\.|&|,|=|\\*|\\+|%|/|\\||<|>|@|-|;|\\{|\\(|\\)|}|]|\\[|\\?|!|:|'|\")+"); // se handledning
        return s;
    }
}
