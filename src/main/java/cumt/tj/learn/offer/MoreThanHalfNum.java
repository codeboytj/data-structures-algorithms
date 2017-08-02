package cumt.tj.learn.offer;

import java.util.HashMap;

/**
 * Created by sky on 17-8-2.
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路：
 * 1. 利用HashMap存储每个元素出现的次数
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int [] array) {

        int length=array.length;
        if(length==1) return array[0];

        HashMap<Integer,Integer> times=new HashMap<Integer, Integer>();

        Integer tmp;
        for (int i:array) {

            tmp=times.get(i);
            if(tmp!=null){
                //有
                tmp++;
                if(tmp>length/2) return i;
                times.put(i,tmp);
            }else{
                //没有
                times.put(i,1);
            }

        }

        return 0;

    }

    public static void main(String[] args) {

        MoreThanHalfNum moreThanHalfNum=new MoreThanHalfNum();
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{}));
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{1}));
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{1,1}));
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{2,1}));

    }

}
