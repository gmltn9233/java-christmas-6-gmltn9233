package christmas.view;

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

    public static void displayGift(int afterDiscountTotal){
        System.out.println(OutputMessage.GIFT_MENU.getMessage());
        System.out.println(Calculator.isGift(afterDiscountTotal)+"\n");
    }
    private static void displayOrder(OrderMenu orderMenu){
        String name = orderMenu.getName();
        int quantity = orderMenu.getQuantity();
        System.out.println(name+" "+quantity+"개");
    }
    private static void displayVisitDate(Receipt receipt){
        System.out.println("12월 "+receipt.getVisitDate()+OutputMessage.VISIT_DATE.getMessage()+"\n");
    }


}
