package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.InputMessage;
import christmas.model.Menu;
import christmas.utils.Validator;

import java.util.HashMap;
import java.util.Map;

public class InputView {

    public int validateInputVisitDate() {
        int visitDate;
        while (true) {
            try {
                String input = inputVisitDate();
                Validator.checkVisitDate(input);
                visitDate = Integer.parseInt(input);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return visitDate;
    }

    public Map<String, Integer> validateInputMenu(Menu menu) {
        Map<String, Integer> orderList = new HashMap<>();
        while (true) {
            try {
                Map<String, Integer> inputList = new HashMap<>();
                String[] input = inputMenu();
                inputList = Validator.checkMenu(input, menu);
                orderList = inputList;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderList;
    }

    public String inputVisitDate() {
        System.out.println(InputMessage.VISIT_DATE_INPUT.getMessage());
        String visitDate = Console.readLine();
        return visitDate;
    }

    public String[] inputMenu() {
        System.out.println(InputMessage.MENU_INPUT.getMessage());
        String menu = Console.readLine();
        return menu.split(",");
    }
}
