package cumt.tj.learn.structures.hash;

import cumt.tj.learn.structures.hash.SeparateChainingHashTable;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sky on 17-6-3.
 * 数据结构与算法分析java版，第5章散列
 * 通过分离链表法解决冲突
 */
public class SeparateChainingHashTableTest {

    SeparateChainingHashTable separateChainingHashTable=new SeparateChainingHashTable();

    @Test
    public void put(){
        separateChainingHashTable.put("sky","tj");
        separateChainingHashTable.put("jm","dalao");
        separateChainingHashTable.put("jm","dalao11");
        separateChainingHashTable.put("ch","dalao");
    }

    @Test
    public void get(){
        separateChainingHashTable.put("sky","tj");
        separateChainingHashTable.put("jm","dalao");
        separateChainingHashTable.put("jm","dalao11");
        separateChainingHashTable.put("ch","dalao");
        assertEquals("tj",separateChainingHashTable.get("sky"));
        assertEquals("dalao11",separateChainingHashTable.get("jm"));
        assertEquals("dalao",separateChainingHashTable.get("ch"));
        assertEquals(null,separateChainingHashTable.get("ch1"));
    }

    @Test
    public void remove(){
        separateChainingHashTable.put("sky","tj");
        separateChainingHashTable.put("jm","dalao");
        separateChainingHashTable.put("jm","dalao11");
        separateChainingHashTable.put("ch","dalao");

        assertEquals("tj",separateChainingHashTable.get("sky"));
        separateChainingHashTable.remove("sky");
        assertEquals(null,separateChainingHashTable.get("sky"));

        assertEquals("dalao11",separateChainingHashTable.get("jm"));
        separateChainingHashTable.remove("jm");
        assertEquals(null,separateChainingHashTable.get("jm"));

        assertEquals("dalao",separateChainingHashTable.get("ch"));
        separateChainingHashTable.remove("ch");
        assertEquals(null,separateChainingHashTable.get("ch"));

    }

    @Test
    public void isPrime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //利用反射机制，调用私有方法
        Class c=separateChainingHashTable.getClass();
        //getDeclaredMethod可以返回非public方法，而getMethod只能返回public方法
        Method m=c.getDeclaredMethod("isPrime",int.class);
        //抑制java的访问权限控制检查
        m.setAccessible(true);
        //调用实例separateChainingHashTable的私有方法
        assertTrue((Boolean)m.invoke(separateChainingHashTable,2));
        assertTrue(!(Boolean)m.invoke(separateChainingHashTable,1));
        assertTrue(!(Boolean)m.invoke(separateChainingHashTable,4));
        assertTrue((Boolean)m.invoke(separateChainingHashTable,11));
    }

    @Test
    public void nextPrime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //利用反射机制，调用私有方法
        Class c=separateChainingHashTable.getClass();
        //getDeclaredMethod可以返回非public方法，而getMethod只能返回public方法
        Method m=c.getDeclaredMethod("nextPrime",int.class);
        //抑制java的访问权限控制检查
        m.setAccessible(true);
        //调用实例separateChainingHashTable的私有方法
        assertEquals(Integer.valueOf(5),m.invoke(separateChainingHashTable,4));
        assertEquals(Integer.valueOf(101),m.invoke(separateChainingHashTable,101));
    }

    @Test
    public void testListAdd() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class[] cs=separateChainingHashTable.getClass().getDeclaredClasses();
        Class nodeClass=null;
        for(int i=0;i<cs.length;i++){
            if (cs[i].getName()=="cumt.tj.learn.structures.hash.SeparateChainingHashTable$Node") nodeClass=cs[i];
        }
        List<HashMap<String,String>> hashMapList=new LinkedList<HashMap<String, String>>();
        List<Object> ol=new LinkedList<Object>();
        Constructor[] constructors=nodeClass.getConstructors();

        Constructor nodeConstruction=constructors[0];
        nodeConstruction.setAccessible(true);
        ol.add(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha"));
        ol.add(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha1"));
        ol.add(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha3"));
        assertTrue(ol.contains(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha1")));
        assertTrue(ol.contains(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha")));
        assertTrue(ol.contains(nodeConstruction.newInstance(separateChainingHashTable,"jm","haha3")));
//        ol.add(nodeClass.newInstance());
    }
}
