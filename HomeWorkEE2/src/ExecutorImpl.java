import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutorImpl implements Executor<Number> {

    private boolean isExecuteWas = false;
    List<Task> listTasks = new ArrayList<Task>();
    List<Number> listValidResult = new ArrayList<Number>();
    List<Number> listInvalidResult = new ArrayList<Number>();
    Map<Task,Validator> taskValidatorMap = new HashMap<Task, Validator>();


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
        taskValidatorMap.put(task,validator);
    }

    @Override
    public void execute() {
        isExecuteWas = true;
            for (Task task : listTasks) {
                Validator<Number> validator = taskValidatorMap.get(task);
                task.execute();

                if(validator != null) {
                    if (validator.isValid((Number) task.getResult())) {
                        listValidResult.add((Number) task.getResult());
                    } else {
                        listInvalidResult.add((Number) task.getResult());
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