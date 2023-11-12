package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderSystem;

public class Controller {
    public static void orderStart(){
        Menu menu = OrderSystem.initMenu();
    }
}
