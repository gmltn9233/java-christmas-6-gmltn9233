package christmas.utils;

import christmas.enums.EventMessage;
import christmas.enums.OutputMessage;
import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.model.Menu;

public class Calculator {

    private static final int GIFT_CRITERIA=120000;
    private static final int MINIMUM=0;

    public static int afterDiscountTotal(Receipt receipt, Menu menu){
        int total = 0;
        for (OrderMenu orderMenu : receipt.getOrderMenus()){
            total+=calculateMenu(orderMenu.getName(), orderMenu.getQuantity(), menu);
        }
        return total;
    }

    private static int calculateMenu(String name, int quantity, Menu menu){
        return menu.getMenuPrice(name)*quantity;
    }

    public static String isGift(int amount){
        if(amount >= GIFT_CRITERIA){
            return OutputMessage.YES_GIFT.getMessage();
        }
        if(amount < GIFT_CRITERIA && amount > MINIMUM){
            return OutputMessage.NO_GIFT.getMessage();
        }
        return OutputMessage.NO_GIFT.getMessage();
    }

    public static void calculateEvent(Receipt receipt){
        if(isChristmasEvent(receipt.getVisitDate())){

        }
        if(isWeekEvent(receipt.getVisitDate())){

        }
        if(isWeekendEvent(receipt.getVisitDate())){

        }
        if(isSpecialEvent(receipt.getVisitDate())){

        }
    }

    private static boolean isChristmasEvent(int visitDate){
        for (int day : EventMessage.CHRISTMAS_DISCOUNT.getDays()){
            if(visitDate == day){
                return true;
            }
        }
        return false;
    }

    private static boolean isWeekEvent(int visitDate){
        for (int day : EventMessage.WEEK_DISCOUNT.getDays()){
            if(visitDate == day){
                return true;
            }
        }
        return false;
    }

    private static boolean isWeekendEvent(int visitDate){
        for (int day : EventMessage.WEEKEND_DISCOUNT.getDays()){
            if(visitDate == day){
                return true;
            }
        }
        return false;
    }

    private static boolean isSpecialEvent(int visitDate){
        for (int day : EventMessage.SPECIAL_DISCOUNT.getDays()){
            if(visitDate == day){
                return true;
            }
        }
        return false;
    }



}
