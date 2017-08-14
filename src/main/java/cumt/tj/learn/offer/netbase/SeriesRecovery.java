package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-11.
 *
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，
 * 但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
 * 但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，
 * 符合这个要求的合法排列的数目。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
 * 接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 *
 * 输出描述:
 * 输出一行表示合法的排列数目。
 *
 * 输入例子1:
 * 5 5
 * 4 0 0 2 0
 *
 * 输出例子1:
 * 2
 *
 * 思路：
 * 1. 对每一种可能，计算顺序对，为k的有多少种就有多少种可能
 *    如果有x个确实数据，那么一共最多可以有x^100次方中可能
 *    由于利用归并排序计算顺序对的时间复杂度是o(nlogn)，那么一共需要o(x^100*nlogn)
 *    显然不可取
 *
 */
public class SeriesRecovery {

    //数列长度
    int n;
    //顺序对数目
    int k;
    //数列
    int[] series;


    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        if(sc.hasNextInt()){
            n=sc.nextInt();k=sc.nextInt();
            sc.nextLine();
        }

        //读取数列
        series=new int[n];
        if(sc.hasNextLine()){
            for(int i=0;i<n;i++){
                series[i]=sc.nextInt();
            }
        }

        sc.close();

    }

    public static void main(String[] args) {

        SeriesRecovery sr=new SeriesRecovery();

        //读取输入
        sr.readInput();

        return;

    }

}
