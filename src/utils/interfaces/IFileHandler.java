package utils.interfaces;

import java.util.ArrayList;

public interface IFileHandler {
    public void save(String[] records, String fileName, boolean append);
    public ArrayList<String[]> load(String fileName);
}
