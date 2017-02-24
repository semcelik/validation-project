package validation;

public class App {

  public static void main(String[] args) {

    YamlValidator yamlValidator = new YamlValidator();
    yamlValidator.validate("circle.yml");
    PropertiesValidator propertiesValidator = new PropertiesValidator();
    propertiesValidator.validate("config.properties");
  }
}
