package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-6.
 */
public class ReverseSentenceTest {

    ReverseSentence re=new ReverseSentence();



    @Test
    public void reverse(){
        assertEquals(re.ReverseSentence("student. a am I"),"I am a student.");
        assertEquals(re.ReverseSentence("student."),"student.");
        assertEquals(re.ReverseSentence(""),"");
        assertEquals(re.ReverseSentence(" ")," ");
        assertEquals(re.ReverseSentence(null),null);
    }

}
