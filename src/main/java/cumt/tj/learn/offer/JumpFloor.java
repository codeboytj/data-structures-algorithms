package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-7.
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：因为青蛙可以一次跳1级，也可以1次跳2级
 *      所以对于n>2，青蛙要跳到n级，可以从n-1级跳1级上来，也可以从n-1级跳2级上来，即f(n>2)=f(n-1)+f(n-2)
 *      而f(1)=1,f(2)=2
 *      这就是斐波那契数列的类似问题
 */
public class JumpFloor {

    public int getJumpMethodNumber(int n) {

        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
        }

        //对于n>=2的情况
        int fibN1 = 1;
        int fibN2 = 2;
        int fibN = 0;

        for (int i = 3; i <= n; i++) {

            fibN = fibN1 + fibN2;
            fibN1 = fibN2;
            fibN2 = fibN;

        }

        return fibN;
    }

    public static void main(String[] args) {
        System.out.print(new JumpFloor().getJumpMethodNumber(1));
        System.out.print(new JumpFloor().getJumpMethodNumber(2));
        System.out.print(new JumpFloor().getJumpMethodNumber(3));
        System.out.print(new JumpFloor().getJumpMethodNumber(4));
    }
}

