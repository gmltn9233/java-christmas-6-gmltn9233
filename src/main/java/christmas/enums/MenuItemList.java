package christmas.enums;

import christmas.model.MenuItem;

public enum MenuItemList {
    MUSHROOM_SOUP("양송이수프", 6000, "appetizers"),
    TAPAS("타파스", 5500, "appetizers"),
    CAESAR_SALAD("시저샐러드", 8000, "appetizers"),
    T_BONE_STEAK("티본스테이크", 55000, "mainDishes"),
    BBQ_RIBS("바비큐립", 54000, "mainDishes"),
    SEAFOOD_PASTA("해산물파스타", 35000, "mainDishes"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "mainDishes"),
    CHOCOLATE_CAKE("초코케이크", 15000, "desserts"),
    ICE_CREAM("아이스크림", 15000, "desserts"),
    ZERO_COKE("제로콜라", 3000, "beverages"),
    RED_WINE("레드와인", 60000, "beverages"),
    CHAMPAGNE("샴페인", 25000, "beverages");

    private final String menuName;
    private final int price;
    private final String category;

    MenuItemList(String menuName, int price, String category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
