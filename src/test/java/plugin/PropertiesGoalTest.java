package plugin;/*
 * Created by semcelik on 27.02.2017.
 */

import java.io.File;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class PropertiesGoalTest extends AbstractMojoTestCase {

  /** {@inheritDoc} */
  protected void setUp()
      throws Exception
  {
    // required
    super.setUp();

  }

  /** {@inheritDoc} */
  protected void tearDown()
      throws Exception
  {
    // required
    super.tearDown();

  }

  /**
   * @throws Exception if any
   */
  public void testSomething()
      throws Exception
  {
    File pom = getTestFile( "src/test/resources/unit/project-to-test/pom.xml" );
    assertNotNull( pom );
    assertTrue( pom.exists() );

    PropertiesGoal myMojo = (PropertiesGoal) lookupMojo( "touch", pom );
    assertNotNull( myMojo );
    myMojo.execute();

  }
}
