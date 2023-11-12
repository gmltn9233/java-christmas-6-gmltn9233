package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.model.Receipt;
import christmas.view.InputView;

public class Controller {
    public static void orderStart(){
        Menu menu = OrderSystem.initMenu();
        Receipt receipt = OrderSystem
                .initReceipt(InputView.validateInputVisitDate(),InputView.validateInputMenu(menu));
    }
}
