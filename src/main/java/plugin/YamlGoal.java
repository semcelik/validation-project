package plugin;/*
 * Created by semcelik on 24.02.2017.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import validation.YamlValidator;

@Mojo(name = "yaml")
public class YamlGoal extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    System.out.println("########################################");
    YamlValidator yamlValidator = new YamlValidator();
    yamlValidator.validate("sample.yml");
    System.out.println("########################################");
  }
}
