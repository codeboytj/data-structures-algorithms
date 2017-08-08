package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-8.
 */
public class AddTest {

    Add add=new Add();

    @Test
    public void add(){
        assertEquals(add.add(0,0),0);
        assertEquals(add.add(1,0),1);
        assertEquals(add.add(5,6),11);
    }

}
