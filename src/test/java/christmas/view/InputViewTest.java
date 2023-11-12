package christmas.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.enums.ErrorMessage;
import christmas.model.Menu;
import christmas.model.OrderSystem;
import christmas.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    Menu menu = OrderSystem.initMenu();

    @DisplayName("방문날짜가 비어있으면 예외가 발생한다.")
    @Test
    void testValidateVisitDatehasText(){
        String input = "";
        assertThatThrownBy(()-> Validator.checkVisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_VISIT_DATE.getMessage());
    }

    @DisplayName("방문날짜가 숫자가 아니면 예외가 발생한다.")
    @Test
    void testValidateInteger(){
        String input = "a";
        assertThatThrownBy(()-> Validator.checkVisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER.getMessage());
    }

    @DisplayName("방문날짜가 1보다 작으면 예외가 발생한다.")
    @Test
    void testValidateInRange1(){
        String input = "-1";
        assertThatThrownBy(()-> Validator.checkVisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RANGE.getMessage());
    }

    @DisplayName("방문날짜가 31보다 크면 예외가 발생한다.")
    @Test
    void testValidateInRange2(){
        String input = "32";
        assertThatThrownBy(()-> Validator.checkVisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RANGE.getMessage());
    }
    @DisplayName("메뉴판에 없는 메뉴를 입력하는 경우 예외가 발생한다.")
    @Test
    void testValidateNotInMenu(){
        String[] input = {"타파스-1","제로콜라-1","제로펩시-3"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_MENU.getMessage());
    }
    @DisplayName("메뉴 입력이 비어있는 경우 예외가 발생한다.")
    @Test
    void testValidateEmptyMenu(){
        String[] input = {"-1","제로콜라-1"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_MENU_NAME.getMessage());
    }
    @DisplayName("메뉴 수량 입력이 비어있는 경우 예외가 발생한다.")
    @Test
    void testValidateEmptyQuantity(){
        String[] input = {"타파스- ","제로콜라-1"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_QUANTITY.getMessage());
    }

    @DisplayName("유효하지않은 주문 형식일 경우 예외가 발생한다.")
    @Test
    void testValidateSplit(){
        String[] input = {"타파스하나주세요"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_SPLIT.getMessage());
    }

    @DisplayName("메뉴의 개수가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void testValidateMinimumQuantity(){
        String[] input = {"타파스-0","제로콜라-1"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.QUANTITY_MINIMUM.getMessage());
    }

    @DisplayName("단일 메뉴의 개수가 20보다 클 경우 예외가 발생한다.")
    @Test
    void testValidateMaximumQuantity1(){
        String[] input = {"타파스-21","제로콜라-1"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.QUANTITY_MAXIMUM.getMessage());
    }

    @DisplayName("메뉴의 총 개수가 20보다 클 경우 예외가 발생한다.")
    @Test
    void testValidateMaximumQuantity2(){
        String[] input = {"타파스-7","제로콜라-14"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.QUANTITY_MAXIMUM.getMessage());
    }

    @DisplayName("메뉴가 중복되었을 경우 예외가 발생한다.")
    @Test
    void testValidateDuplicatedMenu(){
        String[] input = {"타파스-3","제로콜라-2","타파스-4"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_MENU.getMessage());
    }

    @DisplayName("음료만 주문 하였을 경우 예외가 발생한다.")
    @Test
    void testOnlyBeverage(){
        String[] input = {"레드와인-3","제로콜라-2"};
        assertThatThrownBy(()-> Validator.checkMenu(input,menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ONLY_BEVERAGE.getMessage());
    }


}