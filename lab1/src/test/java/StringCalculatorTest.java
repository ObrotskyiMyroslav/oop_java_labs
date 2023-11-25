import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_41() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_42() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_43() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_44() {
        assertEquals(15, str.add("1,2,3,4\n5"));
    }
    @Test
    public void test_45(){
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3,4,\n5"));
    }
    @Test
    public void test_46() {
        assertEquals(15, str.add("//[*]\n1*2*3*4*5"));
    }
    @Test
    public void test_47() {
        assertEquals(21, str.add("//[*]\n1,2,3*4\n5*6"));
    }

}