package com.semih.validation.enforcer.rule;

import com.semih.validation.operators.Context;
import com.semih.validation.operators.YamlValidator;
import java.io.File;
import java.io.FilenameFilter;
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
      if (fileNameWithPath.matches("[\\w\\S]+(\\\\yaml\\\\-)")) {
        LOG.info("------------------------------------------------------------------------");
        LOG.warn("-DfileName PARAMETER NOT FOUND! DISPLAYING ALL .yml FILE VALIDATIONS.");
        LOG.info("------------------------------------------------------------------------");
        fileNameWithPath = fileNameWithPath.substring(0, fileNameWithPath.length() - 1);
        f = new File(fileNameWithPath);
        File[] files = f.listFiles(new FilenameFilter() {
          public boolean accept(File dir, String name) {
            return name.endsWith(".yml");
          }
        });
        for (File temp : files != null ? files : new File[0]) {
          context.executeValidator(temp.getAbsolutePath());
          LOG.info("------------------------------------------------------------------------");
        }
      } else {
        LOG.info("File: " + f.getAbsolutePath());
        LOG.error("##File Not Found!");
      }
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
