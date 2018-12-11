package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

  public static String[] ReadLines(String fileName) {

    //read file into stream, try-with-resources
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

      return stream.toArray(String[]::new);

    } catch (IOException e) {
      e.printStackTrace();
      return new String[0];
    }
  }

  public static void pwd() {
    System.out.println(System.getProperty("user.dir"));
  }
}
