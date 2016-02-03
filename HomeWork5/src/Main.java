/**
 * Created by user on 02.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        int [] testArray = {1,4,5,8,6,10,23,14,15};

        System.out.println("Min value is " + ArrayMinMaxFind.getMinValue(testArray));
        System.out.println("Max value is " + ArrayMinMaxFind.getMaxValue(testArray));


        System.out.println("Array before sort");
        for(int i = 0;i< testArray.length;i++ ){
            System.out.println(testArray[i]);
        }

        ArrayMinMaxFind.sortArray(testArray);

        System.out.println("Array after sort");
        for(int i = 0;i< testArray.length;i++ ){
            System.out.println(testArray[i]);
        }




    }
}
