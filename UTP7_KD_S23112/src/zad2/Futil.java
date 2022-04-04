package zad2;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {


public static void processDir(String dirName, String resultFileName) {
    Path startDir = Paths.get(dirName);
    StringBuilder sb = new StringBuilder();

    try {
        Files.walkFileTree(startDir, new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                for(String line : Files.readAllLines(file, Charset.forName("Cp1250"))){
                   sb.append(line);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
    Path dest = Paths.get(resultFileName);
    String result = sb.toString();
    try {
        Files.write(dest, result.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
