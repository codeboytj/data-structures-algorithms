package cumt.tj.learn.structures.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-6-7.
 */
public class QuadraticProbingHashTableTest {

    QuadraticProbingHashTable<String,String> hashTable=new QuadraticProbingHashTable<String, String>();

    @Test
    public void put(){
        hashTable.put("tj","小白");
        hashTable.put("jm","大佬");
        hashTable.put("jm","大牛");
        hashTable.put("ch","大佬");

        System.out.println(hashTable.findPos("tj"));
    }

    @Test
    public void get(){
        hashTable.put("tj","小白");
        hashTable.put("jm","大佬");
        hashTable.put("jm","大牛");
        hashTable.put("ch","大佬");

        assertEquals("小白",hashTable.get("tj"));
        assertEquals("大牛",hashTable.get("jm"));
        assertEquals("大佬",hashTable.get("ch"));
    }
    @Test
    public void containsAndRemove(){
        assertTrue(!hashTable.contains("tj"));
        assertTrue(!hashTable.contains("jm"));
        assertTrue(!hashTable.contains("ch"));

        hashTable.put("tj","小白");
        hashTable.put("jm","大佬");
        hashTable.put("jm","大牛");
        hashTable.put("ch","大佬");

        assertTrue(hashTable.contains("tj"));
        hashTable.remove("tj");
        assertTrue(!hashTable.contains("tj"));

        assertTrue(hashTable.contains("jm"));
        hashTable.remove("jm");
        assertTrue(!hashTable.contains("jm"));

        assertTrue(hashTable.contains("ch"));
        hashTable.remove("ch");
        assertTrue(!hashTable.contains("ch"));
    }

}
