package christmas.utils;

import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.model.Menu;

public class Calculator {
    public static int afterDiscountTotal(Receipt receipt, Menu menu){
        int total = 0;
        for (OrderMenu orderMenu : receipt.getOrderMenus()){
            calculateMenu(orderMenu.getName(), orderMenu.getQuantity(), menu);
        }
        return total;
    }

    private static int calculateMenu(String name, int quantity, Menu menu){
        return menu.getMenuPrice(name)*quantity;
    }
}
