package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-8-8.
 * 题目：合唱团
 * 有 n 个学生站成一排，每个学生有一个能力值，
 * 牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d，
 * 使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例。
 * 每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
 * 接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 *
 * 输出描述:
 * 输出一行表示最大的乘积。
 *
 * 输入例子1:
 * 3
 * 7 4 7
 * 2 50
 *
 * 输出例子1:
 * 49
 *
 * 思路：
 * 1. 先读取输入
 *    动态规划思想
 *    遍历
 *    找到以第i个开始长为k序列的乘积最大值,过程：
 *          从第i+1~i+d个开始，长为k-1的序列的乘积最大值
 *          这期间需要将以第k开始长为j的子序列的乘积最大值存着
 *          同时，这期间需要将以第k开始长为j的子序列的乘积最小值存着，以应付负值
 */
public class Choir {

    int n;
    int[] ablities;
    int k,d;
    long[][] max;
    long[][] min;

    public Choir() {
    }

    public Choir(int n, int[] ablities, int k, int d) {
        this.n = n;
        this.ablities = ablities;
        this.k = k;
        this.d = d;
    }

    public static void main(String[] args) {

        Choir choir=new Choir();
        //读取输入
        Scanner sc=new Scanner(System.in);
        choir.getInput(sc);
        sc.close();

        System.out.print(choir.findMaxProduct());

    }


    public long findMaxProduct(){

        max=new long[n][];
        min=new long[n][];
        long finalMax=0;
        long tmp=0;

        for(int i=(n-1);i>=0;i--){
            //查找以i开头的长为(1~length)的序列的乘积最大值

            //首先初始化数组的第二维
            int length;
            length=(i>n-k)?(n-i):k;
            max[i]=new long[length];
            min[i]=new long[length];
            max[i][0]=ablities[i];
            min[i][0]=ablities[i];

            if(i==n-1){
                //对于最后一个元素来说
                //以最后一个元素开头，长为1的序列乘积最大最小值
                finalMax=ablities[i];
            }else {
                //其它元素
                for (int j = 2; j <= length; j++) {
                    max[i][j-1]=max[i+1][j-2];
                    min[i][j-1]=min[i+1][j-2];

                    //在i+1~i+d的范围内查找长为j-1的最大最小值
                    for(int m=(i+2);m<=(i+d) && m<n && (m+j-2)<n;m++){
                        if(max[i][j-1]<max[m][j-2]){
                            max[i][j-1]=max[m][j-2];
                        }
                        if(min[i][j-1]>min[m][j-2]){
                            min[i][j-1]=min[m][j-2];
                        }
                    }

                    if(ablities[i]>0){
                        //大于0
                        max[i][j-1]*=ablities[i];
                        min[i][j-1]*=ablities[i];
                    }else{
                        tmp=min[i][j-1];
                        min[i][j-1]=ablities[i]*max[i][j-1];
                        max[i][j-1]=ablities[i]*tmp;
                    }

                }

            }

            if(finalMax<max[i][length-1]) finalMax=max[i][length-1];

        }

        return finalMax;

    }


    /**
     * 读取输入
     * @param sc
     */
    public void getInput(Scanner sc){

        //学生个数
        if (sc.hasNextInt()){
            n=sc.nextInt();
        }
        //学生能力数组
        ablities=new int[n];
        if (sc.hasNextInt()){
            for(int i=0;i<n;i++){
                ablities[i]=sc.nextInt();
            }
        }
        //k与d
        if (sc.hasNextInt()){
            k=sc.nextInt();
            d=sc.nextInt();
        }

    }

}
