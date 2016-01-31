package part2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.01.2016.
 */
public class BouquetOfFlowers {
    private List<Flower> items;

    public BouquetOfFlowers(Flower item) {
        items = new ArrayList<Flower>();
        items.add(item);
    }

    public void addFlower(Flower flower){
        items.add(flower);
    }
}
