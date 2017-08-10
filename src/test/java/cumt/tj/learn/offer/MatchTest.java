package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-10.
 */
public class MatchTest {

    @Test
    public void match(){

        Match match=new Match();
        assertEquals(match.match(new char[]{'a','a','a'},new char[]{'a','a','.','a'}),false);
        assertEquals(match.match(new char[]{'a','a'},new char[]{'a','*'}),true);
        assertEquals(match.match(new char[]{},new char[]{'.','*'}),true);
        assertEquals(match.match(new char[]{'a','a','a'},new char[]{'a','b','*','a','*','c','*','a'}),true);
        assertEquals(match.match(new char[]{'a'},new char[]{'a','b','*','a'}),false);
        assertEquals(match.match(new char[]{'a','a','a'},new char[]{'a','b','*','a'}),false);
        assertEquals(match.match(new char[]{'a','a','a'},new char[]{'a','.','a'}),true);
        assertEquals(match.match(new char[]{},new char[]{}),true);
        assertEquals(match.match(null,new char[]{'.','*'}),false);
        assertEquals(match.match(null,null),false);

    }

}
