import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import utils.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    private final String fileName = "testFileHandler.txt";
    private final String[] mockRecord = new String[]{"id", "name"};
    private Path tempDir;
    private String originalUserDir;

    @BeforeEach
    void setUp(@TempDir Path tempDir) {
        this.tempDir = tempDir;
        originalUserDir = System.getProperty("user.dir");
        System.setProperty("user.dir", tempDir.toString());

        // Create the data directory
        try {
            Files.createDirectories(tempDir.resolve("data"));
        } catch (IOException e) {
            throw new RuntimeException("Could not create data directory", e);
        }
    }

    @AfterEach
    void tearDown() {
        System.setProperty("user.dir", originalUserDir);
    }

    @Test
    void testFileIOSetupCreatesFile() {
        FileHandler fileHandler = new FileHandler();
        String filePath = fileHandler.fileIOSetup(fileName);

        Path expectedPath = tempDir.resolve("data").resolve(fileName);
        assertEquals(expectedPath.toString(), filePath);
        assertTrue(Files.exists(expectedPath));
    }

    @Test
    void testSave(){
        var fh = new FileHandler();
//        var mockOut = new ArrayList<String[]>();
//        String[] mockOut =  mockRecord.clone();
////        var mockOut = String[];
//        System.out.println(Arrays.toString(mockRecord));
//        mockOut.add(mockRecord);
        fh.save(mockRecord,fileName,true);
    }

  @Test
  void testLoad() {
      var fh = new FileHandler();
      var out = fh.load(fileName);
//      System.out.println(out);
      Object[] expectedOut =  new Object[]{};
      assertArrayEquals(expectedOut, out.toArray());
  }
}