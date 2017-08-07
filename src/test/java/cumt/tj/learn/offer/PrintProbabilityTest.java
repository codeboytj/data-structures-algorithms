package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-7.
 */
public class PrintProbabilityTest {

    PrintProbability printProbability=new PrintProbability();

    @Test
    public void division(){

        int capcity=13;
        capcity=(int)Math.floor(capcity/0.75);
        System.out.print(capcity);

    }

    @Test
    public void getCapcity(){

        assertEquals(printProbability.mapCapcity(0),0);
        assertEquals(printProbability.mapCapcity(1),2);
        assertEquals(printProbability.mapCapcity(13),32);

    }

    @Test
    public void getProbalitiy(){

        System.out.print(printProbability.getProbability(2));

    }

}
