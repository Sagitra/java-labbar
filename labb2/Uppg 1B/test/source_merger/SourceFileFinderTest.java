package source_merger;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class SourceFileFinderTest {

    @Test
    void findSourceFile() throws IOException {
        SourceFileFinder finder = new SourceFileFinder();
        assertEquals(729, finder.findSourceFiles("/Users/ed/Code/Mindustry/core/src/mindustry").size());
    }


}