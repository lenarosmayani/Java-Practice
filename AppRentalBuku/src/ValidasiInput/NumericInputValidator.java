package ValidasiInput;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericInputValidator extends InputValidator {
    @Override
    public boolean validateInput(String inputData) {
        if (!isNullOrEmpty(inputData)) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(inputData);
            return matcher.matches();
        }
        return false;
    }
}

