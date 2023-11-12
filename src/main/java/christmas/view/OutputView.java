package christmas.view;

import christmas.enums.OutputMessage;
import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.utils.Calculator;


public class OutputView {
    public static void displayOrderList(Receipt receipt){
        displayVisitDate(receipt);
        System.out.println(OutputMessage.ORDER_MENU);
        for(OrderMenu orderMenu : receipt.getOrderMenus() ){
            displayOrder(orderMenu);
        }
        System.out.println();
    }

    public static void displayAfterDiscount(Receipt receipt, Menu menu){
        System.out.println(OutputMessage.BEFORE_DISCOUNT_AMOUNT);
        System.out.println(Calculator.afterDiscountTotal(receipt,menu)+"원\n");
    }
    private static void displayOrder(OrderMenu orderMenu){
        String name = orderMenu.getName();
        int quantity = orderMenu.getQuantity();
        System.out.println(name+" "+quantity);
    }
    private static void displayVisitDate(Receipt receipt){
        System.out.println("12월 "+receipt.getVisitDate()+OutputMessage.VISIT_DATE+"\n");
    }

}
