package source_merger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SourceFileFinder {
    public List<String> findSourceFiles(String path) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(path))) {
            List<String> files = new ArrayList<>();
            stream.filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith("java"))
                    .forEach(file -> files.add(file.toString()));
            return files;
        }
    }
}
