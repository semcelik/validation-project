package validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesValidator implements ValidatorImpl {

  private static final Logger log = LoggerFactory.getLogger(PropertiesValidator.class);

  private final String PATTERN = "^[a-zA-Z]+[\\s\\S]+(=|:)[\\s]*\\s*\\S+";

  private final String COMMENT = "^[#!]";

  private int counter = 0;

  public void validate(String file) {

    log.info("File: " + file + "\n");
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

        while (line.endsWith("\\")) {
          line = line + br.readLine();
        }
        matcher = pattern.matcher(line);
        commentMatcher = comment.matcher(line);
        if (!matcher.find() && !commentMatcher.find() && !line.matches("")) {
          log.warn("WRONG SYNTAX FOUND: " + line);
          counter++;
        }
        line = br.readLine();
      }
      if (counter == 0) {
        log.info("TRUE SYNTAX");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
