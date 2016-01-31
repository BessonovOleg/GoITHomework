package part2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.01.2016.
 */
public class RoseBush {
    private List<Rose> items;

    public RoseBush(Rose item) {
        items = new ArrayList<Rose>();
        items.add(item);
    }
}
