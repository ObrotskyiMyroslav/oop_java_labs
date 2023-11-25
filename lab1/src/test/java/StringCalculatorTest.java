import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_31() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_32() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_33() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_34() {
        assertEquals(15, str.add("1,2,3,4\n5"));
    }
    @Test
    public void test_35(){
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3,4,\n5"));
    }

}