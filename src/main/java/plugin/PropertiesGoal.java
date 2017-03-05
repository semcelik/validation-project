package plugin;
/*
 * Created by semcelik on 24.02.2017.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import validation.PropertiesValidator;

@Mojo(name = "properties")
public class PropertiesGoal extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    System.out.println("########################################");
    PropertiesValidator propertiesValidator = new PropertiesValidator();
    propertiesValidator.validate("src\\test\\resources\\properties\\config.properties");
    System.out.println("########################################");
  }
}
