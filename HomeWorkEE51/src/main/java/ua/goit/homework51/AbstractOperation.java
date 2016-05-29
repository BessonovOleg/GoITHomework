package ua.goit.homework51;

/**
 * Created by user on 29.05.2016.
 */
public abstract class AbstractOperation implements IOperation{
    public Integer typeOperation;
    public String strOperation;

    public AbstractOperation(Integer tOp,String strOp) {
        typeOperation = tOp;
        strOperation = strOp;
    }

}
