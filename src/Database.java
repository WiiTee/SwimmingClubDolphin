package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    public ArrayList<Object> read(String fileName) throws IOException {

        String path = System.getProperty("user.dir");
        String data_dir = path+"\\data\\"+fileName;
        File yourFile = new File(data_dir);
        try {
            yourFile.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            throw new RuntimeException(e);
        };

        ArrayList<Object> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(data_dir))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;

    }

    public void write(ArrayList<Object> records, String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        String data_dir = path+"\\data\\"+fileName;
        File yourFile = new File(data_dir);
        try {
            yourFile.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            throw new RuntimeException(e);
        };

        BufferedWriter writer = new BufferedWriter(new FileWriter(data_dir, true));
        for (Object record : records) {
            writer.append("\n").append(record.toString());
        }

        writer.close();
    }
}


/*
READ EXAMPLE USAGE:

    Database db = new Database();
    String data_dir = "Database.csv";
    ArrayList<Object> out = db.read(data_dir);


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
    db.write(records, "Database.csv");

*/