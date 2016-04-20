import org.junit.Assert;
import org.junit.Test;

public class HomeWorkEE2Test extends Assert{

    @Test(expected = ExecuteWasException.class)
    public void addTaskTest() throws Exception {
        ExecutorImpl exImpl = new ExecutorImpl();
        TaskImplIntegerAdd task1 = new TaskImplIntegerAdd(10);
        TaskImplIntegerAdd task2 = new TaskImplIntegerAdd(20);

        exImpl.addTask(task1);
        exImpl.execute();
        exImpl.addTask(task2);
    }

    @Test(expected = ExecuteWasException.class)
    public void addTaskTest2() throws Exception {
        ExecutorImpl exImpl = new ExecutorImpl();
        ValidatorNum validator = new ValidatorNum();
        TaskImplIntegerAdd task1 = new TaskImplIntegerAdd(10);
        TaskImplIntegerAdd task2 = new TaskImplIntegerAdd(20);

        exImpl.addTask(task1,validator);
        exImpl.execute();
        exImpl.addTask(task2,validator);
    }

    @Test(expected = ExecuteNotWasException.class)
    public void getValidResultTest() throws Exception {
       ExecutorImpl exImpl = new ExecutorImpl();
       exImpl.getValidResults();
    }

    @Test(expected = ExecuteNotWasException.class)
    public void getInvalidResultTest() throws Exception {
        ExecutorImpl exImpl = new ExecutorImpl();
        exImpl.getInvalidResults();
    }

}
