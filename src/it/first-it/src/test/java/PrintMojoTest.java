import junit.framework.TestCase;

import org.junit.Test;

public class PrintMojoTest extends TestCase {

  @Test
  public void testMojo() {
    PrintMojo printMojo = new PrintMojo();
    assertNotNull(printMojo);
  }
}
