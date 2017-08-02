package cumt.tj.learn.offer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by sky on 17-8-2.
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * 思路：
 * 遍历，用2个变量存储最大和subSum与当前子段累加和currentSum
 * 当前遍历到x，计算currentSum+=x，
 * 如果currentSum大于subSum，那么subSum=currentSum
 * 如果currentSum<0，那么舍弃，currentSum=0，重下一个遍历重新累加
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array){

        int length=array.length;
        if(length==0) return 0;
        if(length==1) return array[0];

        int subSum=array[0];int currentSum=array[0];

        for (int i=1;i<length;i++) {

            if(currentSum<0) currentSum=0;
            currentSum+=array[i];
            if(currentSum>subSum) subSum=currentSum;

        }

        return subSum;

    }

    public static void main(String[] args) {

        FindGreatestSumOfSubArray findGreatestSumOfSubArray=new FindGreatestSumOfSubArray();
        System.out.println(findGreatestSumOfSubArray.findGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
        System.out.println(findGreatestSumOfSubArray.findGreatestSumOfSubArray(new int[]{}));
        System.out.println(findGreatestSumOfSubArray.findGreatestSumOfSubArray(new int[]{-3}));

    }

}
