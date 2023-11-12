package christmas.utils;

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

}
