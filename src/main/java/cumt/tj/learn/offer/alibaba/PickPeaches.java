package cumt.tj.learn.offer.alibaba;

import java.util.Scanner;

/**
 * Created by sky on 17-8-21.
 *
 * 小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。
 * 小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山的方向走，不能回头，
 * 每颗树最多摘一个，
 * 而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子。
 * 那么小猴子最多能摘到几颗桃子呢？
 * 举例说明，比如有5棵树，分别结了10，4，5，12，8颗桃子，
 * 那么小猴子最多能摘3颗桃子，来自于结了4，5，8颗桃子的桃树。
 *
 * 思路：
 * 就是找一个最长的递增子序列
 * 动态规划：
 *     利用数组len[i]存储，以第i个元素开头的最长递增序列长度
 *     对于第j个元素，使用max存储以j开头的当前序列中的最大值
 *                    使用maxLen存储以j开头的当前序列的最大长度
 *                    从j到length遍历，对于k>j，且a[k]>max，比较
 *                          a[k]+1与maxLen的大小，大则替换
 *     最后遍历len，找出最大值
 *
 */
public class PickPeaches {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {

        int length;
        //空数组
        if(peaches==null || (length=peaches.length)==0) return 0;

        //存储以第i个元素开头的最长递增序列长度
        int[] lens=new int[length];
        //存储以第i个元素开头的最长递增序列的最大值
        int[] maxes=new int[length];

        //初始化
        lens[length-1]=1;
        maxes[length-1]=peaches[length-1];

        //遍历
        //存储当前元素开头的最长子序列长度
        int maxLen=1;
        int currentLen=0;
        //存储当前子序列中的最大元素
        int max=0;
        for(int i=length-2;i>=0;i--){

            max=peaches[i];
            maxLen=1;
            //在(i,length)中的lens进行遍历
            for(int j=i+1;j<length;j++){
                //只能摘更大的
                if(peaches[j]>peaches[i]){
                    //peaches[i]+以peaches[j]开头的子序列长度
                    currentLen=lens[j]+1;
                    if(currentLen>maxLen){
                        //比之前的长，替换
                        maxLen=currentLen;
                        max=maxes[j];
                    }
                }
            }

            lens[i]=maxLen;
            maxes[i]=max;
        }

        //找出最大值
        max=0;
        for(int i:lens){
            max=(max<i)?i:max;
        }

        return max;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }

}
