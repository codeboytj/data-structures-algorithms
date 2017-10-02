package cumt.tj.learn.offer.baidu;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-10-2.
 */
public class AtoiTest {

    @Test
    public void atoi(){

        Atoi atoi=new Atoi();
        assertEquals(atoi.atoi("  123"),123);
        assertEquals(atoi.atoi("  -123"),-123);
        assertEquals(atoi.atoi("  -123aba12"),-123);
        assertEquals(atoi.atoi("  -+123"),0);
        assertEquals(atoi.atoi("  +123"),123);
        assertEquals(atoi.atoi("  +123ab"),123);

    }

}
