package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-10.
 */
public class IsNumericTest {

    @Test
    public void isNumeric(){

        IsNumeric isNumeric=new IsNumeric();
        assertEquals(isNumeric.isNumeric("600.0".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("123.45e+6".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("+100".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("5e2".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("-123".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("3.1416".toCharArray()),true);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("-1E-16".toCharArray()),true);

        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("12e".toCharArray()),false);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("1a3.14".toCharArray()),false);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("1.2.3".toCharArray()),false);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("+-5".toCharArray()),false);
        isNumeric.pos=0;
        assertEquals(isNumeric.isNumeric("12e+5.4".toCharArray()),false);

    }

}
