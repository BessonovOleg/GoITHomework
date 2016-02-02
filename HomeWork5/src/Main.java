/**
 * Created by user on 02.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        int [] testArray = {1,4,5,8,6,10,23,14,15};

        ArrayMinMaxFind ar = new ArrayMinMaxFind(testArray);

        System.out.println("Min value is " + ar.getMinValue());
        System.out.print("Max value is " + ar.getMaxValue());

    }
}
