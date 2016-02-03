/**
 * Created by user on 02.02.2016.
 */
public class ArrayMinMaxFind {

    public static int getMaxValue(int[] array){
        int tmpVar = array[0];

        for(int var:array){
            if(var>tmpVar){
                tmpVar = var;
            }
        }

        return tmpVar;
    }


    public static int getMinValue(int[] array){
        int tmpVar = array[0];

        for(int var:array){
            if(var<tmpVar){
                tmpVar = var;
            }
        }

        return tmpVar;
    }

    public static void sortArray(int[] array){
        int tmpVar;
        boolean isChange = true;

        while (isChange){
            isChange = false;

            for(int counter = 0;counter<array.length-1;counter++){
                if (array[counter]>array[counter+1]){
                    tmpVar = array[counter+1];
                    array[counter+1] = array[counter];
                    array[counter] = tmpVar;
                    isChange = true;
                }
            }

        }

    }

}
