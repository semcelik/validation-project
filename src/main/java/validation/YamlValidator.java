package validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

public class YamlValidator implements ValidatorImpl {

  public void validate(String file) {
    File f = new File(file);
    System.out.println("File: " + file + "\n");
    Yaml yml = new Yaml();
    try {
      InputStream inputStream = new FileInputStream(f);
      yml.load(inputStream);
      System.out.println("### TRUE SYNTAX ###");
    } catch (Exception e) {
      System.out.println("### WRONG SYNTAX ###");
      System.out.println(e.getMessage());
    }
  }
}
