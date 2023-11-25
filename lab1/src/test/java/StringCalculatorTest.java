import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_11() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_12() {
        assertEquals(1, str.add("1"));
    }

    @Test
    public void test_13() {
        assertEquals(3, str.add("1,2"));
    }

    @Test
    public void test_14() {
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3"));
    }
}
