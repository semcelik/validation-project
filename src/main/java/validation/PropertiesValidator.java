package validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesValidator implements IValidator {

  private final String PATTERN = "^[a-zA-Z]+[a-zA-Z_0-9\\s]+=[\\s]*[a-zA-Z0-9]+";

  private final String COMMENT = "^[#]";

  private int counter = 0;

  private String file = null;

  public void validate(String file) {

    System.out.println("File: " + file + "\n");
    this.file = file;
    String line;
    Pattern pattern = Pattern.compile(PATTERN);
    Pattern comment = Pattern.compile(COMMENT);
    Matcher matcher;
    Matcher commentMatcher;
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while (line != null) {
        matcher = pattern.matcher(line);
        commentMatcher = comment.matcher(line);
        if (!matcher.find() && !commentMatcher.find()) {
          System.out.println("WRONG SYNTAX FOUND: " + line);
          counter++;
        }

        line = br.readLine();
      }
      if (counter == 0) {
        System.out.println("TRUE SYNTAX");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void printFile() {
    String line;

    FileReader fr = null;
    try {
      fr = new FileReader(file);

      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
