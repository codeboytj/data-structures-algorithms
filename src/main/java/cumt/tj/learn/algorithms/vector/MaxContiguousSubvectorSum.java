package cumt.tj.learn.algorithms.vector;

/**
 * Created by sky on 17-5-8.
 * 编程珠玑第八章算法设计技术，求向量的最大连续子向量之和
 */
public class MaxContiguousSubvectorSum {

    /**
     * 简单算法，对每个0<=i<=j<n的子向量a[i,j)进算和，并得出最大值
     * @param a 输入数组
     * @return 最大和
     */
    public int simpleAlgorithms(int[] a){
        //最大和
        int maxSoFar=0;

        for(int i=0;i<a.length;i++){

            //j>=i
            for(int j=i;j<a.length;j++){

                int sum=0;
                //子向量a[i,j]
                for(int k=i;k<=j;k++){
                    sum+=a[k];
                    maxSoFar=Math.max(maxSoFar,sum);
                }
            }
        }

        return maxSoFar;
    }
}
