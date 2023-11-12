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

    public static void displayBenefitDetails(Receipt receipt, Menu menu,int afterDiscountTotal){
        int visitDate = receipt.getVisitDate();
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
        displayChristmasEvent(receipt,visitDate);
        displayWeekEvent(receipt,menu,visitDate);
        displayWeekendEvent(receipt,menu,visitDate);
        displaySpecialEvent(receipt,visitDate);
        displayGIftEvent(afterDiscountTotal);
        System.out.println("\n");
    }

    private static void displayCombination(String event, int benefit){
        System.out.println(event+": -"+benefit+"원");
    }

    private static void displayChristmasEvent(Receipt receipt, int visitDate){
        if(Calculator.isChristmasEvent(visitDate)){
            String event = EventMessage.CHRISTMAS_DISCOUNT.getEvent();
            int benefit = Calculator.christmasEvent(receipt);
            displayCombination(event,benefit);
        }
    }

    private static void displayWeekEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekEvent(visitDate)){
            String event = EventMessage.WEEK_DISCOUNT.getEvent();
            int benefit = Calculator.weekEvent(receipt,menu);
            displayCombination(event,benefit);
        }
    }

    private static void displayWeekendEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekendEvent(visitDate)){
            String event = EventMessage.WEEKEND_DISCOUNT.getEvent();
            int benefit = Calculator.weekendEvent(receipt,menu);
            displayCombination(event,benefit);
        }
    }

    private static void displaySpecialEvent(Receipt receipt, int visitDate){
        if(Calculator.isSpecialEvent(visitDate)){
            String event = EventMessage.SPECIAL_DISCOUNT.getEvent();
            int benefit = Calculator.specialEvent(receipt);
            displayCombination(event,benefit);
        }
    }

    private static void displayGIftEvent(int afterDiscountTotal){
        if(Calculator.isGift(afterDiscountTotal)){
            String event = EventMessage.GIFT_DISCOUNT.getEvent();
            int benefit = EventMessage.GIFT_DISCOUNT.getDiscount();
            displayCombination(event,benefit);
        }
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
