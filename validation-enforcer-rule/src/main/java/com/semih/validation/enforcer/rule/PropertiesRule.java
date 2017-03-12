package com.semih.validation.enforcer.rule;

import com.semih.validation.operators.Context;
import com.semih.validation.operators.PropertiesValidator;
import java.io.File;
import org.apache.maven.enforcer.rule.api.EnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.enforcer.rule.api.EnforcerRuleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesRule implements EnforcerRule {

  private final static Logger LOG = LoggerFactory.getLogger(PropertiesRule.class);

  private String fileNameWithPath;

  public void execute(EnforcerRuleHelper helper) throws EnforcerRuleException {

    LOG.info("########################################");

    File f = new File(fileNameWithPath);
    Context context = new Context(new PropertiesValidator());

    if (f.exists()) {
      context.executeValidator(f.getAbsolutePath());
    } else {
      LOG.info("File: " + f.getAbsolutePath() + "\n");
      LOG.error("##File Not Found!\n");
    }

    LOG.info("########################################");
  }

  public boolean isCacheable() {
    return false;
  }

  public boolean isResultValid(EnforcerRule cachedRule) {
    return false;
  }

  public String getCacheId() {
    return null;
  }
}
