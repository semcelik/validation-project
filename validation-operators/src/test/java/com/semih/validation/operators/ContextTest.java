package com.semih.validation.operators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContextTest {

  private String propertiesFilePath;

  private String yamlFilePath;

  private Context contextProperties = new Context(new PropertiesValidator());

  private Context contextYaml = new Context(new YamlValidator());

  @Before
  public void setUp() {
    propertiesFilePath = "\\..\\validation-samples\\src\\test\\resources\\properties\\sample.properties";
    yamlFilePath = "\\..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
  }

  @Test
  public void objectTest() {
    Assert.assertNotNull(contextProperties);
    Assert.assertNotNull(contextYaml);
  }

  @Test
  public void executeContextTest() {
    contextProperties.executeValidator(System.getProperty("user.dir") + propertiesFilePath);
    contextYaml.executeValidator(System.getProperty("user.dir") + yamlFilePath);
  }
}
