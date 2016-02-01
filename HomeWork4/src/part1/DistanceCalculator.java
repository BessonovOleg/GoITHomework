package part1;

/**
 * Created by user on 01.02.2016.
 */
public class DistanceCalculator {

    public double distanceCalc(int x1,int y1,int x2,int y2){
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }

}