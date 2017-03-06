package plugin;/*
 * Created by semcelik on 27.02.2017.
 */

import java.io.File;
import java.io.FilenameFilter;
import org.junit.Test;
import validation.PropertiesValidator;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class PropertiesGoalTest {

  @Test
  public void getFiles() {
    File f = new File("src\\test\\resources\\properties\\");
    File[] propertiesFiles = f.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".properties");
      }
    });
    PropertiesValidator propertiesValidator = new PropertiesValidator();
    for (File countFile : propertiesFiles) {
      propertiesValidator.validate(countFile.getAbsolutePath());
    }
    assertNotNull(propertiesFiles);
    assertNotNull(f);
  }
}
