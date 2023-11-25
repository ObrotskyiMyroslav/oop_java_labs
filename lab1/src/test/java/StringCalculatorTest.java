import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_51() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_52() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_53() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_54() {
        assertEquals(15, str.add("1,2,3,4\n5"));
    }
    @Test
    public void test_55(){
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3,4,\n5"));
    }
    @Test
    public void test_56() {
        assertEquals(15, str.add("//[*]\n1*2*3*4*5"));
    }
    @Test
    public void test_57() {
        assertEquals(21, str.add("//[*]\n1,2,3*4\n5*6"));
    }
    @Test
    public void test_58(){
        assertThrows(IllegalArgumentException.class, () -> str.add("//[*]\n-1,-2,3,-4,\n5"));
    }


}