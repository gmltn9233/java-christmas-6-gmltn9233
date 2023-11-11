package christmas.utils;

public class Validator {
    public static boolean checkVisitDate(String visitDate){
        if(validateHasText(visitDate)){
            return false;
        }
        if (validateInteger(visitDate)){
            return false;
        }
        if(validateRange(visitDate)){
            return false;
        }
        return true;
    }

    private static boolean validateHasText(String input){
        return true;
    }
    private static boolean validateInteger(String input){
        return true;
    }
    private static boolean validateRange(String input){
        return true;
    }
}
