import java.util.List;

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
