package ua.goit.homework511;

import ua.goit.homework51.AbstractOperation;
import ua.goit.homework51.Calculator;

public class OpLongMultiply extends AbstractOperation {
    public String calc(Object var1, Object var2) {
        return String.valueOf(Long.valueOf(var1.toString()) * Long.valueOf(var2.toString()));
    }

    public OpLongMultiply(){
        super(Calculator.ADD_LONG,"*");
    }
}
