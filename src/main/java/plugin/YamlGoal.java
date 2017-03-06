package plugin;/*
 * Created by semcelik on 24.02.2017.
 */

import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import validation.YamlValidator;

@Mojo(name = "yaml")
public class YamlGoal extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    System.out.println("########################################");
    File file = new File("src\\test\\resources\\yaml\\");
    File[] yamlFiles = file.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".yml");
      }
    });
    for (File countYaml : yamlFiles){
      YamlValidator yamlValidator = new YamlValidator();
      yamlValidator.validate(countYaml.getAbsolutePath());
      System.out.println("\n-------------------------");

    }
    System.out.println("########################################");
  }
}
