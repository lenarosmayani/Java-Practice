package ValidasiInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphaNumericInputValidator extends InputValidator {
    @Override
    public boolean validateInput(String inputData) {
        if (!isNullOrEmpty(inputData)) {
            Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s-]+");
            Matcher matcher = pattern.matcher(inputData);
            return matcher.matches();
        }
        return false;
    }
}

