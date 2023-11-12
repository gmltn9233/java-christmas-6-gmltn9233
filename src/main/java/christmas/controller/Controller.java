package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.model.Receipt;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    public static void orderStart(){
        Menu menu = OrderSystem.initMenu();
        Receipt receipt = OrderSystem
                .initReceipt(InputView.validateInputVisitDate(),InputView.validateInputMenu(menu));
        OutputView.displayOrderList(receipt);
        int afterDiscountTotal = OutputView.displayAfterDiscount(receipt,menu);
        OutputView.displayGift(afterDiscountTotal);
        OutputView.displayBenefitDetails(receipt,menu,afterDiscountTotal);
    }
}
