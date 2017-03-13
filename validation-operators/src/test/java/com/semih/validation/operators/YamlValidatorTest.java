package com.semih.validation.operators;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class YamlValidatorTest {

  private String filePath;

  @Before
  public void setUp() {
    filePath = "\\..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
  }

  @Test
  public void testValidate() throws FileNotFoundException {
    File file = new File(System.getProperty("user.dir") + filePath);
    YamlValidator yamlValidator = new YamlValidator();
    if (!file.exists()) {
      throw new FileNotFoundException();
    }
    yamlValidator.validate(file.getAbsolutePath());
  }
}
