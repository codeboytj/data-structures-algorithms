package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-7.
 * 题目：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * Fibonacci：f(0)=0;
 *            f(1)=1;
 *            f(n>=2)=f(n-1)+f(n-2)
 * 思路：
 *      1. 比较容易想到递归，但是递归有明显地性能缺陷，需要为方法调用分配栈空间，而且对于
 *      斐波那且数列来说，递归会进行大量的重复运算，比如对于f(7)，递归会计算f(5)与f(6)，而
 *      对于f(8)，递归有会计算一次f(6)，这样势必会浪费时间与空间。
 *      2. 将递归转换为循环，这样会省下方法调用栈空间的分配，而如果不做其他更改，还是会进行
 *      重复计算。
 *      3. 所以，想到把计算结果利用中间空间保存起来，在需要使用的时候直接调用，这样虽然会用掉
 *      一些空间，但是避免了重复计算，节省了时间。
 *      4. 如果我们放弃递归和函数表达式带来的思维定式，从下往上计算，由f(0)与f(1)算出f(2)，
 *      再算出f(3)，以此类推，这样既节省了时间，又节省了空间。
 */
public class Fibonacci {

    /**
     * 求斐波那契数列的第n项
     * @param n
     * @return
     */
    public int getValue(int n){

        switch (n){
            case 0:return 0;
            case 1:return 1;
        }

        //对于n>=2的情况
        int fibN1=0;
        int fibN2=1;
        int fibN=0;

        for (int i=2;i<=n;i++){

            fibN=fibN1+fibN2;
            fibN1=fibN2;
            fibN2=fibN;

        }

        return fibN;

    }

    public static void main(String[] args) {
        System.out.print(new Fibonacci().getValue(0));
        System.out.print(new Fibonacci().getValue(1));
        System.out.print(new Fibonacci().getValue(2));
        System.out.print(new Fibonacci().getValue(3));
        System.out.print(new Fibonacci().getValue(4));
    }

}
