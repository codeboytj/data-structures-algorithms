package cumt.tj.learn.offer.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sky on 17-8-22.
 *
 * 题目描述
 * 写段代码，定义一个字符串常量，
 * 字符串中只有大小写字母和整数，
 * 输出字符串中的出现最多的数字的和？
 * 例如 ” 9fil3dj11P0jAsf11j ” 中出现最多的是11两次，输出22.
 *
 * 思路：
 * 1. 用hashmap存储每个数字的出现次数n，然后输出和
 */
public class MostAppearSum {

    String source;

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);
        source=sc.nextLine().trim();

        sc.close();
        //测试输入
        System.out.print(source);

    }

    public int solve(){

        //字符数组
        char[] sc=source.toCharArray();
        //存储数字出现次数
        Map<Integer,Integer> timesMap=new HashMap<Integer, Integer>();

        //计数字的位数
        int level;
        int times;
        //记录当前数字
        int currentNum=0;
        //遍历
        for(int i=sc.length-1;i>=0;i--){

            //计数字的位数
            level=-1;
            //数字的ascii码范围为[48,57]
            if(sc[i]<=57 && sc[i]>=48) {
                while (i>-1 && sc[i] <= 57 && sc[i] >= 48) {
                    level++;
                    currentNum = currentNum + (sc[i]-48) * (int) Math.pow(10, level);
                    i--;
                }
                times=timesMap.get(currentNum)==null?0:timesMap.get(currentNum);
                times++;
                timesMap.put(currentNum,times);
            }

        }

        //查找出现最多的数字的出现次数
        int max=0;
        int tmp;
        int num=-1;
        for(Map.Entry<Integer,Integer> entry:timesMap.entrySet()){
            tmp=entry.getValue();
            if(tmp>max){
                max=tmp;
                num=entry.getKey();
            }
        }

        //输出和
        return num*max;

    }

    public static void main(String[] args) {

        MostAppearSum mostAppearSum=new MostAppearSum();

        //读取输入
        mostAppearSum.readInput();

        System.out.print(mostAppearSum.solve());

    }

}
