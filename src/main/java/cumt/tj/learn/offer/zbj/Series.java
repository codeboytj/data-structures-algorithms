package cumt.tj.learn.offer.zbj;

import java.util.Scanner;

/**
 * Created by sky on 17-9-15.
 *
 * 题目描述：
 * 某种特殊的数列a1, a2, a3, ...的定义如下：a1 = 1, a2 = 2, ... , an = 2 * an − 1 + an - 2 (n > 2)。
 * 给出任意一个正整数k，求该数列的第k项模以32767的结果是多少？
 *
 * 输入
 * 第1行是测试数据的组数n，后面跟着n行输入。每组测试数据占1行，包括一个正整数k (1 ≤ k < 1000000)。
 * 输出
 * n行，每行输出对应一个输入。输出应是一个非负整数。
 *
 * 样例输入
 * 2
 * 1
 * 8
 * 样例输出
 * 1
 * 408
 */
public class Series {

    public static long solve(int k){

        //使用动态规划，将中间结果存起来
        long prev=1;
        long last=2;
        long tmp;

        if(k==1) return prev;
        if(k==2) return last;

        for(int i=3;i<=k;i++){

            tmp=2*last+prev;

            prev=last;
            last=tmp;

            if(last>=32767) last%=32767;

        }

        return last;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] inputs=new int[n];
        for(int i=0;i<n;i++){
            inputs[i]=sc.nextInt();
        }

        for(int i:inputs){
            System.out.println(solve(i));
        }

    }

}
