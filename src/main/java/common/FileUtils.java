package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

  public static String[] readLines(String fileName) {

    //read file into stream
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

      // cannot return stream directly, as streams can only be consumed once.
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
