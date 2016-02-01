package part1;

/**
 * Created by etalon on 01.02.16.
 */
public class TemperatureConverter {
    public double convertFtoC(double degreeF){
        return (degreeF-32)/1.8;
    }

    public double convertCtoF(double degreeC){
        return (degreeC*1.8)+32;
    }
}
