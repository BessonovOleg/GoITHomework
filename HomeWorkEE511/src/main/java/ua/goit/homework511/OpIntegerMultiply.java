package ua.goit.homework511;

import ua.goit.homework51.AbstractOperation;
import ua.goit.homework51.Calculator;


public class OpIntegerMultiply extends AbstractOperation {
    public String calc(Object var1, Object var2) {
        return String.valueOf(Integer.valueOf(var1.toString()) * Integer.valueOf(var2.toString()));
    }

    public OpIntegerMultiply(){
        super(Calculator.ADD_INTEGER,"*");
    }

}
