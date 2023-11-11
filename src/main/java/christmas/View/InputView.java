package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Enums.InputMessage;

public class InputView {
    public static String inputVisitDate(){
        System.out.println(InputMessage.VISIT_DATE_INPUT.getMessage());
        String visit_date = Console.readLine();
        return visit_date;
    }

    public static String inputMenu(){
        System.out.println(InputMessage.MENU_INPUT.getMessage());
        String visit_date = Console.readLine();
        return visit_date;
    }
}
