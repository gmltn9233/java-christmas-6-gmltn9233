package christmas.model;

import christmas.enums.EventMessage;

import java.util.List;



public class Receipt {
    private static VisitDate visitDate;
    private final List<OrderMenu> orderMenus;

    public Receipt(VisitDate visitDate, List<OrderMenu> orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }

    public List<OrderMenu> getOrderMenus(){
        return orderMenus;
    }

    public int totalPrice(Menu menu) {
        int total = 0;
        for (OrderMenu orderMenu : orderMenus) {
            total += orderMenu.calculateMenu(menu);
        }
        return total;
    }


    public int countCategory(Menu menu ,String category) {
        int count = 0;
        for (OrderMenu orderMenu : orderMenus) {
            String name = orderMenu.getName();
            if (menu.getMenuCategory(name).equals(category)) {
                count += orderMenu.getQuantity();
            }
        }
        return count;
    }

    public boolean isGift(Menu menu) {
        final int GIFT_CRITERIA = 120000;
        if (totalPrice(menu) >= GIFT_CRITERIA) {
            return true;
        }
        return false;
    }

    public boolean canEvent(Menu menu){
        final int EVENT_CRITERIA = 10000;
        if (totalPrice(menu) < EVENT_CRITERIA) {
            return false;
        }
        return true;
    }

    public static boolean isEventDate(String event, int visitDate) {
        for (int day : getEventDate(event)) {
            if (visitDate == day) {
                return true;
            }
        }
        return false;
    }

    public boolean isEventDate(String event) {
        for (int day : getEventDate(event)) {
            if (visitDate.getVisitDate() == day) {
                return true;
            }
        }
        return false;
    }


    private static int[] getEventDate(String event){
        if(event.equals(EventMessage.CHRISTMAS_DISCOUNT.getEventName())){
            return EventMessage.CHRISTMAS_DISCOUNT.getDays();
        }
        if(event.equals(EventMessage.WEEK_DISCOUNT.getEventName())){
            return EventMessage.WEEK_DISCOUNT.getDays();
        }
        if(event.equals(EventMessage.WEEKEND_DISCOUNT.getEventName())){
            return EventMessage.WEEKEND_DISCOUNT.getDays();
        }
        if(event.equals(EventMessage.SPECIAL_DISCOUNT.getEventName())){
            return EventMessage.SPECIAL_DISCOUNT.getDays();
        }
        return null;
    }

    public int calculateChristmasEvent(){
        return 1000 + (visitDate.getVisitDate() - 1) * EventMessage.CHRISTMAS_DISCOUNT.getDiscount();
    }



}
