package cumt.tj.learn.algorithms.sort;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by sky on 17-4-26.
 */
public class BitArraySortTest {
    /**
     * 生成一个文本文件，文件中包含很多7位数的整数。但是这些整数没有重复的。
     */
    @Test
    public void writeFile() throws IOException{

        int j;
        //建立set，主要是防止重复
        Set<Integer> integerHashSet=new HashSet<Integer>();
        BufferedWriter out = null;
        out =new BufferedWriter(new FileWriter("./test.txt"));
        for(int i=0;i<=1000000;i++){
            //1.生成随机不重复的7位数整数
            Random random=new Random();
            j=1000000+random.nextInt(8999999);
            //2.为了保证不重复，写入Set
            if(integerHashSet.add(j)){
                //3.写入文件
                out.write(Integer.toString(j)+"\n");
            }
        }
        out.close();
    }

    @Test
    public void sortTest() throws IOException {
        BitArraySort bitArraySort=new BitArraySort();
        //bitArraySort.sort("./test1.txt",10000000,"result1.txt");
        bitArraySort.sort("./test.txt",10000000,"result.txt");
    }
}
