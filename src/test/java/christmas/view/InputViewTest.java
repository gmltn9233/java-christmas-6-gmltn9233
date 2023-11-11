package christmas.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.enums.ErrorMessage;
import christmas.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

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
}