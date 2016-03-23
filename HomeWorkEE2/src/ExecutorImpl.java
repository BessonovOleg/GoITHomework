import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl implements Executor<Number> {

    private boolean isExecuteWas = false;
    List<Task> listTasks = new ArrayList<Task>();
    List<Number> listValidResult = new ArrayList<Number>();
    List<Number> listInvalidResult = new ArrayList<Number>();
    Validator validator;

    @Override
    public void addTask(Task<? extends Number> task) throws ExecuteWasException{
        if (isExecuteWas) {
            throw new ExecuteWasException();
        }
        listTasks.add(task);
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) throws ExecuteWasException{
        if (isExecuteWas) {
            throw new ExecuteWasException();
        }

        listTasks.add(task);
        this.validator = validator;
    }

    @Override
    public void execute() {
        isExecuteWas = true;

        if (validator!=null) {
            for (Task task : listTasks) {
                task.execute();
                if (validator.isValid(task.getResult())) {
                    listValidResult.add((Number)task.getResult());
                }else{
                    listInvalidResult.add((Number)task.getResult());
                }
            }
        }
    }

    @Override
    public List<Number> getValidResults() throws ExecuteNotWasException{
        if (!isExecuteWas) {
            throw new ExecuteNotWasException();
        }
        return listValidResult;
    }

    @Override
    public List<Number> getInvalidResults() throws ExecuteNotWasException{
        if (!isExecuteWas) {
            throw new ExecuteNotWasException();
        }
        return listInvalidResult;
    }
}