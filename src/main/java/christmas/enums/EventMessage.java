package christmas.enums;

public enum EventMessage {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"
            , new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
            , 100,"1000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가합니다."),
    WEEK_DISCOUNT("평일 할인", new int[]{3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31}
            , 2023,"평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인합니다."),
    WEEKEND_DISCOUNT("주말 할인", new int[]{1, 2, 8, 9, 15, 16, 22, 23, 29, 30}
            , 2023,"주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인합니다."),
    SPECIAL_DISCOUNT("특별 할인", new int[]{3, 10, 17, 24, 25, 31}
            , 1000,"달력에 별이 있으면 총주문 금액에서 1,000원 할인합니다. (식당의 달력을 참고해주세요!)"),
    GIFT_DISCOUNT("증정 이벤트",null
            ,25000,"할인 전 총 주문 금액이 12만 원 이상일 경우, 샴페인 1개를 증정합니다."),
    NO_EVENT("없음",null,0,"아쉽게도 적용 가능한 이벤트가 없습니다.");
    private final String eventName;
    private final int[] days;
    private final int discount;
    private final String eventDetails;

    EventMessage(String event, int[] days, int discount, String eventDetails) {
        this.eventName = event;
        this.days = days;
        this.discount = discount;
        this.eventDetails = eventDetails;
    }

    public String getEventName() {
        return eventName;
    }

    public int[] getDays() {
        return days;
    }

    public int getDiscount() {
        return discount;
    }

    public String getEventDetails() {return eventDetails;}
}
