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
 *      这样以空间换了时间，时间复杂度为O(n)
 * 2. 先把数组排序{1,2,2,2,2,2,3,4,5}
 *    对于出现次数大于一半n/2的数字，需要用一把长n/2+1的标尺去量
 *    即如果a[x]=a[x+n/2]，那么这个数字出现次数就大于一半
 *    但是排序算法的最小时间为O(nlogn)，所以时间略大
 * 3. 剑指Offer解法二：
 *    数字出现次数大于一半，则出现次数大于其他数字出现次数总和
 *    遍历数组，设置2个值，一个保存数字x，一个保存次数n
 *    进行遍历，第一次保存数字，将n设为1
 *    如果遍历到的数字不等于x，那么n-1,如果此时n=0，保存x
 *    如果遍历到的数字等于x，那么n+1,不改变x
 *    那么最后一次把x设为1的一定是出现过半的数字
 */
public class MoreThanHalfNum {

    public int moreThanHalfNum(int [] array) {

        int length=array.length;
        if(length==0) return 0;
        if(length==1) return array[0];

        int x=array[0];int n=1;
        for (int i=1;i<length;i++) {
//            if(n==0){
//                x=array[i];n++;
//            }else{
                if(x==array[i]){
                    n++;
                }else {
                    n--;
                    if(n==0){
                        x=array[i];n++;
                    }
                }
//            }
        }

        //检验到底正不正确
        if(n>0){
            int times=0;
            for(int i:array){
                if(i==x) times++;
                if(times>length/2) return x;
            }
        }

        return 0;
    }

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
                //找到了，直接返回
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

        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{1,2,3,2,2,2,5,4,2}));
        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{1,2,3,2,4,2,5,2,3}));
        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{}));
        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{1}));
        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{1,1}));
        System.out.println(moreThanHalfNum.moreThanHalfNum(new int[]{2,1}));
    }

}
