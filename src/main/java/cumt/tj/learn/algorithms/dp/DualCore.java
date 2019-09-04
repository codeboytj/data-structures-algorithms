package cumt.tj.learn.algorithms.dp;

import java.util.Scanner;

/**
 * Created by sky on 17-9-3.
 *
 * 链接：https://www.nowcoder.com/questionTerminal/9ba85699e2824bc29166c92561da77fa
 * 来源：牛客网
 *
 * 题目：双核处理（ 网易2017春招笔试真题）
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * n个任务可以按照任意顺序放入CPU进行处理，
 * 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 *
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 *
 * 输出描述:
 * 输出一个整数，表示最少需要处理的时间
 *
 * 示例1
 * 输入
 * 5
 * 3072 3072 7168 3072 1024
 *
 * 输出
 * 9216
 *
 * 思路：
 *
 * 2个cpu同时处理任务，所以一个cpu的总时间t1小于任务总时长t/2，另一个ｃｐｕ处理时长为(t-t1)，现在其实是求min(t-t1)．
 * 由于对于给定的输入，t是固定的，所以题目其实是求max(t1)．
 * 所以变成了一个背包问题，一个大小限制为t/2的背包装任务，使所装任务总时长最长．
 *
 * 首先试一试递归的解决方法：
 * 以示例输入为例，那么总时长t=17408，t1<=8704
 * 遍历，装入3072，背包剩余(8704-3072)=5632，变成子问题：将剩下的任务装入大小为5632背包，找到最大值
 *       继续遍历
 * 当然，这样会造成时间复杂度过大
 *
 * 所以试一试动态规划的解法
 * 参考博客：http://blog.csdn.net/mu399/article/details/7722810
 */
public class DualCore {

    private int length;
    private int[] times;
    private int average;
    private int total;

    /**
     * 动态规划求解
     * @return
     */
    public int solveByDP(){

        //首先需要有一个表，存储f[i,j]，f[i,j]表示在（倒数的）前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
        //长度加1，方便表示。所以第0行表示没有物品的时候，第0列表示背包什么都不能装的时候，都为0
        int[][] f=new int[length+1][average+1];

        //开始填表，从第一个任务开始填
        int min=times[0];
        int current;
        int max=0;
        for(int i=1;i<length+1;i++){

            //当前任务耗时
            current=times[i-1];
            //当前所有任务中耗时最小任务的耗时
            if(min>current) min=current;
            for(int j=min;j<=average;j++){
                //从i行，min列开始填，前面的都为0
                //01背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
                if(j-current<0){
                    f[i][j]=f[i-1][j];
                }else{
                    f[i][j]=(f[i-1][j]>(f[i-1][j-current]+current))?f[i-1][j]:(f[i-1][j-current]+current);
                }
                if(max<f[i][j]) max=f[i][j];
            }
        }

        return (total-max)*1024;

    }

    /**
     * 利用递归求解
     * @return
     */
    public int solveByRecursion(){

        boolean[] isDone=new boolean[length];

        int max=0,left=average;

        return (total-(average-solveByRecursion(left,isDone,left)))*1024;
    }

    /**
     * 递归具体实现
     * @param left
     * @param isDone
     * @param minLeft
     * @return
     */
    private int solveByRecursion(int left,boolean[] isDone,int minLeft){

        int tmpLeft;

        for(int i=0;i<length;i++){

            tmpLeft=left;
            if(!isDone[i] && tmpLeft>=times[i]){

                //标志第ｉ个可以装入
                isDone[i]=true;
                tmpLeft-=times[i];

                if(minLeft>tmpLeft) minLeft=tmpLeft;
                //
                minLeft=solveByRecursion(tmpLeft,isDone,minLeft);

                isDone[i]=false;
            }

        }

        return minLeft;

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);
        //任务数量
        length=sc.nextInt();
        times=new int[length];
        //每个任务所花费的时间
        //计算平均值
        for(int i=0;i<length;i++){
            //都是１０２４的倍数
            times[i]=sc.nextInt()/1024;
            total+=times[i];
        }
        average=total/2;
        //关闭
        sc.close();

    }


    public static void main(String[] args) {

        DualCore dc=new DualCore();

        dc.readInput();

//        System.out.print(dc.solveByRecursion());
        System.out.print(dc.solveByDP());

    }

}
