package validation;/*
 * Created by semcelik on 10.03.2017.
 */

public class Context {

  private ValidatorImpl validator;

  public Context(ValidatorImpl validator) {
    this.validator = validator;
  }

  public void executeValidator(String file) {
    validator.validate(file);
  }
}
