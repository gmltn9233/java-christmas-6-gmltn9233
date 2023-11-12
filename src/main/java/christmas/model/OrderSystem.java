package christmas.model;

import christmas.enums.MenuItemList;

import java.util.ArrayList;
import java.util.List;

public class OrderSystem {
    public static Menu initMenu(){
        Menu menu = initMenu();
        return menu;
    }

    private static List<MenuItem> initMenuItem(){
        List<MenuItem> menu = new ArrayList<>();
        for(MenuItemList menuItem : MenuItemList.values()){
            MenuItem menuItems = new MenuItem(menuItem.getMenuName(),menuItem.getPrice(),menuItem.getCategory());
            menu.add(menuItems);
        }
        return menu;
    }

}
