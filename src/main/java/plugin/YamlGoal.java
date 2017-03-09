package plugin;

import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import validation.YamlValidator;

@Mojo(name = "yaml")
public class YamlGoal extends AbstractMojo {

  private final static Logger log = LoggerFactory.getLogger(YamlGoal.class);

  public void execute() throws MojoExecutionException, MojoFailureException {
    log.info("########################################");
    File file = new File("src\\test\\resources\\yaml\\");
    File[] yamlFiles = file.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".yml");
      }
    });
    for (File countYaml : yamlFiles) {
      YamlValidator yamlValidator = new YamlValidator();
      yamlValidator.validate(countYaml.getAbsolutePath());
      log.info("\n-------------------------");
    }
    log.info("########################################");
  }
}
