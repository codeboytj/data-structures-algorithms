package cumt.tj.learn.structures.tree;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-9-21.
 */
public class AVLTreeTest {

    @Test
    public void insert(){
        AVLTree<Integer> avl=new AVLTree<Integer>();

        avl.insert(7);
        assertEquals(avl.height(),1);

        avl.insert(6);
        assertEquals(avl.height(),2);

        avl.insert(5);
        assertEquals(avl.height(),2);

        avl.insert(4);
        assertEquals(avl.height(),3);

        avl.insert(3);
        assertEquals(avl.height(),3);

        avl.insert(2);
        assertEquals(avl.height(),3);

        avl.insert(1);
        assertEquals(avl.height(),3);

        avl.insert(0);
        assertEquals(avl.height(),4);

    }

}
