package source_merger;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SourceFileMerger {

    public static void main(String[] args) throws IOException {
        SourceFileFinder finder = new SourceFileFinder();
        List<String> files = finder.findSourceFiles("path/to/source");
        System.out.println(files);
        try(OutputStream out = Files.newOutputStream(Paths.get("input/projectName.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            for (String inFileName : files) {
                Files.copy(Paths.get(inFileName), out);
            }
        }
    }
}
