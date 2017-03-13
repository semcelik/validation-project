package com.semih.validation.operators;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class YamlValidator implements Validatable {

  private static final Logger LOG = LoggerFactory.getLogger(YamlValidator.class);

  public void validate(String file) {
    File f = new File(file);
    LOG.info("File: " + file);
    Yaml yml = new Yaml();
    try {
      InputStream inputStream = new FileInputStream(f);
      yml.load(inputStream);
      LOG.info("### TRUE SYNTAX ###");
    } catch (Exception e) {
      LOG.warn("### WRONG SYNTAX ###");
      LOG.warn(e.getMessage());
    }
  }
}
