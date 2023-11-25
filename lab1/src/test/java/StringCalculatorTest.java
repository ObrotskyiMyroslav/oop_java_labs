import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_21() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_22() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_23() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_24() {
        assertEquals(15, str.add("1,2,3,4,5"));
    }

}