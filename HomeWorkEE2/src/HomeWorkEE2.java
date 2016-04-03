import java.util.ArrayList;
import java.util.List;

public class HomeWorkEE2 {

    private ExecutorImpl exImpl;

    public HomeWorkEE2() {
        TaskImplIntegerAdd task1 = new TaskImplIntegerAdd(1);
        TaskImplIntegerAdd task2 = new TaskImplIntegerAdd(2);
        TaskImplIntegerAdd task3 = new TaskImplIntegerAdd(30);
        TaskImplIntegerSub task4 = new TaskImplIntegerSub(50);
        TaskImplIntegerSub task5 = new TaskImplIntegerSub(60);
        TaskImpLongAdd task6 = new TaskImpLongAdd(100L);
        TaskImpLongAdd task7 = new TaskImpLongAdd(200L);
        TaskImpLongAdd task8 = new TaskImpLongAdd(300L);
        exImpl = new ExecutorImpl();

        try {
            exImpl.addTask(task1);
            exImpl.addTask(task2);
            exImpl.addTask(task3, new ValidatorNum());
            exImpl.addTask(task4);
            exImpl.addTask(task5, new ValidatorNum());
            exImpl.addTask(task6);
            exImpl.addTask(task7);
            exImpl.addTask(task8, new ValidatorNum());
        }catch (ExecuteWasException e) {
            e.printStackTrace();
        }

        exImpl.execute();

        try{
            for(Number num:exImpl.getValidResults()) {
                System.out.println("Valid: " + num);
            }
        } catch (ExecuteNotWasException e) {
            e.printStackTrace();
        }

        try {
            for(Number num:exImpl.getInvalidResults()) {
                System.out.println("Invalid: " + num);
            }
        }catch (ExecuteNotWasException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HomeWorkEE2 hh = new HomeWorkEE2();
    }

}
