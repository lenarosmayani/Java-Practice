package ValidasiInput;


public abstract class InputValidator {
    public abstract boolean validateInput(String inputData);

    protected boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static InputValidator getStringValidator() {
        return new StringInputValidator();
    }

	public static InputValidator getNumericValidator() {
		return new NumericInputValidator();
	}

	public static InputValidator getAlphaNumericValidator() {
		return new AlphaNumericInputValidator();
	}
}
