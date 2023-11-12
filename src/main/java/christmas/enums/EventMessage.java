package christmas.enums;

public enum EventMessage {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"
            , new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
            , 100),
    WEEK_DISCOUNT("평일 할인", new int[]{3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31}, 2023),
    WEEKEND_DISCOUNT("주말 할인", new int[]{1, 2, 8, 9, 15, 16, 22, 23, 29, 30}, 2023),
    SPECIAL_DISCOUNT("특별 할인", new int[]{3, 10, 17, 24, 25, 31}, 1000);

    private final String event;
    private final int[] days;
    private final int discount;

    EventMessage(String event, int[] days, int discount) {
        this.event = event;
        this.days = days;
        this.discount = discount;
    }

    public String getEvent() {
        return event;
    }

    public int[] getDays() {
        return days;
    }

    public int getDiscount() {
        return discount;
    }
}
