import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator str = new StringCalculator();

    @Test
    public void test_81() {
        assertEquals(0, str.add(""));
    }

    @Test
    public void test_82() {
        assertEquals(1, str.add("1"));
    }
    @Test
    public void test_83() {
        assertEquals(3, str.add("1,2"));
    }
    @Test
    public void test_84() {
        assertEquals(15, str.add("1,2,3,4\n5"));
    }
    @Test
    public void test_85(){
        assertThrows(IllegalArgumentException.class, () -> str.add("1,2,3,4,\n5"));
    }
    @Test
    public void test_86() {
        assertEquals(15, str.add("//[*]\n1*2*3*4*5"));
    }
    @Test
    public void test_87() {
        assertEquals(21, str.add("//[*]\n1,2,3*4\n5*6"));
    }
    @Test
    public void test_88(){
        assertThrows(IllegalArgumentException.class, () -> str.add("//[*]\n-1,-2,3,-4,\n5"));
    }
    @Test
    public void test_89() {
        assertEquals(15, str.add("//[*]\n1,2,3*4\n5*6444"));
    }
    @Test
    public void test_810() {
        assertEquals(20, str.add("//[***]\n1,2,3***4\n5***5"));
    }
    @Test
    public void test_811() {
        assertEquals(24, str.add("//[;;;][!!!][###]\n1!!!2;;;3###4000!!!5,6\n7"));
    }


}