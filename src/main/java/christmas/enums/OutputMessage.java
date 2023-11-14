package christmas.enums;

public enum OutputMessage {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    APPLIED_EVENT("[방문 날짜에 적용 가능한 이벤트]"),
    EVENT_NOTIFICATION("* 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),
    MENU_LIST("[우테코 식당의 메뉴]"),
    APPETIZERS("<애피타이저>"),
    MAIN_DISHES("<메인>"),
    DESSERTS("<디저트>"),
    BEVERAGES("<음료>"),
    VISIT_DATE("일에 우테코 식당에서 받을 이벤트 헤택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    NO_GIFT("없음"),
    YES_GIFT("샴페인 1개"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    AFTER_DISCOUNT_AMOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    NEW_YEAR_EVENT("이 배지를 가지고 2024년 새해 이벤트에 참여하시면 새해 선물을 드립니다!");
    String message;
    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
