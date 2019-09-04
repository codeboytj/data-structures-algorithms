package cumt.tj.learn.algorithms.backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sky on 17-9-7.
 *
 * * 链接：https://www.nowcoder.com/questionTerminal/040924ba0e64423b8a3fe2f75a56934a
 * 来源：牛客网
 * 参考博客：https://blog.mythsman.com/2017/03/31/1/#堆砖块
 *
 * 题目：堆砖块
 * 小易有n块砖块，每一块砖块有一个高度。
 * 小易希望利用这些砖块堆砌两座相同高度的塔。
 * 为了让问题简单，砖块堆砌就是简单的高度相加，某一块砖只能使用在一座塔中一次（也可以不出现）。
 * 小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。
 *
 * 输入描述:
 * 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)
 *
 * 输出描述:
 * 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1. 保证答案不大于500000。
 *
 * 示例1
 * 输入
 * 3 2 3 5
 *
 * 输出
 * 5
 *
 * 思路：回溯法
 * 对于一块砖，可以放A堆，也可以放B堆，也可以两个堆都不放
 * 但是需要做一些裁剪：
 * 根据题意，当某个堆高度大于500000时舍弃
 * 当堆不可能高于现有最高值的时候舍弃
 * 当较低堆不可能高于较高堆的时候淘汰(包括了当某个堆的高度大于砖总高的一半时的情况）
 *
 */
public class PileOfBricks {

    static int maxHeight=-1;
    static long[] sum;
    static  int[] heights;

    public static void pile(int index,int heightA,int heightB){

        //如果大于最大值
        if(heightA==heightB && heightA!=0 && heightA>maxHeight) maxHeight=heightA;
        if(index==-1) return;

        //较高堆与较小堆的高度
        int higher=(heightA>heightB)?heightA:heightB;
        int lower=(heightB>heightA)?heightA:heightB;
        //当某个堆高度大于500000时舍弃
        if(higher>500000) return;
        //当堆不可能高于现有最高值的时候舍弃
        if(lower+higher+sum[index+1]<=maxHeight*2) return;
        //当较低堆不可能高于较高堆的时候淘汰(包括了当某个堆的高度大于砖总高的一半时的情况）
        if(lower+sum[index+1]<higher) return;

        //放A堆
        pile(index-1,heightA+heights[index],heightB);
        //放B堆
        pile(index-1,heightA,heightB+heights[index]);
        //都不放
        pile(index-1,heightA,heightB);

    }

    public static void main(String[] args) {

        //读取输入
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        heights=new int[n];
        sum=new long[n+1];sum[0]=0;
        for(int i=0;i<n;i++){
            heights[i]=sc.nextInt();
        }
        //需要排个序，不然时间复杂度达不到要求
        Arrays.sort(heights);
        for(int i=0;i<n;i++){
            sum[i+1]=sum[i]+heights[i];
        }

        //A、B两堆的高度
        int heightA=0,heightB=0;

        //从最后一个开始
        pile(n-1,heightA,heightB);

        System.out.print(maxHeight);

    }

}
