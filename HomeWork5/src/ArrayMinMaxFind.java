/**
 * Created by user on 02.02.2016.
 */
public class ArrayMinMaxFind {

    private int[] array;

    public ArrayMinMaxFind(int[] ar ){
        this.array = ar;
    }

    public int getMaxValue(){
        int tmpVar = array[0];

        for(int var:array){
            if(var>tmpVar){
                tmpVar = var;
            }
        }

        return tmpVar;
    }


    public int getMinValue(){
        int tmpVar = array[0];

        for(int var:array){
            if(var<tmpVar){
                tmpVar = var;
            }
        }

        return tmpVar;
    }


}
