package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.view.InputView;

public class Controller {
    public static void orderStart(){
        Menu menu = OrderSystem.initMenu();
        InputView.validateInputMenu(menu);
    }
}
