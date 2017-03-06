package plugin;/*
 * Created by semcelik on 27.02.2017.
 */

import java.io.File;
import java.io.FilenameFilter;
import junit.framework.TestCase;
import org.junit.Test;
import validation.PropertiesValidator;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class PropertiesGoalTest extends TestCase {

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
