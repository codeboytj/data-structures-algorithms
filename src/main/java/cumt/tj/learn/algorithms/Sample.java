package cumt.tj.learn.algorithms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by sky on 17-5-10.
 * 编程珠玑第12章，取样问题
 */
public class Sample {

    /**
     * 从[0,n)的范围内,随机取样m个整数，不允许重复
     * @param m 取样的个数
     * @param n 取样范围[0,n)
     * @return 选取的整数组成的数组
     */
    public int[] simpleSample(int m,int n){
        //select用来记录还有多少个要选择，选择一个少一个；remaining用来记录一共还剩下多少数字来遍历以判断是否要选择，遍历一个少一个。
        //即如果总共从5个里面选2个，已经遍历了3个，选择了一个，那么就要从剩下的2个里面选一个，即1/2的概率，这样既不会多选，也不会少选。
        int select =m;int remaining=n;
        int[] result=new int[select];

        for (int i=0;i<n;i++){
            //从余下的remaining个中选select个元素，记录元素索引
            if(bigRand(n)%remaining<select){
                result[m-select]=i;
                select--;
            }
            remaining--;
        }

        return result;
    }

    /**
     * 通过往Set中插入随机数，插满为止,不允许重复
     * @param m 取样的个数
     * @param n 取样范围[0,n)
     * @return 选取的整数组成的数组
     */
    public Integer[] setSample(int m, int n){
        //创建初始为空的集合
        Set<Integer> sampleSet=new HashSet<Integer>();

        while (sampleSet.size()<m){
            sampleSet.add(bigRand(n)%n);
        }

        return sampleSet.toArray(new Integer[m]);
    }
    /**
     * 生成比n大的随机整数
     * @param n 下界
     * @return 生成比n大的随机整数
     */
    public int bigRand(int n){
        Random random=new Random();
        //貌似有溢出的危险性
        int bigRand=n+Math.abs(random.nextInt());
        return bigRand;
    }
}
