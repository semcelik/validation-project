package com.semih.validation.enforcer.rule;

import com.semih.validation.operators.Context;
import com.semih.validation.operators.YamlValidator;
import java.io.File;
import org.apache.maven.enforcer.rule.api.EnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.enforcer.rule.api.EnforcerRuleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YamlRule implements EnforcerRule {

  private static final Logger LOG = LoggerFactory.getLogger(YamlRule.class);

  private String fileNameWithPath;

  public void execute(EnforcerRuleHelper helper) throws EnforcerRuleException {
    File f = new File(fileNameWithPath);
    Context context = new Context(new YamlValidator());
    if (f.exists()) {
      context.executeValidator(f.getAbsolutePath());
    } else {
      LOG.info("File: " + f.getAbsolutePath() + "\n");
      LOG.error("##File Not Found!\n");
    }
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
