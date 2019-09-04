package cumt.tj.learn.offer;

import java.util.HashMap;

/**
 * Created by sky on 17-8-7.
 * 题目：
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率
 *
 * 思路：
 * 1. 用2个数组存储骰子点数的每一个总数出现的次数。
 * 2. 在一次循环中，第一个数组中的第s个数字表示骰子和为s出现的次数
 * 3. 在下一次循环中，加上一个新骰子，此时和为s的骰子出现的次数应该等于上一次循环中的骰子点数和
 *      为s-1、s-2、s-3、s-4、s-5以及s-6的和。
 * note：
 *      n个骰子的点数总值在[n,6n]之间，所以数组大小可以设为6n
 */
public class PrintProbability {

    public HashMap<Integer,Double> getProbability(int n){

        HashMap<Integer,Double> probabilities=new HashMap<Integer, Double>(mapCapcity(5*n+1));

        int[][] times=new int[2][6*n+1];
        //初始化，由于1个骰子的时候，和为[1,6]的次数都为1
        int flag=0;
        for(int i=1;i<=6;i++){
            times[flag][i]=1;
        }

        if(n>1) {
            //n>1个骰子

            for (int i = 2; i <= n; i++) {

                for(int j=0;j<i;j++){
                    times[1-flag][j]=0;
                }

                for(int j=n;j<=6*n;j++){
                    times[1-flag][j]=0;
                    for(int k=1;k<=6 && k<=j;k++){
                        times[1-flag][j]+=times[flag][j-k];
                    }
                }

                flag=1-flag;

            }
        }

        double total=Math.pow(6,n);
        for(int i=n;i<=6*n;i++){
            probabilities.put(i,(double)times[flag][i]/total);
        }

        return probabilities;

    }

    /**
     * 求使得hashmap效率最高的初始化容量
     * 求大于capcity，且距它最近的2的n次方
     * @param capcity 真正的容量大于等于0的数
     * @return
     */
    public int mapCapcity(int capcity){

        //
        if(capcity<=0) return 0;

        //充填因子为0.75
        capcity=(int)Math.floor(capcity/0.75);

        //参照，1000 0000 0000 0000 0000 0000 0000 0000，循环的时候需要让它右移位，但是符号位不补即>>>
        int refer=0x80000000;

        for(int i=32;i>0;i++){

            if((refer & capcity)==refer){
                break;
            }

            //不带符号右移
            refer>>>=1;

        }

        return refer<<=1;

    }

}
