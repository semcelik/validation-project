package plugin;
/*
 * Created by semcelik on 24.02.2017.
 */

import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import validation.PropertiesValidator;

@Mojo(name = "properties")
public class PropertiesGoal extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {

    System.out.println("########################################");
    File f = new File("src\\test\\resources\\properties\\");
    File[] propertiesFiles = f.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".properties");
      }
    });
    for (File countFile : propertiesFiles) {
      PropertiesValidator propertiesValidator = new PropertiesValidator();
      propertiesValidator.validate(countFile.getAbsolutePath());
      System.out.println("\n-------------------------");
    }
    System.out.println("########################################");
  }
}
