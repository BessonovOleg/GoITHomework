import java.util.ArrayList;
import java.util.List;

public class HomeWorkEE2 {

    private ExecutorImpl exImpl;

    public HomeWorkEE2() {
        TaskImplIntegerAdd task1 = new TaskImplIntegerAdd(10);
        TaskImplIntegerAdd task2 = new TaskImplIntegerAdd(20);
        TaskImplIntegerAdd task3 = new TaskImplIntegerAdd(30);
        TaskImplIntegerSub task4 = new TaskImplIntegerSub(50);
        TaskImplIntegerSub task5 = new TaskImplIntegerSub(60);
        TaskImpLongAdd task6 = new TaskImpLongAdd(100L);
        TaskImpLongAdd task7 = new TaskImpLongAdd(200L);
        TaskImpLongAdd task8 = new TaskImpLongAdd(300L);
        exImpl = new ExecutorImpl();

        try {
            exImpl.addTask(task1);
        }catch (ExecuteWasException) {
            System.out.println("Exception");
        }


    }

    //1 Переписать интерфейс Task так что бы он был типизирован по результату (значению возращаемуому методом getResult()).
    public interface Task<T> {
        // Метода запускает таск на выполнение
        void execute();

        // Возвращает результат выполнения
        T getResult();
    }

    public interface Validator <T> {
        // Валидирует переданое значение
        boolean isValid(T result);

    }

    //3 Переписать интерфейс Executor так чтоб он был типизирован в соответсвии с с типизацией Task и Validator

    public interface Executor<T> {
        // Добавить таск на выполнение. Результат таска будет доступен через метод getValidResults().
        // Бросает Эксепшн если уже был вызван метод execute()
        void addTask(Task<? extends T> task) throws ExecuteWasException;

        // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
        // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
        // Бросает Эксепшн если уже был вызван метод execute()
        void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecuteWasException;

        // Выполнить все добавленые таски
        void execute();

        // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
        List<T> getValidResults() throws ExecuteNotWasException;

        // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
        List<T> getInvalidResults() throws ExecuteNotWasException;

    }


    public class TaskImplIntegerAdd implements Task<Number> {
      private Integer num;

        public TaskImplIntegerAdd(Number num) {
            this.num = num.intValue();
        }

        @Override
        public void execute() {
            num += num;
        }

        @Override
        public Number getResult() {
            return num;
        }
    }

    public class TaskImplIntegerSub implements Task<Number> {
        private Integer num;

        public TaskImplIntegerSub(Number num) {
            this.num = num.intValue();
        }

        @Override
        public void execute() {
            num -= num;
        }

        @Override
        public Number getResult() {
            return num;
        }
    }

    public class TaskImpLongAdd implements Task<Number> {
        private Long num;

        public TaskImpLongAdd(Long num) {
            this.num = num;
        }

        @Override
        public void execute() {
            num += num;
        }

        @Override
        public Number getResult() {
            return num;
        }
    }


    public class ValidatorNum implements Validator<Number> {
        @Override
        public boolean isValid(Number result) {
            if (result.longValue() > 10) {
                return true;
            }
            return false;
        }
    }



    public class ExecutorImpl implements Executor<Number> {

        private boolean isExecuteWas = false;
        List<Task> listTasks = new ArrayList<Task>();

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
        }

        @Override
        public void execute() {
        }

        @Override
        public List getValidResults() throws ExecuteNotWasException{
            if (isExecuteWas) {
                throw new ExecuteNotWasException();
            }


            return null;
        }

        @Override
        public List getInvalidResults() throws ExecuteNotWasException{
            if (isExecuteWas) {
                throw new ExecuteNotWasException();
            }

            return null;
        }
    }



    public static void main(String[] args) {
        HomeWorkEE2 hh = new HomeWorkEE2();

    }



}
