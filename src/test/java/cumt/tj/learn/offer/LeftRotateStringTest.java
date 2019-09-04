package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-6.
 */
public class LeftRotateStringTest {

    LeftRotateString leftRotateString=new LeftRotateString();

    @Test
    public void gcd(){
        assertEquals(leftRotateString.gcd(7,3),1);
        assertEquals(leftRotateString.gcd(6,3),3);
        assertEquals(leftRotateString.gcd(1,3),1);
    }

    @Test
    public void rotate(){
        assertEquals(leftRotateString.LeftRotateString("XYZabcdef",3),"abcdefXYZ");
        assertEquals(leftRotateString.LeftRotateString("XYZabcde",3),"abcdeXYZ");
        assertEquals(leftRotateString.LeftRotateString("XYZabcde",0),"XYZabcde");
        assertEquals(leftRotateString.LeftRotateString("abcdefg",6),"gabcdef");
    }

}
