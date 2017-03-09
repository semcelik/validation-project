package enforcer.rule;

import org.apache.maven.enforcer.rule.api.EnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.enforcer.rule.api.EnforcerRuleHelper;
import org.apache.maven.plugin.logging.Log;

public class FirstRule implements EnforcerRule {

  private String tempStr;

  public void execute(EnforcerRuleHelper helper) throws EnforcerRuleException {
    Log log = helper.getLog();

    log.info("First Rule");
    log.info(tempStr);
  }

  public boolean isCacheable() {
    return false;
  }

  public boolean isResultValid(EnforcerRule enforcerRule) {
    return false;
  }

  public String getCacheId() {
    return null;
  }
}
