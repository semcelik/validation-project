package com.semih.validation.enforcer.rule;

import com.semih.validation.enforcer.rule.YamlRule;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YamlRuleTest {

  private String fileNameWithPath;

  private String noFileName;

  private String wrongFileName;

  private File file;

  @Before
  public void setUp() {
    fileNameWithPath = "..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
    noFileName = "..\\validation-samples\\src\\test\\resources\\yaml\\-";
    wrongFileName = "..\\validation-samples\\src\\test\\resources\\yaml\\wrongsample";
  }

  @Test
  public void objectTest() {
    YamlRule yamlRule = new YamlRule();
    Assert.assertNotNull(yamlRule);
  }

  @Test
  public void withPathTest() throws FileNotFoundException {
    file = new File(fileNameWithPath);
    if (!file.exists()) {
      System.out.println(file.getAbsoluteFile());
      throw new FileNotFoundException();
    }
  }

  @Test
  public void wrongInputTest() {
    Assert.assertTrue(!new File(noFileName).exists());
    Assert.assertTrue(!new File(wrongFileName).exists());
  }
}
