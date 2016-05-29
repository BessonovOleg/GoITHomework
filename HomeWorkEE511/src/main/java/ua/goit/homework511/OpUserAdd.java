package ua.goit.homework511;

import ua.goit.homework51.AbstractOperation;
import ua.goit.homework51.Calculator;

/**
 * Created by user on 29.05.2016.
 */
public class OpUserAdd extends AbstractOperation {
    public String calc(Object var1, Object var2) {
        return String.valueOf(Integer.valueOf(var1.toString()) * Integer.valueOf(var2.toString()));
    }

    public OpUserAdd() {
        super(Calculator.ADD_USER_TYPE,"plus");
    }
}
