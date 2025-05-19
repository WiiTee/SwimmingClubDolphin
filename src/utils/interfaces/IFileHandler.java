package utils.interfaces;

import java.util.ArrayList;

public interface IFileHandler {
    public void save(ArrayList<String[]> records, String fileName);
    public ArrayList<String[]> load(String fileName);
}
