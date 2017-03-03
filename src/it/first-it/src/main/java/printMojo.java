import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "print")
public class printMojo extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    getLog().info("######first-it, print goal");
  }
}
