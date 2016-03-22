public class ValidatorNum implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        if (result.longValue() > 10) {
            return true;
        }
        return false;
    }
}