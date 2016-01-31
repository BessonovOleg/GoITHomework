package part1;

import java.util.ArrayList;

/**
 * Created by user on 30.01.2016.
 */
public class Directory {
    private ArrayList<File> listFiles;

    public Directory() {
        listFiles = new ArrayList<File>();
    }

    public ArrayList<File> getListFiles() {
        return listFiles;
    }

    public void addFile(File file) {
        listFiles.add(file);
    }
}
