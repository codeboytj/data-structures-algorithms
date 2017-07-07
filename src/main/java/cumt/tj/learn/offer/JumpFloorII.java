package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-7.
 * 题目： 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：因为青蛙可以一次跳1,……，n级
 *      所以对于n，青蛙要跳到n级，可以从0级跳到n级，，，，n-2级跳1级上来，也可以从n-1级跳1级上来
 *      即f(n)=f(n-1)+f(n-2)+……+f(0)，这是一个等比数列，且f(n)/f(n-1)=2，可以计算出f(n)=2^(n-1)
 *      而f(0)没有意义，f(1)=1
 */
public class JumpFloorII {

    public int getJumpMethodNumber(int n) {

        return (int) Math.pow(2,n-1);

    }

    public static void main(String[] args) {
        System.out.print(new JumpFloorII().getJumpMethodNumber(1));
        System.out.print(new JumpFloorII().getJumpMethodNumber(2));
        System.out.print(new JumpFloorII().getJumpMethodNumber(3));
        System.out.print(new JumpFloorII().getJumpMethodNumber(4));
    }
}
