package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-9.
 */
public class StrToIntTest {

    @Test
    public void strToInt(){

        StrToInt strToInt=new StrToInt();
        assertEquals(strToInt.StrToInt("+2147483647"),2147483647);
        assertEquals(strToInt.StrToInt("-2147483647"),-2147483647);
        assertEquals(strToInt.StrToInt(""),0);
        assertEquals(strToInt.StrToInt("7"),7);
        assertEquals(strToInt.StrToInt("-7"),-7);
        assertEquals(strToInt.StrToInt("0"),0);
        assertEquals(strToInt.StrToInt(null),0);

    }

}
