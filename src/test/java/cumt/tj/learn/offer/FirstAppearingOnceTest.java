package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-14.
 */
public class FirstAppearingOnceTest {

    @Test
    public void firstAppear(){

        FirstAppearingOnce fa=new FirstAppearingOnce();

        fa.Insert('g');
        assertEquals(fa.FirstAppearingOnce(),'g');

        fa.Insert('o');
        assertEquals(fa.FirstAppearingOnce(),'g');

        fa.Insert('o');
        assertEquals(fa.FirstAppearingOnce(),'g');

        fa.Insert('g');
        assertEquals(fa.FirstAppearingOnce(),'#');

        fa.Insert('l');
        assertEquals(fa.FirstAppearingOnce(),'l');

        fa.Insert('e');
        assertEquals(fa.FirstAppearingOnce(),'l');
    }

}
