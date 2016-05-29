package ua.goit.homework511;

import ua.goit.homework51.AbstractOperation;
import ua.goit.homework51.Calculator;

public class OpFloatMultiply extends AbstractOperation {
    public String calc(Object var1, Object var2) {
        return String.valueOf(Float.valueOf(var1.toString()) * Float.valueOf(var2.toString()));
    }

    public OpFloatMultiply() {
        super(Calculator.ADD_FLOAT,"*");
    }
}
