package cumt.tj.learn.algorithms;

import java.util.Random;

/**
 * Created by sky on 17-5-10.
 * 编程珠玑第12章，取样问题
 */
public class Sample {

    /**
     * 从[0,n)的范围内,随机取样m个整数
     * @param m 取样的个数
     * @param n 取样范围[0,n)
     * @return 选取的整数组成的数组
     */
    public int[] simpleSample(int m,int n){
        Random random=new Random();
        int bigRand=n+random.nextInt();
        return new int[]{0,1,2};
    }

    /**
     * 生成比n大的随机整数
     * @param n 下界
     * @return 生成比n大的随机整数
     */
    public int bigRand(int n){
        Random random=new Random();
        int bigRand=n+random.nextInt();
        return bigRand;
    }
}
