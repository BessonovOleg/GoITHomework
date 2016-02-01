package part1;

/**
 * Created by etalon on 01.02.16.
 */
public class AreaCalculator {

    public double areaCircle(double radius){
        return Math.PI * Math.pow(radius,2);
    }

    public double areaTriangle(double height,double lengthBase){
        if(lengthBase != 0 && height !=0)
        {
            return height*lengthBase/2;
        }else
        {
            return -1;
        }
    }

    public double areaRectangle(double width,double height){
        return height * width;
    }

}
