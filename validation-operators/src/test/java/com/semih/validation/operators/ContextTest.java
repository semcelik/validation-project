package com.semih.validation.operators;

import org.junit.Before;
import org.junit.Test;

public class ContextTest {

  private String propertiesFilePath;

  private String yamlFilePath;

  @Before
  public void setUp() {
    propertiesFilePath = "\\..\\validation-samples\\src\\test\\resources\\properties\\sample.properties";
    yamlFilePath = "\\..\\validation-samples\\src\\test\\resources\\yaml\\sample.yml";
  }

  @Test
  public void testExecuteValidator() {
    Context contextProperties = new Context(new PropertiesValidator());
    Context contextYaml = new Context(new YamlValidator());
    contextProperties.executeValidator(System.getProperty("user.dir") + propertiesFilePath);
    contextYaml.executeValidator(System.getProperty("user.dir") + yamlFilePath);
  }
}
