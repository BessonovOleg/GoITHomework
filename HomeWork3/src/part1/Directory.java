package part1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.01.2016.
 */
public class Directory extends File{
    private List<File> listFiles;

    public Directory() {
        listFiles = new ArrayList<File>();
    }

    public List<File> getListFiles() {
        return listFiles;
    }

    public void addFile(File file) {
        listFiles.add(file);
    }
}
