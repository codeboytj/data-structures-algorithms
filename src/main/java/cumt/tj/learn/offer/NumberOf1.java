package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-7.
 * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路1：逐一按位与运算
 * 思路2：灵机一动的算法
 */
public class NumberOf1 {

    public int getNumbers(int n){
        return resolveWithSuprise(n);
//        return oneByoneByBitWith(n);
    }

    /**
     * 对于把一个整数减1：
     * 1. 如果最后一位为1，那么最后一位变为0
     * 2. 如果最后一位不为1，那么相当与把最靠后的1那一位变成0，后续0都变成1
     * 而如果将减一与原数做按位与运算，这时恰好会把原数最靠后的那个1变成0
     * 如此一直进行下去，直到原数变为0为止，恰好执行次数就为1的位数
     * @param n
     * @return
     */
    private int resolveWithSuprise(int n){

        int count=0;
        while (n!=0){
            ++count;
            n=n&(n-1);
        }
        return count;

    }

    /**
     * 逐一按位与运算
     * @param n
     * @return
     */
    private int oneByoneByBitWith(int n){

        //
        int count=0;
        int flag=1;

        while (flag!=0){

            if((n & flag)==flag){
                count++;
            }

            flag=flag<<1;

        }

        return count;

    }

    public static void main(String[] args) {
        NumberOf1 n=new NumberOf1();
        System.out.println(n.getNumbers(1));
        System.out.println(n.getNumbers(0x7FFFFFFF));
        System.out.println(0x7FFFFFFF);
        System.out.println(n.getNumbers(0x80000000));
        System.out.println(0x80000000);
        System.out.println(n.getNumbers(0xFFFFFFFF));
        System.out.println(0xFFFFFFFF);
        System.out.println(n.getNumbers(0xFFFFFFFF+1));
        System.out.println(0xFFFFFFFF+1);
        System.out.println(n.getNumbers(0));
    }
}
