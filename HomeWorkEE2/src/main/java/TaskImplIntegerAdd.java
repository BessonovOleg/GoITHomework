public class TaskImplIntegerAdd implements Task<Number> {
    private Integer num;

    public TaskImplIntegerAdd(Number num) {
        this.num = num.intValue();
    }

    @Override
    public void execute() {
        num = num + num;
    }

    @Override
    public Number getResult() {
        return num;
    }
}