package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-4.
 */
public class FirstNotRepeatingCharTest {

    FirstNotRepeatingChar firstNotRepeatingChar=new FirstNotRepeatingChar();

    @Test
    public void firstPositin(){

        assertEquals(firstNotRepeatingChar.firstNotRepeatingChar(""),-1);
        assertEquals(firstNotRepeatingChar.firstNotRepeatingChar(null),-1);
        assertEquals(firstNotRepeatingChar.firstNotRepeatingChar("abaccdeff"),1);
        assertEquals(firstNotRepeatingChar.firstNotRepeatingChar("aaccdeff"),4);
        assertEquals(firstNotRepeatingChar.firstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"),1);

    }

}
