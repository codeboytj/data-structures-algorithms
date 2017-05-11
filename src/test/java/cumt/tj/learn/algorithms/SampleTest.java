package cumt.tj.learn.algorithms;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by sky on 17-5-10.
 */
public class SampleTest {
    @Test
    public void simpleSampleTest(){
        Sample sample=new Sample();
        int n=5;
        assertThat(sample.bigRand(n),allOf(greaterThan(n)));
    }
}
