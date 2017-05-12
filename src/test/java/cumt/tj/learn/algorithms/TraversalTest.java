package cumt.tj.learn.algorithms;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sky on 17-5-12.
 */
public class TraversalTest {
    @Test
    public void fileTest(){
        File path=new File(".");
        String[] fileList=path.list();
        File[] childFiles=path.listFiles();
        for (File f:childFiles){
            if (f.isDirectory()){
                System.out.println(f.getName());
            }
        }
    }

    @Test
    public void preorderTraversalTest(){
        Traversal traversal=new Traversal();

        /*
        正则表达式^[.].+?表示以.开始，后面跟至少一个char的字符串
        第一个点用[]括起来，表示"."符号;相应的^[.]表示以.开头
        第二个点赤裸着，表示匹配任意字符;相应的.+?表示至少一个任意字符
        匹配的是隐藏文件或文件夹
         */
        traversal.printFilePath(".",new DirFilter("^[.].+?"));
    }

    @Test
    public void postorderTraversalTest(){
        Traversal traversal=new Traversal();
        System.out.println(traversal.size("./build.gradle")+"B");
        System.out.println(traversal.size("./gradlew")+"B");
        System.out.println(traversal.size("./build")+"B");
    }

    @Test
    public void regexTest(){

        Pattern pattern;
        pattern=Pattern.compile("^[.].+?");
        //过滤掉符合正则表达式的
        assertTrue(pattern.matcher(".git").matches());
        assertTrue(pattern.matcher(".idea").matches());
        assertTrue(!pattern.matcher("idea").matches());
    }

    @Test
    public void filePathLenTest(){

        File path=new File(".");
        assertNotEquals(path.length(),new Traversal().size("."));
    }

}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern=Pattern.compile(regex);
    }
    //过滤掉符合正则表达式的
    public boolean accept(File dir, String name) {
        return !pattern.matcher(name).matches();
    }
}