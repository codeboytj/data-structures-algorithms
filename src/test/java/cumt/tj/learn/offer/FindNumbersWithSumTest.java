package cumt.tj.learn.offer;

import org.junit.Test;

/**
 * Created by sky on 17-8-6.
 */
public class FindNumbersWithSumTest {

    FindNumbersWithSum findNumbersWithSum=new FindNumbersWithSum();

    @Test
    public void findNumbers(){

        System.out.print(findNumbersWithSum.FindNumbersWithSum(new int[]{1,2,4,7,11,15},15));
        System.out.print(findNumbersWithSum.FindNumbersWithSum(new int[]{},15));
        System.out.print(findNumbersWithSum.FindNumbersWithSum(null,15));

    }

}
