package cumt.tj.learn.offer.netbase;

import java.util.Scanner;

/**
 * Created by sky on 17-9-5.
 *
 * 链接：https://www.nowcoder.com/questionTerminal/79c639e02bc94e6b919e3372c8e1dc5e
 * 来源：牛客网
 *
 * 魔力手环：
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 * 每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),
 * 一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
 * 现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 *
 * 输入描述:
 * 输入数据包括两行：
 * 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 * 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 *
 * 输出描述:
 * 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 *
 * 示例1
 * 输入
 * 3 2
 * 1 2 3
 *
 * 输出
 * 8 9 7
 *
 * 思路：
 * 以示例输入为例：
 * 每次使用魔力的时候，相当与于矩阵B：
 * [1,0,1
 * 1,1,0
 * 0,1,1]
 * 相乘，所以对于输入矩阵A，结果就是A*(B^k)，所以问题就是：
 * 1. 构造出矩阵B
 * 2. 矩阵快速幂问题，当然还要取模
 *
 */
public class MagicWristband {

    public static void main(String[] args) {

        //读取输入
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] a=new int[1][n];
        //构造矩阵b
        int[][] b=new int[n][n];
        for(int i=0;i<n;i++){
            a[0][i]=sc.nextInt();
            b[i][i]=1;
            if(i==0){
                b[i][n-1]=1;
            }else {
                b[i][i-1]=1;
            }
        }
        sc.close();

        //求矩阵快速幂
        int[][] result=matrixMult(a,quickMatrixPow(b,k,100),100);

        System.out.print(result[0][0]);
        for(int i=1;i<n;i++){
            System.out.print(" "+result[0][i]);
        }

    }

    /**
     * 矩阵快速求幂取模
     * @param base
     * @param pow
     * @return
     */
    public static int[][] quickMatrixPow(int[][] base,int pow,int mod){

        int[][] result=new int[base.length][base[0].length];

        for(int i=0;i<base.length;i++){
            result[i][i]=1;
        }

        while (pow!=0 && pow!=Integer.MIN_VALUE){

            if((pow & 1)==1){
                result=matrixMult(result,base,mod);
            }

            pow>>>=1;base=matrixMult(base,base,mod);

        }

        return result;

    }

    /**
     * 矩阵相乘取模
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixMult(int[][] a,int[][] b,int mod){

        //首先A的列数需要等于B的行数
        int rowA=a.length,colA=a[0].length;
        int rowB=b.length,colB=b[0].length;
        if(colA!=rowB){
            throw new RuntimeException("矩阵a的列数不等于b的行数");
        }

        //生成的矩阵行数等于a的行数，列数等于b的列数
        int[][] result=new int[rowA][colB];

        //计算乘积
        for(int i=0;i<rowA;i++){
            for(int j=0;j<colB;j++){
                for(int k=0;k<colB;k++){
                    result[i][j]+=a[i][k]*b[k][j];
                }
                result[i][j]%=mod;
            }
        }

        return result;

    }
}
