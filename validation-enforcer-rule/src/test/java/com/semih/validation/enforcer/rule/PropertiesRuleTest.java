package com.semih.validation.enforcer.rule;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertiesRuleTest {

  private String fileNameWithPath;

  private String noFileName;

  private String wrongFileName;

  @Before
  public void setUp() {
    fileNameWithPath = "..\\validation-samples\\src\\test\\resources\\properties\\sample.properties";
    noFileName = "..\\validation-samples\\src\\test\\resources\\properties\\-";
    wrongFileName = "..\\validation-samples\\src\\test\\resources\\properties\\wrongsample";
  }

  @Test
  public void withPathTest() throws FileNotFoundException {
    File file = new File(fileNameWithPath);
    if (!file.exists()) {
      throw new FileNotFoundException();
    }
  }

  @Test(expected = AssertionError.class)
  public void wrongInputTest() {
    Assert.assertTrue(new File(noFileName).exists());
    Assert.assertTrue(new File(wrongFileName).exists());
  }
}
