package zad1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Futil {

    public static void processDir(String dirName, String resultFileName) {
        Path startDir = Paths.get(dirName);
        StringBuilder sb = new StringBuilder();


        try {
            Files.walk(startDir)
                    .filter(Files::isRegularFile)
                    .map(path -> {
                        try {
                            return Files.lines(path, Charset.forName("Cp1250")).reduce("", (s1, s2)-> s1 + s2);
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                    })
                    .forEach(s->sb.append(s));
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


        System.out.println(sb);
    }




}
