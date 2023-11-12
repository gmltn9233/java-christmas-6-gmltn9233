package christmas.utils;

import java.util.regex.Pattern;
import christmas.enums.ErrorMessage;
public class Validator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final int MINIMUM_DATE = 1;
    private static final int MAXIMUM_DATE = 31;

    public static void checkVisitDate(String visitDate){
        validateVisitDateHasText(visitDate);
        validateInteger(visitDate);
    }

    public static void checkMenu(String[] menus){

    }

    private static void validateVisitDateHasText(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VISIT_DATE.getMessage());
        }
    }
    private static void validateInteger(String input){
        int numericValue;
        try {
            numericValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
        validateRange(input);
    }
    private static void validateRange(String input){
        if(Integer.parseInt(input) < MINIMUM_DATE || Integer.parseInt(input) > MAXIMUM_DATE){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }
}
