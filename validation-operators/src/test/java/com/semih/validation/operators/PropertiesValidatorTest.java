package com.semih.validation.operators;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class PropertiesValidatorTest {

  private String filePath;

  @Before
  public void setUp() {
    filePath = "\\..\\validation-samples\\src\\test\\resources\\properties\\sample.properties";
  }

  @Test
  public void testValidate() throws FileNotFoundException {
    File file = new File(System.getProperty("user.dir") + filePath);
    PropertiesValidator propertiesValidator = new PropertiesValidator();
    if (!file.exists()) {
      throw new FileNotFoundException();
    }
    propertiesValidator.validate(file.getAbsolutePath());
  }
}