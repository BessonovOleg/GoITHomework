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