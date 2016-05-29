package ua.goit.homework51;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public static final int ADD_INTEGER   = 1;
    public static final int ADD_LONG      = 2;
    public static final int ADD_FLOAT     = 3;
    public static final int ADD_DOUBLE    = 4;
    public static final int ADD_USER_TYPE = 5;

    private Map<String,IOperation> mapIntegerOperations  = new HashMap<String, IOperation>();
    private Map<String,IOperation> mapLongOperations     = new HashMap<String, IOperation>();
    private Map<String,IOperation> mapFloatOperations    = new HashMap<String, IOperation>();
    private Map<String,IOperation> mapDoubleOperations   = new HashMap<String, IOperation>();
    private Map<String,IOperation> mapUserTypeOperations = new HashMap<String, IOperation>();

    private String strVar1;
    private String strVar2;
    private String strOperation;

    private String strError = "operation is not supported";

    public Calculator() {
        addOperation(ADD_INTEGER,"+",new OpIntegerAdd());
        addOperation(ADD_INTEGER,"-",new OpIntegerSub());

        addOperation(ADD_LONG,"+",new OpLongAdd());
        addOperation(ADD_LONG,"-",new OpLongSub());

        addOperation(ADD_FLOAT,"+",new OpFloatAdd());
        addOperation(ADD_FLOAT,"-",new OpFloatSub());

        addOperation(ADD_DOUBLE,"+",new OpDoubleAdd());
        addOperation(ADD_DOUBLE,"-",new OpDoubleSub());
    }

    public String getIntegerResult(String param) {
       String result = "";
       parser(param);

       if (mapIntegerOperations.containsKey(strOperation)) {
            IOperation op = mapIntegerOperations.get(strOperation);
            result = strVar1 + " " + strOperation + " " + strVar2 + " = " + op.calc(strVar1,strVar2);
       }else {
            result = strError;
       }
       return result;
    }

    public String getLongResult(String param) {
        String result = "";
        parser(param);

        if (mapLongOperations.containsKey(strOperation)) {
            IOperation op = mapLongOperations.get(strOperation);
            result = strVar1 + " " + strOperation + " " + strVar2 + " = " + op.calc(strVar1,strVar2);
        }else {
            result = strError;
        }
        return result;
    }

    public String getFloatResult(String param) {
        String result = "";
        parser(param);

        if (mapFloatOperations.containsKey(strOperation)) {
            IOperation op = mapFloatOperations.get(strOperation);
            result = strVar1 + " " + strOperation + " " + strVar2 + " = " + op.calc(strVar1,strVar2);
        }else {
            result = strError;
        }
        return result;
    }

    public String getDoubleResult(String param) {
        String result = "";
        parser(param);

        if (mapDoubleOperations.containsKey(strOperation)) {
            IOperation op = mapDoubleOperations.get(strOperation);
            result = strVar1 + " " + strOperation + " " + strVar2 + " = " + op.calc(strVar1,strVar2);
        }else {
            result = strError;
        }
        return result;
    }


    public String getUserTypeResult(String param) {
        String result = "";
        parser(param);

        if (mapUserTypeOperations.containsKey(strOperation)) {
            IOperation op = mapUserTypeOperations.get(strOperation);
            result = strVar1 + " " + strOperation + " " + strVar2 + " = " + op.calc(strVar1,strVar2);
        }else {
            result = strError;
        }
        return result;
    }


    private void parser(String exp) {
        String result = "";
        this.strVar1 = "";
        this.strVar2 = "";
        this.strOperation = "";

        final int TYPE_ELEMENT1  = 1;
        final int TYPE_ELEMENT2  = 2;
        final int TYPE_OPERATION = 3;
        int parsElementType = 0;

        exp = exp.replace(',','.');

        StringBuilder var1 = new StringBuilder();
        StringBuilder var2 = new StringBuilder();
        StringBuilder op   = new StringBuilder();

        for(int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i)!=' ') {
                if (i == 0) {
                    if (Character.isDigit(exp.charAt(i))) {
                        var1.append(exp.charAt(i));
                        parsElementType = TYPE_ELEMENT1;
                    } else {
                        op.append(exp.charAt(i));
                        parsElementType = TYPE_OPERATION;
                    }
                } else {
                    if (Character.isDigit(exp.charAt(i))) {

                        if (parsElementType == TYPE_OPERATION) {
                            var2.append(exp.charAt(i));
                            parsElementType = TYPE_ELEMENT2;
                        } else if (parsElementType == TYPE_ELEMENT1) {
                            var1.append(exp.charAt(i));
                        } else if (parsElementType == TYPE_ELEMENT2) {
                            var2.append(exp.charAt(i));
                        }

                    } else if (exp.charAt(i) == '.') {
                        if (parsElementType == TYPE_ELEMENT1) var1.append(exp.charAt(i));
                        if (parsElementType == TYPE_ELEMENT2) var2.append(exp.charAt(i));
                    } else {
                        op.append(exp.charAt(i));
                        parsElementType = TYPE_OPERATION;
                    }
                }
            }
        }

        this.strVar1 = var1.toString();
        this.strVar2 = var2.toString();
        this.strOperation = op.toString();
    }


    public void addOperation(AbstractOperation aop) {
        addOperation(aop.typeOperation,aop.strOperation,aop);
    }

    public void addOperation(Integer typeOperation,String strOperation,IOperation classOperation){

        if (typeOperation == ADD_INTEGER) {
            if (!mapIntegerOperations.containsKey(strOperation) && classOperation != null) {
                mapIntegerOperations.put(strOperation,classOperation);
            }
        }
        if (typeOperation == ADD_LONG) {
            if (!mapLongOperations.containsKey(strOperation) && classOperation != null) {
                mapLongOperations.put(strOperation,classOperation);
            }
        }
        if (typeOperation == ADD_FLOAT) {
            if (!mapFloatOperations.containsKey(strOperation) && classOperation != null) {
                mapFloatOperations.put(strOperation,classOperation);
            }
        }
        if (typeOperation == ADD_DOUBLE) {
            if (!mapDoubleOperations.containsKey(strOperation) && classOperation != null) {
                mapDoubleOperations.put(strOperation,classOperation);
            }
        }
        if (typeOperation == ADD_USER_TYPE) {
            if (!mapUserTypeOperations.containsKey(strOperation) && classOperation != null) {
                mapUserTypeOperations.put(strOperation,classOperation);
            }
        }
    }

    private class OpIntegerAdd implements IOperation{
        public String calc(Object var1, Object var2) {
            return String.valueOf(Integer.valueOf(var1.toString()) + Integer.valueOf(var2.toString()));
        }
    }

    private class OpIntegerSub implements IOperation {
        public String calc(Object var1, Object var2) {
            return String.valueOf(Integer.valueOf(var1.toString()) - Integer.valueOf(var2.toString()));
        }
    }


    private class OpLongAdd implements IOperation{
        public String calc(Object var1, Object var2) {
            return String.valueOf(Long.valueOf(var1.toString()) + Long.valueOf(var2.toString()));
        }
    }

    private class OpLongSub implements IOperation {
        public String calc(Object var1, Object var2) {
            return String.valueOf(Long.valueOf(var1.toString()) - Long.valueOf(var2.toString()));
        }
    }

    private class OpFloatAdd implements IOperation{
        public String calc(Object var1, Object var2) {
            return String.valueOf(Float.valueOf(var1.toString()) + Float.valueOf(var2.toString()));
        }
    }

    private class OpFloatSub implements IOperation {
        public String calc(Object var1, Object var2) {
            return String.valueOf(Float.valueOf(var1.toString()) - Float.valueOf(var2.toString()));
        }
    }

    private class OpDoubleAdd implements IOperation{
        public String calc(Object var1, Object var2) {
            return String.valueOf(Double.valueOf(var1.toString()) + Double.valueOf(var2.toString()));
        }
    }

    private class OpDoubleSub implements IOperation {
        public String calc(Object var1, Object var2) {
            return String.valueOf(Double.valueOf(var1.toString()) - Double.valueOf(var2.toString()));
        }
    }


}
