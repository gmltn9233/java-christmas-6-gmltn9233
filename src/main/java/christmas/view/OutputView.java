package christmas.view;

import christmas.enums.EventMessage;
import christmas.enums.OutputMessage;
import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.utils.Calculator;


public class OutputView {
    public static void displayOrderList(Receipt receipt){
        displayVisitDate(receipt);
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for(OrderMenu orderMenu : receipt.getOrderMenus() ){
            displayOrder(orderMenu);
        }
        System.out.println();
    }

    public static int displayAfterDiscount(Receipt receipt, Menu menu){
        System.out.println(OutputMessage.BEFORE_DISCOUNT_AMOUNT.getMessage());
        int afterDiscountTotal=Calculator.afterDiscountTotal(receipt,menu);
        System.out.println(afterDiscountTotal+"원\n");
        return afterDiscountTotal;
    }

    public static int displayBenefitDetails(Receipt receipt, Menu menu,int afterDiscountTotal){
        int visitDate = receipt.getVisitDate();
        int benefitmAmount = 0;
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
        benefitmAmount += displayChristmasEvent(receipt,visitDate);
        benefitmAmount +=displayWeekEvent(receipt,menu,visitDate);
        benefitmAmount +=displayWeekendEvent(receipt,menu,visitDate);
        benefitmAmount +=displaySpecialEvent(receipt,visitDate);
        benefitmAmount +=displayGIftEvent(afterDiscountTotal);
        System.out.println("\n");
        return benefitmAmount;
    }

    public static void displayTotalBenefit(int totalDiscount){
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.println("-"+totalDiscount+"원");
    }

    public static void displayAfterDiscount(int beforeDiscount, int totalDiscount){
        int giftPrice = 0;
        System.out.println(OutputMessage.AFTER_DISCOUNT_AMOUNT.getMessage());
        if(Calculator.isGift(beforeDiscount)){
            giftPrice = EventMessage.GIFT_DISCOUNT.getDiscount();
        }
        System.out.println(beforeDiscount-totalDiscount+giftPrice+"원");
    }


    private static void displayCombination(String event, int benefit){
        System.out.println(event+": -"+benefit+"원");
    }

    private static int displayChristmasEvent(Receipt receipt, int visitDate){
        if(Calculator.isChristmasEvent(visitDate)){
            String event = EventMessage.CHRISTMAS_DISCOUNT.getEvent();
            int benefit = Calculator.christmasEvent(receipt);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayWeekEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekEvent(visitDate)){
            String event = EventMessage.WEEK_DISCOUNT.getEvent();
            int benefit = Calculator.weekEvent(receipt,menu);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayWeekendEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekendEvent(visitDate)){
            String event = EventMessage.WEEKEND_DISCOUNT.getEvent();
            int benefit = Calculator.weekendEvent(receipt,menu);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displaySpecialEvent(Receipt receipt, int visitDate){
        if(Calculator.isSpecialEvent(visitDate)){
            String event = EventMessage.SPECIAL_DISCOUNT.getEvent();
            int benefit = Calculator.specialEvent(receipt);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayGIftEvent(int afterDiscountTotal){
        if(Calculator.isGift(afterDiscountTotal)){
            String event = EventMessage.GIFT_DISCOUNT.getEvent();
            int benefit = EventMessage.GIFT_DISCOUNT.getDiscount();
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    public static void displayGift(int afterDiscountTotal){
        System.out.println(OutputMessage.GIFT_MENU.getMessage());
        System.out.println(isGift(afterDiscountTotal)+"\n");
    }
    private static void displayOrder(OrderMenu orderMenu){
        String name = orderMenu.getName();
        int quantity = orderMenu.getQuantity();
        System.out.println(name+" "+quantity+"개");
    }
    private static void displayVisitDate(Receipt receipt){
        System.out.println("12월 "+receipt.getVisitDate()+OutputMessage.VISIT_DATE.getMessage()+"\n");
    }

    public static String isGift(int amount){
        if(Calculator.isGift(amount)){
            return OutputMessage.YES_GIFT.getMessage();
        }
        return OutputMessage.NO_GIFT.getMessage();
    }


}
