package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.InputMessage;
import christmas.utils.Validator;

public class InputView {

    public static int validateInputVisitDate(){
        int visitDate;
        while(true){
            try{
                String input = inputVisitDate();
                Validator.checkVisitDate(input);
                visitDate = Integer.parseInt(input);
                break;

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return visitDate;
    }
    public static String inputVisitDate(){
        System.out.println(InputMessage.VISIT_DATE_INPUT.getMessage());
        String visitDate = Console.readLine();
        return visitDate;
    }

    public static String[] inputMenu(){
        System.out.println(InputMessage.MENU_INPUT.getMessage());
        String menu = Console.readLine();
        return menu.split(",");
    }
}
