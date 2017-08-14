package cumt.tj.learn.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 17-8-14.
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 思路：
 * 题目有2个点，字符是流的形式输入的，第一次不重复的字符
 * 第一次不重复的字符已经做过了
 * @See FirstNotRepeatingChar.java
 * 而对于流，可以通过一个数组存起来
 */
public class FirstAppearingOnce {

    //存储字符的容器
    List<Character> cl=new ArrayList<Character>();


    //Insert one char from clingcleam
    public void Insert(char ch)
    {
        cl.add(ch);
    }
    //return the first appearence once char in current clingcleam
    public char FirstAppearingOnce()
    {

        //存储出现次数的数组，256个ascii码对应相应的字符
        int[] appears=new int[256];

        //存储出现次数
        for(char c:cl){
            appears[c]++;
        }

        //找到第一个出现一次的字符
        for(char c:cl){
            if(appears[c]==1) return c;
        }

        return '#';

    }

}
