package com.semih.validation.operators;

public class Context {

  private Validatable validator;

  public Context(Validatable validator) {
    this.validator = validator;
  }

  public void executeValidator(String file) {
    validator.validate(file);
  }
}
