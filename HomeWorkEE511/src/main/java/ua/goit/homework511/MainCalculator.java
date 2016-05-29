package ua.goit.homework511;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.homework51.Calculator;


import java.util.Scanner;

public class MainCalculator {

    private int typeExpression;
    private Calculator calculator;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        MainCalculator mainCalculator = applicationContext.getBean("maincalculator",MainCalculator.class);
        mainCalculator.execute();
    }


    public MainCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void execute() {
        typeExpression = 1;
        Scanner input = new Scanner(System.in);
        String strInput = "";

        System.out.println("Simple Calculator.\n"+
        "Please Select the type of expression:(is now set integer) \n"+
        "i - integer \n"+
        "l - long \n"+
        "f - float \n"+
        "d - double \n"+
        "u - user type\n"+
        "Or q to Exit \n"+
        "After enter expression \n"+
        "for example:\n"+
        "i \n"+
        "2+2");

        while (!strInput.equals("q")) {
            strInput = input.nextLine();

            if (strInput.length() == 1) {
                if(strInput.equals("q")) {
                    break;
                } else {
                    checkAndSetType(strInput);
                }
            } else {
                if(typeExpression == 1) {
                    System.out.println(calculator.getIntegerResult(strInput));
                }

                if(typeExpression == 2) {
                    System.out.println(calculator.getLongResult(strInput));
                }

                if(typeExpression == 3) {
                    System.out.println(calculator.getFloatResult(strInput));
                }

                if(typeExpression == 4) {
                    System.out.println(calculator.getDoubleResult(strInput));
                }

                if(typeExpression == 5) {
                    System.out.println(calculator.getUserTypeResult(strInput));
                }
            }

        }
    }


    public void checkAndSetType(String inputString) {
        if (inputString.equals("i")) {
            typeExpression = 1;
            System.out.println("set of 'integer' mode");
        }else if (inputString.equals("l")) {
            typeExpression = 2;
            System.out.println("set of 'long' mode");
        }else if (inputString.equals("f")) {
            typeExpression = 3;
            System.out.println("set of 'float' mode");
        }else if (inputString.equals("d")) {
            typeExpression = 4;
            System.out.println("set of 'double' mode");
        }else if (inputString.equals("u")) {
            typeExpression = 5;
            System.out.println("set of 'user-type' mode");
        } else {
            System.out.println("Wrong input!");
        }
    }
}
