package plugin;/*
 * Created by semcelik on 03.03.2017.
 */

import java.io.File;
import java.io.FilenameFilter;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class YamlGoalTest extends TestCase{

  @Test
  public void testFiles() {
    File file = new File("src\\test\\resources\\yaml\\");
    File[] yamlFiles = file.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".yml");
      }
    });
    assert yamlFiles != null;
    assertNotEquals(yamlFiles.length, 0);
  }
}
