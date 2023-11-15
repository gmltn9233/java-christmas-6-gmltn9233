package christmas.view;

import christmas.enums.Badge;
import christmas.enums.EventMessage;
import christmas.enums.OutputMessage;
import christmas.model.*;
import christmas.utils.Calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OutputView {

    public void displayPlannerStart() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void displayAppliedEvent(VisitDate visitDate) {
        int Date = visitDate.getVisitDate();
        System.out.println(OutputMessage.APPLIED_EVENT.getMessage());
        if (Receipt.isEventDate(EventMessage.CHRISTMAS_DISCOUNT.getEventName(), Date)) {
            formatEventDetails(EventMessage.CHRISTMAS_DISCOUNT.getEventName(), EventMessage.CHRISTMAS_DISCOUNT.getEventDetails());
        }
        if (Receipt.isEventDate(EventMessage.WEEK_DISCOUNT.getEventName(), Date)) {
            formatEventDetails(EventMessage.WEEK_DISCOUNT.getEventName(), EventMessage.WEEK_DISCOUNT.getEventDetails());
        }
        if (Receipt.isEventDate(EventMessage.WEEKEND_DISCOUNT.getEventName(), Date)) {
            formatEventDetails(EventMessage.WEEKEND_DISCOUNT.getEventName(), EventMessage.WEEKEND_DISCOUNT.getEventDetails());
        }
        if (Receipt.isEventDate(EventMessage.SPECIAL_DISCOUNT.getEventName(), Date)) {
            formatEventDetails(EventMessage.SPECIAL_DISCOUNT.getEventName(), EventMessage.SPECIAL_DISCOUNT.getEventDetails());
        }
        formatEventDetails(EventMessage.GIFT_DISCOUNT.getEventName(), EventMessage.GIFT_DISCOUNT.getEventDetails());
        System.out.println(OutputMessage.EVENT_NOTIFICATION.getMessage() + "\n");
    }

    public void displayMenuList(Menu menu) {
        System.out.println(OutputMessage.MENU_LIST.getMessage());
        displayCategoryList(menu, "appetizers");
        displayCategoryList(menu, "mainDishes");
        displayCategoryList(menu, "desserts");
        displayCategoryList(menu, "beverages");
    }

    public void displayOrderList(Receipt receipt) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for (OrderMenu orderMenu : receipt.getOrderMenus()) {
            displayOrder(orderMenu);
        }
        System.out.println();
    }

    public void displayVisitDate(int visitDate) {
        System.out.println("12월 " + visitDate + OutputMessage.VISIT_DATE.getMessage() + "\n");
    }

    private void displayOrder(OrderMenu orderMenu) {
        String name = orderMenu.getName();
        int quantity = orderMenu.getQuantity();
        System.out.println(name + " " + quantity + "개");
    }


    public void displayAfterDiscount(Receipt receipt, Menu menu) {
        System.out.println(OutputMessage.BEFORE_DISCOUNT_AMOUNT.getMessage());
        int afterDiscountTotal = receipt.totalPrice(menu);
        System.out.println(formatWon(afterDiscountTotal) + "\n");
    }

    public void displayGift(Receipt receipt, Menu menu) {
        System.out.println(OutputMessage.GIFT_MENU.getMessage());
        System.out.println(giftMessage(receipt, menu) + "\n");
    }

    public int displayBenefitDetails(Receipt receipt, Menu menu) {
        int benefitmAmount = 0;
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
        if (receipt.canEvent(menu)) {
            benefitmAmount -= displayChristmasEvent(receipt);
            benefitmAmount -= displayWeekEvent(receipt, menu);
            benefitmAmount -= displayWeekendEvent(receipt, menu);
            benefitmAmount -= displaySpecialEvent(receipt);
            benefitmAmount -= displayGiftEvent(receipt, menu);
        }
        if (!receipt.canEvent(menu) || benefitmAmount == 0) {
            System.out.println(EventMessage.NO_EVENT.getEventName());
        }
        System.out.println();
        return benefitmAmount;
    }

    public void displayTotalBenefit(int totalDiscount) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.println(formatWon(totalDiscount) + "\n");
    }

    public void displayAfterDiscount(Receipt receipt, Menu menu, int totalDiscount) {
        int giftPrice = 0;
        System.out.println(OutputMessage.AFTER_DISCOUNT_AMOUNT.getMessage());
        if (receipt.isGift(menu)) {
            giftPrice = EventMessage.GIFT_DISCOUNT.getDiscount();
        }
        System.out.println(formatWon(receipt.totalPrice(menu) + totalDiscount + giftPrice) + "\n");
    }

    public void displayEventBadge(int totalDiscount) {
        System.out.println(OutputMessage.EVENT_BADGE.getMessage());
        System.out.println(Calculator.badgeJudge(-totalDiscount) + "\n");
        if (!Calculator.badgeJudge(-totalDiscount).equals(Badge.NO_BADGE.getName())) {
            System.out.println(OutputMessage.NEW_YEAR_EVENT.getMessage());
        }
    }

    private void displayCategoryList(Menu menu, String category) {
        List<String> categoryList = new ArrayList<>();
        displayCategory(category);
        for (Map.Entry<String, Integer> entry : menu.getCategoryItem(category).entrySet()) {
            categoryList.add(formatMenu(entry.getKey(), entry.getValue()));
        }
        formatMenus(categoryList);
    }

    private static void displayCategory(String category) {
        if (category.equals("appetizers")) {
            System.out.println(OutputMessage.APPETIZERS.getMessage());
        }
        if (category.equals("mainDishes")) {
            System.out.println(OutputMessage.MAIN_DISHES.getMessage());
        }
        if (category.equals("desserts")) {
            System.out.println(OutputMessage.DESSERTS.getMessage());
        }
        if (category.equals("beverages")) {
            System.out.println(OutputMessage.BEVERAGES.getMessage());
        }
    }


    private int displayChristmasEvent(Receipt receipt) {
        if (receipt.isEventDate(EventMessage.CHRISTMAS_DISCOUNT.getEventName())) {
            String event = EventMessage.CHRISTMAS_DISCOUNT.getEventName();
            int benefit = Calculator.christmasEvent(receipt);
            formatBenefitDetails(event, benefit);
            return benefit;
        }
        return 0;
    }

    private int displayWeekEvent(Receipt receipt, Menu menu) {
        if (receipt.countCategory(menu, "desserts") == 0) {
            return 0;
        }
        if (receipt.isEventDate(EventMessage.WEEK_DISCOUNT.getEventName())) {
            String event = EventMessage.WEEK_DISCOUNT.getEventName();
            int benefit = Calculator.weekEvent(receipt, menu);
            formatBenefitDetails(event, benefit);
            return benefit;
        }
        return 0;
    }

    private int displayWeekendEvent(Receipt receipt, Menu menu) {
        if (receipt.countCategory(menu, "mainDishes") == 0) {
            return 0;
        }
        if (receipt.isEventDate(EventMessage.WEEKEND_DISCOUNT.getEventName())) {
            String event = EventMessage.WEEKEND_DISCOUNT.getEventName();
            int benefit = Calculator.weekendEvent(receipt, menu);
            formatBenefitDetails(event, benefit);
            return benefit;
        }
        return 0;
    }

    private int displaySpecialEvent(Receipt receipt) {
        if (receipt.isEventDate(EventMessage.SPECIAL_DISCOUNT.getEventName())) {
            String event = EventMessage.SPECIAL_DISCOUNT.getEventName();
            int benefit = Calculator.specialEvent(receipt);
            formatBenefitDetails(event, benefit);
            return benefit;
        }
        return 0;
    }

    private int displayGiftEvent(Receipt receipt, Menu menu) {
        if (receipt.isGift(menu)) {
            String event = EventMessage.GIFT_DISCOUNT.getEventName();
            int benefit = EventMessage.GIFT_DISCOUNT.getDiscount();
            formatBenefitDetails(event, benefit);
            return benefit;
        }
        return 0;
    }

    private String giftMessage(Receipt receipt, Menu menu) {
        if (receipt.isGift(menu)) {
            return OutputMessage.YES_GIFT.getMessage();
        }
        return OutputMessage.NO_GIFT.getMessage();
    }

    private String formatMenu(String name, int price) {
        return name + "(" + formatWon(price) + ")";
    }

    private void formatMenus(List<String> list) {
        System.out.println(String.join(",", list) + "\n");
    }

    private void formatEventDetails(String eventName, String EventDetails) {
        System.out.println(eventName + ": " + EventDetails);
    }

    public String formatWon(int amount) {
        DecimalFormat formatter = new DecimalFormat("#,###,###원");
        return formatter.format(amount);
    }

    private void formatBenefitDetails(String event, int benefit) {
        System.out.println(event + ": " + formatWon(-benefit));
    }

}
