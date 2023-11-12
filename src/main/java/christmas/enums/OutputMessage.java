package christmas.enums;

public enum OutputMessage {
    VISIT_DATE("일에 우테코 식당에서 받을 이벤트 헤택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    NO_GIFT("없음"),
    YES_GIFT("샴페인 1개"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    AFTER_DISCOUNT_AMOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");
    String message;
    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
