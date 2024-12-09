package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StopWordParserTest {
    @Test
    @DisplayName("it finds no words in an empty file")
    void findsNoWordsInEmptyFile() throws FileNotFoundException {
        String[] words = StopWordParser.parse("test_data/empty.txt");
        assertEquals(0, words.length);
    }
    @Test
    @DisplayName("it finds nils twice in nils")
    void findsNilsTwiceInNils() throws FileNotFoundException {
        String[] words = StopWordParser.parse("test_data/nils.txt");
        assertEquals(2, words.length);
    }

}