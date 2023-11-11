package christmas.enums;

public enum ErrorMessage {
    EMPTY_VISIT_DATE("예약 날짜가 비어있습니다."),
    NOT_INTEGER("숫자가 아닙니다."),
    NOT_IN_RANGE("1이상 31이하의 숫자가 아닙니다."),
    PREFIX("[ERROR] ");
    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX.message + message;
    }
}
