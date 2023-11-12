package christmas.model;

public class OrderMenu {
    private final String name;
    private final int quantity;
    public OrderMenu(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }
}
