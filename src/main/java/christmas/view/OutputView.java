package christmas.view;

import christmas.enums.OutputMessage;
import christmas.model.OrderMenu;
import christmas.model.Receipt;


public class OutputView {
    public static void displayOrderList(Receipt receipt){
        displayVisitDate(receipt);
        System.out.println(OutputMessage.ORDER_MENU);
        for(OrderMenu orderMenu : receipt.getOrderMenus() ){
            displayOrder(orderMenu);
        }
        System.out.println();
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
