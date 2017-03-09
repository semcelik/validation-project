package plugin;

import java.io.File;
import java.io.FilenameFilter;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PropertiesGoalTest {

  @Test
  public void testFiles() {
    File f = new File("src\\test\\resources\\properties\\");
    File[] propertiesFiles = f.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".properties");
      }
    });
    assert propertiesFiles != null;
    assertNotEquals(propertiesFiles.length, 0);
  }
}
