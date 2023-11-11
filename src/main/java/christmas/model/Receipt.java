package christmas.model;

import java.util.List;

public class Receipt {
    private final int visitDate;
    private final List<Menu> menus;

    public Receipt(int visitDate, List<Menu> menus){
        this.visitDate = visitDate;
        this.menus = menus;
    }

}
