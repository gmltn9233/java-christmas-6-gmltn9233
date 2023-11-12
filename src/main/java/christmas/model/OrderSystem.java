package christmas.model;

import christmas.enums.MenuItemList;
import christmas.model.Menu;
import java.util.ArrayList;
import java.util.List;

public class OrderSystem {
    public static Menu initMenu(){
        Menu menu = new Menu(initMenuItem());
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
