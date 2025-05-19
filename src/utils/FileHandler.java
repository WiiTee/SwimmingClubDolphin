package utils;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Sets up a file in the 'data' subdirectory of the current working directory.
     * <p>
     * This method constructs the full path to the specified file within a 'data' subdirectory
     * of the application's current working directory. It attempts to create the file
     * if it does not already exist. Note that this method does not create parent directories
     * and will fail if the 'data' directory does not exist.
     * </p>
     *
     * @param fileName the name of the file to be created or verified in the data directory
     *                 (e.g., "config.txt").
     * @return The absolute filesystem path to the specified file as a String.
     * @throws RuntimeException if an I/O error occurs during file creation, including cases
     *         where parent directories are missing or permissions are insufficient.
     */
    public String fileIOSetup(String fileName) {
        // Get the current working directory of the application
        String path = System.getProperty("user.dir");

        // Construct the full path to the target file in the data subdirectory
        // Use static constant "File.separator" to ensure cross-platform compatibility
        String dataDir = path + File.separator + "data"+ File.separator + fileName;

        // Create a File object representing the target file
        File yourFile = new File(dataDir);

        try {
            // Attempt to create the file if it doesn't exist
            // This is a no-op if the file already exists
            yourFile.createNewFile();
        } catch (IOException e) {
            // Convert checked exception to runtime exception with context
            throw new RuntimeException("Failed to initialize file: " + dataDir, e);
        }

        // Return the full path to the created/verified file
        return dataDir;
    }

    /**
     * Reads and parses a CSV file from the application's data directory.
     * <p>
     * This method reads a comma-separated values (CSV) file line by line, splitting each line
     * into String values using commas as delimiters. The results are returned as a list of
     * lists where each inner list represents a line from the file.
     * </p>
     *
     * <p><strong>Format Note:</strong> This basic implementation assumes simple CSV formatting:
     * <ul>
     *   <li>Does not handle quoted values containing commas</li>
     *   <li>Does not support escape characters</li>
     *   <li>Trims no whitespace from values</li>
     * </ul>
     * </p>
     *
     * @param fileName name of the CSV file in the data directory (e.g., "data.csv")
     * @return ArrayList containing List<String> elements for each line of parsed data
     * @throws RuntimeException if there's any error reading the file, including:
     *         <ul>
     *           <li>Missing file (despite creation attempt)</li>
     *           <li>Insufficient permissions</li>
     *           <li>Malformed path</li>
     *         </ul>
     */
    public ArrayList<String[]> load(String fileName) {
        // Verify/Create file and get full path using fileIOSetup utility
        String dataDir = fileIOSetup(fileName);

        // Initialize collection to store parsed records
        ArrayList<String[]> records = new ArrayList<>();

        // Try-with-resources ensures BufferedReader is auto-closed
        try (BufferedReader br = new BufferedReader(new FileReader(dataDir))) {
            String line;

            // Read file line by line until null (EOF)
            while ((line = br.readLine()) != null) {
                // Split line into string array using comma delimiter
                String[] values = line.split(",");
                // Convert array to List and add to records collection
                records.add(values);
            }
        } catch (IOException e) {
            // Wrap checked exception with context about failure
            throw new RuntimeException("Failed to load file: " + dataDir, e);
        }

        return records;
    }

    /**
     * Appends records to a file in the data directory in CSV-like format.
     * <p>
     * This method writes each object's string representation (via toString()) to the target file,
     * appending a newline before each record. The file is opened in append mode - existing content
     * is preserved and new records are added at the end.
     * </p>
     *
     * <p><strong>Format Notes:</strong>
     * <ul>
     *   <li>Creates a de facto CSV format using toString() outputs</li>
     *   <li>Adds a leading newline before each record (may create empty first line)</li>
     *   <li>Does not perform any data validation or escaping</li>
     * </ul>
     * </p>
     *
     * @param records ArrayList of objects to be written (uses toString() conversion)
     * @param fileName name of the target file in data directory (e.g., "output.csv")
     * @throws RuntimeException if any I/O error occurs, including:
     *         <ul>
     *           <li>Insufficient file permissions</li>
     *           <li>Missing parent directory</li>
     *           <li>Disk full condition</li>
     *         </ul>
     */
    public void save(ArrayList<String[]> records, String fileName) {
        // Get verified file path using fileIOSetup utility
        String dataDir = fileIOSetup(fileName);

        try {
            // Create writer with append mode enabled (preserves existing content)
            BufferedWriter writer = new BufferedWriter(new FileWriter(dataDir, true));

            // Write each record with leading newline
            for (String[] record : records) {
                // Convert object to string and prepend newline
                writer.append("\n").append(String.join(",",record));
            }

            // Explicitly close writer to flush buffers
            writer.close();
        } catch (IOException e) {
            // Wrap exception with context about failure
            throw new RuntimeException("Failed to save to file: " + dataDir, e);
        }
    }
}


/*
READ EXAMPLE USAGE:

    FileHandler db = new FileHandler();
    String data_dir = "FileHandler.csv";
    ArrayList<Object> out = db.load(data_dir);


WRITE EXAMPLE USAGE:

    ArrayList<Object> records = new ArrayList<>();

    ArrayList<Object> record = new ArrayList<>();
    record.add("Peter");
    record.add(56);
    record.add("male");
    record.add("DAD");

    records.add(record);

    ArrayList<Object> record2 = new ArrayList<>();
    record2.add("Lois");
    record2.add(36);
    record2.add("female");
    record2.add("MOM");

    records.add(record2);

    System.out.println(records);
    db.save(records, "FileHandler.csv");

*/