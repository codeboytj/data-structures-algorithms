package cumt.tj.learn.structures.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-7-4.
 */
public class LinkedListTest {

    MyList<Integer> theList=new MyLinkedList<Integer>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void add(){

        theList.add(0);
        theList.add(1);
        theList.add(2);
        theList.add(3);
        theList.add(4);

    }

    @Test
    public void get(){
        add();

        assertEquals(Integer.valueOf(0),theList.get(0));
        assertEquals(Integer.valueOf(1),theList.get(1));
        assertEquals(Integer.valueOf(2),theList.get(2));
        assertEquals(Integer.valueOf(3),theList.get(3));
        assertEquals(Integer.valueOf(4),theList.get(4));
    }

    @Test
    public void set(){
        add();

        theList.set(0,2);
        theList.set(1,3);
        theList.set(2,4);
        theList.set(3,5);
        theList.set(4,6);
        assertEquals(Integer.valueOf(2),theList.get(0));
        assertEquals(Integer.valueOf(3),theList.get(1));
        assertEquals(Integer.valueOf(4),theList.get(2));
        assertEquals(Integer.valueOf(5),theList.get(3));
        assertEquals(Integer.valueOf(6),theList.get(4));
    }

    @Test
    public void remove(){
        add();

        theList.remove(0);
        assertEquals(Integer.valueOf(1),theList.get(0));

        theList.remove(1);
        assertEquals(Integer.valueOf(3),theList.get(1));
    }

    @Test
    public void size(){

        add();

        assertEquals(5,theList.size());

        theList.remove(0);
        assertEquals(4,theList.size());

        theList.remove(1);
        assertEquals(3,theList.size());
    }

    @Test
    public void exception(){

        thrown.expect(IndexOutOfBoundsException.class);
        theList.add(1,1);
        theList.add(-1,1);
        theList.get(-1);
        theList.get(0);
        theList.remove(0);
        theList.remove(-1);
        theList.remove(1);

    }

    @Test
    public void iterator(){
        add();
        for (Integer i:theList
             ) {
            System.out.println(i);
        }
    }
}
