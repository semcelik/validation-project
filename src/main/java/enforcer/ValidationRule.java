package enforcer;

import java.io.File;
import org.apache.maven.enforcer.rule.api.EnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.enforcer.rule.api.EnforcerRuleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import validation.PropertiesValidator;

public class ValidationRule implements EnforcerRule {

  private final static Logger log = LoggerFactory.getLogger(ValidationRule.class);

  private String fileName;

  private String fileNameWithPath;

  public void execute(EnforcerRuleHelper helper) throws EnforcerRuleException {

    log.info("########################################\n");

    File f = new File("src\\test\\resources\\properties\\" + fileName);
    PropertiesValidator propertiesValidator = new PropertiesValidator();

    if (f.exists()) {
      propertiesValidator.validate(f.getAbsolutePath());
    } else {
      f = new File(fileNameWithPath);
      if (f.exists()) {
        propertiesValidator.validate(f.getAbsolutePath());
      } else {
        log.info("File: " + f.getAbsolutePath() + "\n");
        log.warn("##File Not Found!\n");
      }
    }

    log.info("########################################");
  }

  public boolean isCacheable() {
    return false;
  }

  public boolean isResultValid(EnforcerRule cachedRule) {
    return false;
  }

  public String getCacheId() {
    return this.fileName;
  }
}
