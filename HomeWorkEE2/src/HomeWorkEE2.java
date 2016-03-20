import java.util.List;

public class HomeWorkEE2 {

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
        void addTask(Task<? extends T> task);

        // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
        // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
        // Бросает Эксепшн если уже был вызван метод execute()
        void addTask(Task<? extends T> task, Validator<? super T> validator);

        // Выполнить все добавленые таски
        void execute();

        // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
        List getValidResults();

        // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
        List getInvalidResults();

    }







    public static void main(String[] args) {

    }




}
