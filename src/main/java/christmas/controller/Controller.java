package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.model.Receipt;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {

    private final OrderSystem orderSystem = new OrderSystem();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void orderStart() {
        Menu menu = orderSystem.initMenu();
        Receipt receipt = startPlanner(menu);
        ResultPlanner(receipt, menu);
    }

    private Receipt startPlanner(Menu menu) {
        outputView.displayPlannerStart();
        VisitDate visitDate = new VisitDate(inputView.validateInputVisitDate());
        outputView.displayAppliedEvent(visitDate);
        outputView.displayMenuList(menu);
        Map<String, Integer> orderMenu = inputView.validateInputMenu(menu);
        outputView.displayVisitDate(visitDate.getVisitDate());
        return orderSystem.initReceipt(visitDate, orderMenu);
    }

    private void ResultPlanner(Receipt receipt, Menu menu) {
        int benefitAmount = 0;
        outputView.displayOrderList(receipt);
        outputView.displayAfterDiscount(receipt, menu);
        outputView.displayGift(receipt, menu);
        benefitAmount = outputView.displayBenefitDetails(receipt, menu);
        outputView.displayTotalBenefit(benefitAmount);
        outputView.displayAfterDiscount(receipt, menu, benefitAmount);
        outputView.displayEventBadge(benefitAmount);
    }
}
