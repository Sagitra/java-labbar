package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleWordCounterTest {

    @Test
    void findNils() {
        String toFind = "Nils";
        String toProcess = "nils";
        TextProcessor processor = new SingleWordCounter( toFind.toLowerCase());
        processor.process(toProcess);
        assertEquals("nils: 1", processor.report());
    }
    @Test
    void findNils2() {
        String toFind = "nils";
        String toProcess = "nils";
        TextProcessor processor = new SingleWordCounter(toFind);
        processor.process(toProcess);
        assertEquals("nils: 1", processor.report());
    }
}