package christmas.view;

import christmas.enums.EventMessage;
import christmas.enums.OutputMessage;
import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.OrderMenu;
import christmas.model.Receipt;
import christmas.utils.Calculator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class OutputView {
    public static void displayOrderList(Receipt receipt){
        displayVisitDate(receipt);
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        for(OrderMenu orderMenu : receipt.getOrderMenus() ){
            displayOrder(orderMenu);
        }
        System.out.println();
    }

    public static int displayAfterDiscount(Receipt receipt, Menu menu){
        System.out.println(OutputMessage.BEFORE_DISCOUNT_AMOUNT.getMessage());
        int afterDiscountTotal=Calculator.afterDiscountTotal(receipt,menu);
        System.out.println(formatWon(afterDiscountTotal)+"\n");
        return afterDiscountTotal;
    }

    public static int displayBenefitDetails(Receipt receipt, Menu menu,int beforeDiscountTotal){
        int visitDate = receipt.getVisitDate();
        int benefitmAmount = 0;
        System.out.println(OutputMessage.BENEFIT_DETAILS.getMessage());
        if(Calculator.canEvent(beforeDiscountTotal)){
            benefitmAmount -= displayChristmasEvent(receipt,visitDate);
            benefitmAmount -=displayWeekEvent(receipt,menu,visitDate);
            benefitmAmount -=displayWeekendEvent(receipt,menu,visitDate);
            benefitmAmount -=displaySpecialEvent(receipt,visitDate);
            benefitmAmount -=displayGiftEvent(beforeDiscountTotal);
        }
        if(!Calculator.canEvent(beforeDiscountTotal)){
            System.out.println(EventMessage.NO_EVENT.getEvent());
        }
        System.out.println();
        return benefitmAmount;
    }

    public static void displayTotalBenefit(int totalDiscount){
        System.out.println(OutputMessage.TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.println(formatWon(totalDiscount)+"\n");
    }

    public static void displayAfterDiscount(int beforeDiscount, int totalDiscount){
        int giftPrice = 0;
        System.out.println(OutputMessage.AFTER_DISCOUNT_AMOUNT.getMessage());
        if(Calculator.isGift(beforeDiscount)){
            giftPrice = EventMessage.GIFT_DISCOUNT.getDiscount();
        }
        System.out.println(formatWon(beforeDiscount+totalDiscount+giftPrice)+"\n");
    }

    public static void displayEventBadge(int totalDiscount){
        System.out.println(OutputMessage.EVENT_BADGE.getMessage());
        System.out.println(Calculator.badgeJudge(totalDiscount));
    }

    public static void displayPlannerStart(){
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public static void displayMenuList(Menu menu){
        System.out.println(OutputMessage.MENU_LIST.getMessage());
        displayAppetizers(menu);
        displayMainDishes(menu);
        displayDesserts(menu);
        displayBeverages(menu);
    }

    private static String formatMenu(String name, int price){
        return name+"("+formatWon(price)+")";
    }

    private static void formatMenus(List<String> list){
        System.out.println(String.join(",",list)+"\n");
    }

    private static void displayAppetizers(Menu menu){
        List<String> appetizers = new ArrayList<>();
        System.out.println(OutputMessage.APPETIZERS.getMessage());
        for(MenuItem menuItem : menu.getAllmenuItem()){
            if(menu.getMenuCategory(menuItem.getName())=="appetizers"){
                appetizers.add(formatMenu(menuItem.getName(), menuItem.getPrice()));
            }
        }
        formatMenus(appetizers);
    }

    private static void displayMainDishes(Menu menu){
        List<String> mainDishes = new ArrayList<>();
        System.out.println(OutputMessage.MAIN_DISHES.getMessage());
        for(MenuItem menuItem : menu.getAllmenuItem()){
            if(menu.getMenuCategory(menuItem.getName())=="mainDishes"){
                mainDishes.add(formatMenu(menuItem.getName(), menuItem.getPrice()));
            }
        }
        formatMenus(mainDishes);
    }

    private static void displayDesserts(Menu menu){
        List<String> desserts = new ArrayList<>();
        System.out.println(OutputMessage.DESSERTS.getMessage());
        for(MenuItem menuItem : menu.getAllmenuItem()){
            if(menu.getMenuCategory(menuItem.getName())=="desserts"){
                desserts.add(formatMenu(menuItem.getName(), menuItem.getPrice()));
            }
        }
        formatMenus(desserts);

    }

    private static void displayBeverages(Menu menu){
        List<String> beverages = new ArrayList<>();
        System.out.println(OutputMessage.BEVERAGES.getMessage());
        for(MenuItem menuItem : menu.getAllmenuItem()){
            if(menu.getMenuCategory(menuItem.getName())=="beverages"){
                beverages.add(formatMenu(menuItem.getName(), menuItem.getPrice()));
            }
        }
        formatMenus(beverages);
    }

    private static void displayCombination(String event, int benefit){
        System.out.println(event+": "+formatWon(-benefit));
    }

    private static int displayChristmasEvent(Receipt receipt, int visitDate){
        if(Calculator.isChristmasEvent(visitDate)){
            String event = EventMessage.CHRISTMAS_DISCOUNT.getEvent();
            int benefit = Calculator.christmasEvent(receipt);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayWeekEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekEvent(visitDate)){
            String event = EventMessage.WEEK_DISCOUNT.getEvent();
            int benefit = Calculator.weekEvent(receipt,menu);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayWeekendEvent(Receipt receipt,Menu menu, int visitDate){
        if(Calculator.isWeekendEvent(visitDate)){
            String event = EventMessage.WEEKEND_DISCOUNT.getEvent();
            int benefit = Calculator.weekendEvent(receipt,menu);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displaySpecialEvent(Receipt receipt, int visitDate){
        if(Calculator.isSpecialEvent(visitDate)){
            String event = EventMessage.SPECIAL_DISCOUNT.getEvent();
            int benefit = Calculator.specialEvent(receipt);
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    private static int displayGiftEvent(int afterDiscountTotal){
        if(Calculator.isGift(afterDiscountTotal)){
            String event = EventMessage.GIFT_DISCOUNT.getEvent();
            int benefit = EventMessage.GIFT_DISCOUNT.getDiscount();
            displayCombination(event,benefit);
            return benefit;
        }
        return 0;
    }

    public static void displayGift(int afterDiscountTotal){
        System.out.println(OutputMessage.GIFT_MENU.getMessage());
        System.out.println(isGift(afterDiscountTotal)+"\n");
    }
    private static void displayOrder(OrderMenu orderMenu){
        String name = orderMenu.getName();
        int quantity = orderMenu.getQuantity();
        System.out.println(name+" "+quantity+"개");
    }
    private static void displayVisitDate(Receipt receipt){
        System.out.println("12월 "+receipt.getVisitDate()+OutputMessage.VISIT_DATE.getMessage()+"\n");
    }

    private static String isGift(int amount){
        if(Calculator.isGift(amount)){
            return OutputMessage.YES_GIFT.getMessage();
        }
        return OutputMessage.NO_GIFT.getMessage();
    }

    public static String formatWon(int amount){
        DecimalFormat formatter = new DecimalFormat("#,###,###원");
        return formatter.format(amount);
    }


}
