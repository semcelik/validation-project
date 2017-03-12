package com.semih.validation.operators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesValidator implements Validatable {

  private static final Logger LOG = LoggerFactory.getLogger(PropertiesValidator.class);

  private static final String PATTERN = "^[a-zA-Z]+[\\s\\S]+(=|:)[\\s]*\\s*\\S+";

  private static final String COMMENT = "^[#!]";

  public void validate(String file) {

    LOG.info("File: " + file + "\n");
    String line;
    Pattern pattern = Pattern.compile(PATTERN);
    Pattern comment = Pattern.compile(COMMENT);
    Matcher matcher;
    Matcher commentMatcher;
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      int counter = 0;
      while (line != null) {
        while (line.endsWith("\\")) {
          line = line + br.readLine();
        }
        matcher = pattern.matcher(line);
        commentMatcher = comment.matcher(line);
        if (!matcher.find() && !commentMatcher.find() && !line.matches("")) {
          LOG.warn("WRONG SYNTAX FOUND: " + line);
          counter++;
        }
        line = br.readLine();
      }
      if (counter == 0) {
        LOG.info("TRUE SYNTAX");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
