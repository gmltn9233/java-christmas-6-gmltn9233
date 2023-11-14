package christmas.model;

import java.util.List;

public class Receipt {
    private final int visitDate;
    private final List<OrderMenu> orderMenus;

    public Receipt(int visitDate, List<OrderMenu> orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }
}
