package ua.goit.homework511;

import ua.goit.homework51.AbstractOperation;
import ua.goit.homework51.Calculator;

public class OpDoubleMultiply extends AbstractOperation{
    public String calc(Object var1, Object var2) {
        return String.valueOf(Double.valueOf(var1.toString()) * Double.valueOf(var2.toString()));
    }

    public OpDoubleMultiply() {
        super(Calculator.ADD_DOUBLE, "*");
    }
}
