package cumt.tj.learn.offer;

import org.junit.Test;

/**
 * Created by sky on 17-8-6.
 */
public class FindContinuousSequenceTest {

    FindContinuousSequence findContinuousSequence=new FindContinuousSequence();

    @Test
    public void find(){
        System.out.print(findContinuousSequence.FindContinuousSequence(15));
        System.out.print(findContinuousSequence.FindContinuousSequence(1));
        System.out.print(findContinuousSequence.FindContinuousSequence(0));
        System.out.print(findContinuousSequence.FindContinuousSequence(2));
        System.out.print(findContinuousSequence.FindContinuousSequence(100));
    }

}
