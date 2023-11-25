import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_71() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_72() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_73() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_74() {
        assertEquals(15, str.add("1,2,3,4\n5"));
    }
    @Test
    public void test_75(){
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3,4,\n5"));
    }
    @Test
    public void test_76() {
        assertEquals(15, str.add("//[*]\n1*2*3*4*5"));
    }
    @Test
    public void test_77() {
        assertEquals(21, str.add("//[*]\n1,2,3*4\n5*6"));
    }
    @Test
    public void test_78(){
        assertThrows(IllegalArgumentException.class, () -> str.add("//[*]\n-1,-2,3,-4,\n5"));
    }
    @Test
    public void test_79() {
        assertEquals(15, str.add("//[*]\n1,2,3*4\n5*6444"));
    }
    @Test
    public void test_710() {
        assertEquals(20, str.add("//[***]\n1,2,3***4\n5***5"));
    }


}