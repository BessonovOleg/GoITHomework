public class ValidatorNum implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        if (result.floatValue() > 10) {
            return true;
        } else {
            return false;
        }
    }
}