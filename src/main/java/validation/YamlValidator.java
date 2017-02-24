package validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

public class YamlValidator implements IValidator {

  public void validate(String file) {
    System.out.println("File: " + file + "\n");
    Yaml yml = new Yaml();
    File f = new File(file);
    try {
      InputStream inputStream = new FileInputStream(f);
      yml.load(inputStream);
      System.out.println("### TRUE SYNTAX ###");
    } catch (Exception e) {
      System.out.println("### WRONG SYNTAX ###");
      e.printStackTrace();
    }
  }
}
