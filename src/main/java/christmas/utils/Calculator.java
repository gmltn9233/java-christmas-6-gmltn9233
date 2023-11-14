package christmas.utils;

import christmas.enums.Badge;
import christmas.enums.EventMessage;
import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.model.Menu;

import java.util.List;

public class Calculator {

    private static final int GIFT_CRITERIA = 120000;
    private static final int EVENT_CRITERIA = 10000;

    public static int afterDiscountTotal(Receipt receipt, Menu menu) {
        int total = 0;
        for (OrderMenu orderMenu : receipt.getOrderMenus()) {
            total += calculateMenu(orderMenu.getName(), orderMenu.getQuantity(), menu);
        }
        return total;
    }

    private static int calculateMenu(String name, int quantity, Menu menu) {
        return menu.getMenuPrice(name) * quantity;
    }

    public static boolean isGift(int amount) {
        if (amount >= GIFT_CRITERIA) {
            return true;
        }
        return false;
    }

    public static boolean isChristmasEvent(int visitDate) {
        for (int day : EventMessage.CHRISTMAS_DISCOUNT.getDays()) {
            if (visitDate == day) {
                return true;
            }
        }
        return false;
    }

    public static int christmasEvent(Receipt receipt) {
        int visitDate = receipt.getVisitDate();
        if (isChristmasEvent(visitDate)) {
            return 1000 + (visitDate - 1) * EventMessage.CHRISTMAS_DISCOUNT.getDiscount();
        }
        return 0;
    }

    public static boolean isWeekEvent(int visitDate) {
        for (int day : EventMessage.WEEK_DISCOUNT.getDays()) {
            if (visitDate == day) {
                return true;
            }
        }
        return false;
    }

    public static int weekEvent(Receipt receipt, Menu menu) {
        int visitDate = receipt.getVisitDate();
        List<OrderMenu> orderMenus = receipt.getOrderMenus();
        if (isWeekEvent(visitDate)) {
            int countDesserts = countDesserts(orderMenus, menu);
            return EventMessage.WEEK_DISCOUNT.getDiscount() * countDesserts;
        }
        return 0;
    }

    public static int countDesserts(List<OrderMenu> orderMenus, Menu menu) {
        int count = 0;
        for (OrderMenu orderMenu : orderMenus) {
            String name = orderMenu.getName();
            if (menu.getMenuCategory(name).equals("desserts")) {
                count += orderMenu.getQuantity();
            }
        }
        return count;
    }

    public static boolean isWeekendEvent(int visitDate) {
        for (int day : EventMessage.WEEKEND_DISCOUNT.getDays()) {
            if (visitDate == day) {
                return true;
            }
        }
        return false;
    }

    public static int weekendEvent(Receipt receipt, Menu menu) {
        int visitDate = receipt.getVisitDate();
        List<OrderMenu> orderMenus = receipt.getOrderMenus();
        if (isWeekendEvent(visitDate)) {
            int countMainDishes = countMainDishes(orderMenus, menu);
            return EventMessage.WEEKEND_DISCOUNT.getDiscount() * countMainDishes;
        }
        return 0;
    }

    public static int countMainDishes(List<OrderMenu> orderMenus, Menu menu) {
        int count = 0;
        for (OrderMenu orderMenu : orderMenus) {
            String name = orderMenu.getName();
            if (menu.getMenuCategory(name).equals("mainDishes")) {
                ++count;
            }
        }
        return count;
    }

    public static boolean isSpecialEvent(int visitDate) {
        for (int day : EventMessage.SPECIAL_DISCOUNT.getDays()) {
            if (visitDate == day) {
                return true;
            }
        }
        return false;
    }

    public static int specialEvent(Receipt receipt) {
        int visitDate = receipt.getVisitDate();
        if (isSpecialEvent(visitDate)) {
            return 1000;
        }
        return 0;
    }

    public static String badgeJudge(int totalBenfeit) {
        if (totalBenfeit >= Badge.SANTA.getCriteria()) {
            return Badge.SANTA.getName();
        }
        if (totalBenfeit >= Badge.TREE.getCriteria()) {
            return Badge.TREE.getName();
        }
        if (totalBenfeit >= Badge.STAR.getCriteria()) {
            return Badge.STAR.getName();
        }
        return Badge.NO_BADGE.getName();
    }

    public static boolean canEvent(int beforeDiscountTotal) {
        if (beforeDiscountTotal < EVENT_CRITERIA) {
            return false;
        }
        return true;
    }

}
