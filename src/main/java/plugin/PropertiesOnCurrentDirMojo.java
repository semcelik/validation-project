package plugin;

import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import validation.PropertiesValidator;

@Mojo(name = "propOnCurrentDir", requiresProject = false)
public class PropertiesOnCurrentDirMojo extends AbstractMojo {

  private final static Logger log = LoggerFactory.getLogger(PropertiesOnCurrentDirMojo.class);

  public void execute() throws MojoExecutionException, MojoFailureException {
    File file = new File(".");
    File[] propertiesFiles = file.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".properties");
      }
    });
    log.info("########################################");
    if (propertiesFiles.length > 0) {
      for (File countFile : propertiesFiles) {
        PropertiesValidator propertiesValidator = new PropertiesValidator();
        propertiesValidator.validate(countFile.getAbsolutePath());
        log.info("\n-------------------------");
      }
      log.info(propertiesFiles.length + " ####");
    } else {
      log.error(".properties file not found");
    }
    log.info("########################################");
  }
}
