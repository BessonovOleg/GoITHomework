public class TaskImplIntegerSub implements Task<Number> {
    private Integer num;

    public TaskImplIntegerSub(Number num) {
        this.num = num.intValue();
    }

    @Override
    public void execute() {
        num = num - 10;
    }

    @Override
    public Number getResult() {
        return num;
    }
}