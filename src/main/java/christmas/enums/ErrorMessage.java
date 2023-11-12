package christmas.enums;

public enum ErrorMessage {
    EMPTY_VISIT_DATE("예약 날짜가 비어있습니다."),
    NOT_INTEGER("숫자가 아닙니다."),
    NOT_IN_RANGE("1이상 31이하의 숫자가 아닙니다."),
    NOT_SPLIT("주문 형식은 [메뉴-수랑,메뉴-수랑] 입니다."),
    EMPTY_MENU_NAME("메뉴 이름이 비어있습니다."),
    NOT_IN_MENU("주문하신 메뉴가 메뉴판에 없습니다."),
    NOT_INTEGER_QUANTITY("주문 수량 입력이 숫자가 아닙니다."),
    EMPTY_QUANTITY("주문 수량 입력이 비어있습니다"),
    QUANTITY_MINIMUM("주문 수량은 최소 1개 입니다."),
    QUANTITY_MAXIMUM("총 메뉴는 최대 20개 까지만 주문할 수 있습니다."),
    DUPLICATED_MENU("메뉴가 중복됩니다! 메뉴는 한번에 시켜주세요."),
    ONLY_BEVERAGE("음료만 주문할 수 없습니다."),
    PREFIX("[ERROR] ");
    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX.message + message;
    }
}
