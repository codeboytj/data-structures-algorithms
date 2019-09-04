package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-3.
 */
public class NumberOf1Between1AndNTest {

    NumberOf1Between1AndN numberOf1Between1AndN=new NumberOf1Between1AndN();

    @Test
    public void getNumbers(){

        assertEquals(numberOf1Between1AndN.getNumbers(1),1);
        assertEquals(numberOf1Between1AndN.getNumbers(21),2);
        assertEquals(numberOf1Between1AndN.getNumbers(10),2);
        assertEquals(numberOf1Between1AndN.getNumbers(121),3);

    }

    @Test
    public void setNumberOf1Between1AndN(){

        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(11),4);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(10),2);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(1),1);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(5),1);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(55),16);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(99),20);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(100),21);
        assertEquals(numberOf1Between1AndN.numberOf1Between1AndN(0),0);

    }

}
