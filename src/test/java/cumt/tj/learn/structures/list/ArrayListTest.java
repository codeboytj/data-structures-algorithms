package cumt.tj.learn.structures.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-7-3.
 */
public class ArrayListTest {

    MyArrayList<String> theList=new MyArrayList<String>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void size(){
        MyArrayList theList1=new MyArrayList();
        assertEquals(0,theList1.size());

        MyArrayList theList2=new MyArrayList(14);
        assertEquals(0,theList1.size());
    }

    @Test
    public void add(){
        theList.add("我是第1个");
        theList.add("我是第2个");
        theList.add("我是第3个");
        assertEquals(3,theList.size());

        theList.add(2,"我是第2个");
        assertEquals(4,theList.size());
    }

    @Test
    public void remove(){
        theList.add("我是第1个");
        theList.add("我是第2个");
        theList.add("我是第3个");
        assertEquals(3,theList.size());

        assertEquals("我是第3个",theList.remove());
        assertEquals(2,theList.size());

        theList.add("我是第4个");
        assertEquals("我是第4个",theList.remove(2));
        assertEquals(2,theList.size());

        assertEquals("我是第1个",theList.remove(0));
        assertEquals(1,theList.size());
    }

    @Test
    public void get(){
        add();
        assertEquals("我是第1个",theList.get(0));
        assertEquals("我是第2个",theList.get(1));
        assertEquals("我是第2个",theList.get(2));

        theList.remove(0);
        assertEquals("我是第2个",theList.get(0));
        assertEquals("我是第2个",theList.get(1));

    }

    @Test
    public void set(){
        add();
        assertEquals("我是第1个",theList.set(0,"我是新的第一个"));
        assertEquals("我是第2个",theList.set(1,"我是新的第二个"));
        assertEquals("我是新的第二个",theList.get(1));
    }

    @Test
    public void enlarge(){
        theList.add("我是第1个");
        theList.add("我是第2个");
        theList.add("我是第3个");
        theList.add("我是第4个");
        theList.add("我是第5个");
        theList.add("我是第6个");
        theList.add("我是第7个");
        theList.add("我是第8个");
        theList.add("我是第9个");
        theList.add("我是第10个");
        theList.add("我是第11个");
        theList.add("我是第12个");

        assertEquals(12,theList.size());
        assertEquals(theList.get(4),"我是第5个");
    }

    @Test
    public void addBug(){

        theList.add("我是第1个");
        theList.add("我是第2个");
        theList.add("我是第3个");
        theList.add("我是第4个");
        theList.add("我是第5个");
        theList.add("我是第6个");
        theList.add(6,"我是第7个");

        thrown.expect(IndexOutOfBoundsException.class);
        assertEquals(theList.get(9),"我是第7个");
    }

    @Test
    public void iterator(){
        add();

        Iterator<String> iterator=theList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String s:theList) {
            System.out.println(s);
        }
    }
}
