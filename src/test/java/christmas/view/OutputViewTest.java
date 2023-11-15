package christmas.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("#,###원 테스트")
    @Test
    void testFormatWon1() {
        int number = 1000;
        assertEquals("1,000원", outputView.formatWon(number));
    }

    @DisplayName("##,###원 테스트")
    @Test
    void testFormatWon2() {
        int number = 10000;
        assertEquals("10,000원", outputView.formatWon(number));
    }

    @DisplayName("###,###원 테스트")
    @Test
    void testFormatWon3() {
        int number = 100000;
        assertEquals("100,000원", outputView.formatWon(number));
    }

    @DisplayName("#,###,###원 테스트")
    @Test
    void testFormatWon4() {
        int number = 1000000;
        assertEquals("1,000,000원", outputView.formatWon(number));
    }

}
