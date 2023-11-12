package christmas.model;

import christmas.enums.ErrorMessage;
import christmas.enums.MenuItemList;
import net.bytebuddy.implementation.attribute.AnnotationAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderSystem {
    public static Menu initMenu(){
        Menu menu = new Menu(initMenuItem());
        return menu;
    }

    public static Receipt initReceipt(int visitDate, Map<String,Integer> menu){
        List<OrderMenu> orderMenus = convertMenu(menu);
        Receipt receipt = new Receipt(visitDate,orderMenus);
        return receipt;
    }

    private static List<OrderMenu> convertMenu(Map<String,Integer> input){
        List<OrderMenu> orderMenus = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            OrderMenu orderMenu = new OrderMenu(key,value);
            orderMenus.add(orderMenu);
        }
        return orderMenus;
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
