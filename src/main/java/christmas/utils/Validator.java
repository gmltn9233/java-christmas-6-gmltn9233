package christmas.utils;

import java.util.*;
import java.util.regex.Pattern;
import christmas.enums.ErrorMessage;
import christmas.model.Menu;

public class Validator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final int MINIMUM_DATE = 1;
    private static final int MAXIMUM_DATE = 31;
    private static final int MINIMUM_QUANTITY = 1;
    private static final int MAXIMUM_QUANTITY = 20;

    public static void checkVisitDate(String visitDate){
        validateVisitDateHasText(visitDate);
        validateInteger(visitDate);
    }

    public static Map<String,Integer> checkMenu(String[] menus, Menu menuList){
        Map<String, Integer> orderItems = new HashMap<>();
        for (String menu : menus){
            String[] parts = validateAndSplitMenu(menu);
            String menuName = parts[0].trim();
            String quantity = parts[1].trim();
            checkMenuName(menuName,menuList);
            checkQuantity(quantity);
            validateDuplicate(orderItems,menuName);
            orderItems.put(menuName,Integer.parseInt(quantity));
        }
        onlyBeverage(orderItems,menuList);
        checkItems(orderItems);
        return orderItems;
    }

    private static void checkMenuName(String menuName, Menu menuList){
        validateMenuNameHasText(menuName);
        validateMenuName(menuName,menuList);
    }

    private static void checkQuantity(String quantity){
        validateQuantityHasText(quantity);
        validateQuantityInteger(quantity);
    }

    private static void checkItems(Map<String,Integer> orderItems){
        validateTotalQuantity(orderItems);
    }

    private static void validateVisitDateHasText(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VISIT_DATE.getMessage());
        }
    }
    private static void validateInteger(String input){
        int numericValue;
        try {
            numericValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
        validateRange(input);
    }


    private static void validateRange(String input){
        if(Integer.parseInt(input) < MINIMUM_DATE || Integer.parseInt(input) > MAXIMUM_DATE){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }


    private static String[] validateAndSplitMenu(String menu) {
        if (!menu.contains("-")){
            throw new IllegalArgumentException(ErrorMessage.NOT_SPLIT.getMessage());
        }
        String[] parts = menu.split("-");
        validateSplit(parts);
        return parts;
    }

    private static void validateSplit(String[] parts){
        if(parts.length != 2){
            throw new IllegalArgumentException(ErrorMessage.NOT_SPLIT.getMessage());
        }
    }

    private static void validateMenuName(String input, Menu menu){
        if(!menu.findMenuItem(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_MENU.getMessage());
        }
    }

    private static void validateMenuNameHasText(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MENU_NAME.getMessage());
        }
    }

    private static void validateQuantityHasText(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_QUANTITY.getMessage());
        }
    }
    private static void validateQuantityInteger(String input){
        int numericValue;
        try {
            numericValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_QUANTITY.getMessage());
        }
        validateQuantityRange(input);
    }
    private static void validateQuantityRange(String input){
        if(Integer.parseInt(input) < MINIMUM_QUANTITY){
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_MINIMUM.getMessage());
        }
        if(Integer.parseInt(input) > MAXIMUM_QUANTITY){
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_MAXIMUM.getMessage());
        }
    }

    private static void validateDuplicate(Map<String,Integer>input , String name){
        for(Map.Entry<String,Integer> entry : input.entrySet()){
            String key = entry.getKey();
            if(name.equals(key)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MENU.getMessage());
            }
        }
    }

    private static void validateTotalQuantity(Map<String,Integer> input){
        int total = 0;
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            Integer value = entry.getValue();
            total += value;
            if(total > MAXIMUM_QUANTITY){
                throw new IllegalArgumentException(ErrorMessage.QUANTITY_MAXIMUM.getMessage());
            }
        }
    }

    private static void onlyBeverage(Map<String,Integer> input, Menu menu){
        int count = 0;
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            String category = menu.getMenuCategory(entry.getKey());
            if(category.equals("beverages")){
                ++count;
            }
        }
        if(count == input.size()){
            throw new IllegalArgumentException(ErrorMessage.ONLY_BEVERAGE.getMessage());
        }
    }
}

