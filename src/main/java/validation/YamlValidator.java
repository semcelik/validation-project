package validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class YamlValidator implements ValidatorImpl {

  private static final Logger log = LoggerFactory.getLogger(YamlValidator.class);

  public void validate(String file) {
    File f = new File(file);
    log.info("File: " + file + "\n");
    Yaml yml = new Yaml();
    try {
      InputStream inputStream = new FileInputStream(f);
      yml.load(inputStream);
      log.info("### TRUE SYNTAX ###");
    } catch (Exception e) {
      log.warn("### WRONG SYNTAX ###");
      log.warn(e.getMessage());
    }
  }
}
