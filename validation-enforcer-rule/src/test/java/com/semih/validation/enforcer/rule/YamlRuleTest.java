package com.semih.validation.enforcer.rule;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YamlRuleTest {

  private String fileNameWithPath;

  private String noFileName;

  private String wrongFileName;

  @Before
  public void setUp() {
    fileNameWithPath = "..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
    noFileName = "..\\validation-samples\\src\\test\\resources\\yaml\\-";
    wrongFileName = "..\\validation-samples\\src\\test\\resources\\yaml\\wrongsample";
  }

  @Test
  public void testWithPath() throws FileNotFoundException {
    File file = new File(fileNameWithPath);
    if (!file.exists()) {
      System.out.println(file.getAbsoluteFile());
      throw new FileNotFoundException();
    }
  }

  @Test(expected = AssertionError.class)
  public void testWrongInput() {
    Assert.assertTrue(new File(noFileName).exists());
    Assert.assertTrue(new File(wrongFileName).exists());
  }
}
