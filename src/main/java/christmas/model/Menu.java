package christmas.model;

import christmas.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menu;

    public Menu(List<MenuItem> menu){
        this.menu = menu;
    }

    public boolean findMenuItem(String name){
        for(MenuItem item : getAllmenuItem()){
            if(item.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public int getMenuPrice(String name){
        for(MenuItem item : getAllmenuItem()){
            if(item.getName().equals(name)){
                return item.getPrice();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_IN_MENU.getMessage());
    }

    public String getMenuCategory(String name){
        for(MenuItem item : getAllmenuItem()){
            if(item.getName().equals(name)){
                return item.getCategory();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_IN_MENU.getMessage());
    }

    public List<MenuItem> getAllmenuItem(){
        List<MenuItem> allItems = new ArrayList<>();
        allItems.addAll(menu);
        return allItems;
    }
}
