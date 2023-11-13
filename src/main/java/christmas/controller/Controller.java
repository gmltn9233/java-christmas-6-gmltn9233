package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.model.Receipt;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {
    public static void orderStart(){
        Menu menu = OrderSystem.initMenu();
        OutputView.displayPlannerStart();
        int visitDate = InputView.validateInputVisitDate();
        OutputView.displayMenuList(menu);
        Map<String,Integer> orderMenu = InputView.validateInputMenu(menu);
        Receipt receipt = OrderSystem.initReceipt(visitDate,orderMenu);
        OutputView.displayOrderList(receipt);
        int afterDiscountTotal = OutputView.displayAfterDiscount(receipt,menu);
        OutputView.displayGift(afterDiscountTotal);
        int benefitmAmount = OutputView.displayBenefitDetails(receipt,menu,afterDiscountTotal);
        OutputView.displayTotalBenefit(benefitmAmount);
        OutputView.displayAfterDiscount(afterDiscountTotal,benefitmAmount);
        OutputView.displayEventBadge(benefitmAmount);
    }
}
