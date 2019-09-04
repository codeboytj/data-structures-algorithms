package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sky on 17-8-29.
 */
public class HasPathTest {

    @Test
    public void hasPath(){

        HasPath hp=new HasPath();

        assertTrue(hp.hasPath(new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'},3,4,new char[]{'b','c','c','e','d'}));
        assertTrue(!hp.hasPath(new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'},3,4,new char[]{'a','b','c','b'}));
        assertTrue(!hp.hasPath(new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'},3,4,new char[]{'a','b','c','d'}));
        assertTrue(hp.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),5,8,"SLHECCEIDEJFGGFIE".toCharArray()));

    }

}
