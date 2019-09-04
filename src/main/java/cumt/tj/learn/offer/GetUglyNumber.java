package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-3.
 * 题目描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 * 由于丑数可以看作另外一个丑数与2、3、5相乘的结果
 * 使用大小为k一个数组，准备按顺序存储丑数
 * 对于数组中的最大值M，要对前面的元素分别乘2、3、5,找到大于M的最小值作为下一个要存储的元素
 * 而对于一个元素如果它乘以2的值已经被加入到数组中，那么下一次乘以2的时候，应该从它后面开始
 * 所以我们用3个变量分别存储已经下一个应该乘2、3、5的元素索引，以节省时间
 * 详见http://blog.csdn.net/w417950004/article/details/54348695
 */
public class GetUglyNumber {

    public int getUglyNumber(int index) {

        if(index==0) return 0;

        //丑数数组
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        //当前数组中的丑数数量
        int size=1;
        //存储最小的M2、M3、M5
        int m2=0;int m3=0;int m5=0;
        int t2=0,t3=0,t5=0;

        while (size<index) {

            m2=uglyNumbers[t2]*2;m3=uglyNumbers[t3]*3;m5=uglyNumbers[t5]*5;
            uglyNumbers[size]=Math.min(Math.min(m2,m3),m5);

            //每一个都要判断，因为有可能相等，而那个索引下次不能用了，否则会一直停在那儿，比如：2*3=6，3×2=6
            if(m2==uglyNumbers[size]) {
                t2++;
            }
            if(m3==uglyNumbers[size]){
                t3++;
            }
            if(m5==uglyNumbers[size]){
                t5++;
            }

            size++;

        }

        return uglyNumbers[index-1];
    }

}
