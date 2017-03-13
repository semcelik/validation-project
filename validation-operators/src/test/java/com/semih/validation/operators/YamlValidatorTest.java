package com.semih.validation.operators;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class YamlValidatorTest {

  private String filePath;

  private File file;

  private YamlValidator yamlValidator;

  @Before
  public void setUp() {
    filePath = "\\..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
  }

  @Test
  public void withPathTest() throws FileNotFoundException {
    file = new File(System.getProperty("user.dir") + filePath);
    yamlValidator = new YamlValidator();
    if (!file.exists()) {
      throw new FileNotFoundException();
    }
    yamlValidator.validate(file.getAbsolutePath());
  }
}
