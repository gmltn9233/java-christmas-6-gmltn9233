package christmas.utils;

import christmas.enums.Badge;
import christmas.enums.EventMessage;
import christmas.model.Receipt;
import christmas.model.Menu;


public class Calculator {

    public static int christmasEvent(Receipt receipt) {
        if (receipt.isEventDate(EventMessage.CHRISTMAS_DISCOUNT.getEventName())) {
            return receipt.calculateChristmasEvent();
        }
        return 0;
    }

    public static int weekEvent(Receipt receipt, Menu menu) {
        if (receipt.isEventDate(EventMessage.WEEK_DISCOUNT.getEventName())) {
            int countDesserts = receipt.countCategory(menu, "desserts");
            return EventMessage.WEEK_DISCOUNT.getDiscount() * countDesserts;
        }
        return 0;
    }

    public static int weekendEvent(Receipt receipt, Menu menu) {
        if (receipt.isEventDate(EventMessage.WEEKEND_DISCOUNT.getEventName())) {
            int countMainDishes = receipt.countCategory(menu, "mainDishes");
            return EventMessage.WEEKEND_DISCOUNT.getDiscount() * countMainDishes;
        }
        return 0;
    }

    public static int specialEvent(Receipt receipt) {
        if (receipt.isEventDate(EventMessage.SPECIAL_DISCOUNT.getEventName())) {
            return EventMessage.SPECIAL_DISCOUNT.getDiscount();
        }
        return 0;
    }

    public static String badgeJudge(int totalBenefit) {
        if (totalBenefit >= Badge.SANTA.getCriteria()) {
            return Badge.SANTA.getName();
        }
        if (totalBenefit >= Badge.TREE.getCriteria()) {
            return Badge.TREE.getName();
        }
        if (totalBenefit >= Badge.STAR.getCriteria()) {
            return Badge.STAR.getName();
        }
        return Badge.NO_BADGE.getName();
    }


}
