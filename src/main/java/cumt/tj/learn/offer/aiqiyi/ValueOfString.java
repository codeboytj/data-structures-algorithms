package cumt.tj.learn.offer.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sky on 17-10-14.
 */
public class ValueOfString {

    static String s;
    static int[] times=new int['z'-'a'+1];

    public static int reduceValue(int nums){

        if(s.length()<nums) return 0;

        int length=times.length;

        while (nums>0){
            while (nums>0 && times[length-1]>=times[length-2]) {
                times[length-1]--;
                nums--;
            }
            Arrays.sort(times);
        }

        int value=0;
        for(int i=0;i<length;i++){
            value+=times[i]*times[i];
        }

        return value;

    }

    public static void main(String[] args){

        //读取输入
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();

        //构造出现次数数组
        for(int i=0;i<s.length();i++){
            times[s.charAt(i)-'a']++;
        }

        //数组排序
        Arrays.sort(times);

        //解决问题
        System.out.print(reduceValue(sc.nextInt()));

    }

}
