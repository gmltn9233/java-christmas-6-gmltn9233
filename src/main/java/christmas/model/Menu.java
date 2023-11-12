package christmas.model;

import java.util.List;

public class Menu {
    private List<MenuItem> appetizers;
    private List<MenuItem> mainDishes;
    private List<MenuItem> desserts;
    private List<MenuItem> beverages;

    public Menu(List<MenuItem> appetizers, List<MenuItem> mainDishes, List<MenuItem> desserts, List<MenuItem> beverages ){
        this.appetizers = appetizers;
        this.mainDishes = mainDishes;
        this.desserts = desserts;
        this.beverages = beverages;
    }
}
