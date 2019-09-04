package cumt.tj.learn.algorithms.vector;

/**
 * Created by sky on 17-5-8.
 * 编程珠玑第八章算法设计技术，求向量的最大连续子向量之和
 */
public class MaxContiguousSubvectorSum {

    /**
     * 简单算法，对每个0<=i<=j<n的子向量a[i,j)计算和，并得出最大值
     * 需要花费O(n^3)的时间
     * @param a 输入数组
     * @return 最大和
     */
    public int simpleAlgorithms(int[] a){
        //最大和
        int maxSoFar=0;

        int sum;
        for(int i=0;i<a.length;i++){

            //j>=i
            for(int j=i;j<a.length;j++){

                sum=0;
                //子向量a[i,j]
                for(int k=i;k<=j;k++){
                    sum+=a[k];
                    maxSoFar=Math.max(maxSoFar,sum);
                }
            }
        }

        return maxSoFar;
    }


    /**
     * 平方算法，需要花费O(n^2)的时间
     * @param a 输入数组
     * @return 最大和
     */
    public int squareAlgorithms(int[] a){
        //最大和
        int maxSoFar=0;

        int sum;
        for(int i=0;i<a.length;i++){

            //j>=i
            sum=0;
            for(int j=i;j<a.length;j++){
                sum+=a[j];
                maxSoFar=Math.max(maxSoFar,sum);
            }
        }

        return maxSoFar;
    }

    /**
     * 分治算法，需要花费O(nlog2n)的时间
     * 要解决规模为n的问题，可以递归地解决两个规模近似为n/2的子问题，然后对他们的答案进行合并以得到整个问题的答案
     * @param a 输入数组
     * @return 最大和
     */
    public int divideAndConquerAlgorithms(int[] a){
        return divideAndConquerAlgorithms(a,0,a.length);
    }

    /**
     * 分治算法具体实现
     * @param a 输入数组
     * @param startPC 起始位
     * @param endPC 结束位
     * @return 返回a[startPC,endPC)的最大连续子向量和
     */
    public int divideAndConquerAlgorithms(int[] a,int startPC,int endPC){
        //最大和
        int maxSoFar=0;

        //1. 如果为空数组，返回0
        if (startPC>=endPC) return 0;

        //2. 如果只有一个元素，返回0与该元素的最大值
        if (startPC==(endPC-1)) return Math.max(maxSoFar,a[startPC]);

        //3. 如果有多个元素，那么求左边子向量、右边子向量以及中间位置的最大连续子向量和的最大值
        int center=(startPC+endPC)/2;
        maxSoFar=Math.max(divideAndConquerAlgorithms(a,startPC,center),divideAndConquerAlgorithms(a,center,endPC));
        //3.2 求中间位置的最大连续子向量和
        int lMax=0;int rMax=0;
        int sum=0;
        for(int i=center;i>=startPC;i--){
            sum+=a[i];
            lMax=Math.max(sum,lMax);
        }
        sum=0;
        for(int i=center+1;i<endPC;i++){
            sum+=a[i];
            rMax=Math.max(sum,rMax);
        }

        return Math.max(maxSoFar,lMax+rMax);
    }


    /**
     * 扫描算法，需要花费O(n)的时间
     * @param a 输入数组
     * @return 最大和
     */
    public int scanAlgorithms(int[] a){
        int maxSoFar=0;int maxEndinghere=0;
        for (int i=0;i<a.length;i++){
            //只要前面相加大于0就可以被保留，就可以增大结果;如果前面相加小于0,那么就不能增大结果，需要将前面的结果舍弃，用0代替
            maxEndinghere=Math.max(maxEndinghere+a[i],0);
            maxSoFar=Math.max(maxEndinghere,maxSoFar);
        }
        return maxSoFar;
    }
}
