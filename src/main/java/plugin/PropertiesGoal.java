package plugin;

import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import validation.Context;
import validation.PropertiesValidator;

@Mojo(name = "properties")
public class PropertiesGoal extends AbstractMojo {

  private final static Logger log = LoggerFactory.getLogger(PropertiesGoal.class);

  public void execute() throws MojoExecutionException, MojoFailureException {
    Context context = new Context(new PropertiesValidator());
    log.info("########################################");
    File f = new File("src\\test\\resources\\properties\\");
    File[] propertiesFiles = f.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".properties");
      }
    });
    for (File countFile : propertiesFiles) {
      context.executeValidator(countFile.getAbsolutePath());
      log.info("\n-------------------------");
    }
    log.info("########################################");
  }
}
