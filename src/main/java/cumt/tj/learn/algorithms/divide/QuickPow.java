package cumt.tj.learn.algorithms.divide;

/**
 * Created by sky on 17-9-4.
 *
 * 参考博客:http://www.cnblogs.com/luruiyuan/p/5570756.html
 *
 * 快速幂其实可以看作是快速乘法的特例，在快速幂中，我们不再对ans进行*2操作，因为在a^b中b的意义已经从乘数变成了指数，
 * 但是我们可以仍然把b写成二进制，举例说明：此时，我们将4*13改为4^13，13=（1101）2 ，二进制13写开我们得到（1000+100+1）
 * ，注意，这里的所有二进制是指数，指数的相加意味着底数相乘，因此有4^13 == 48 * 44 * 41。
 * 再注意到指数之间的2倍关系，我们就可以用很少的几个变量，完成这一算法。
 * 这样，我们就将原本用循环需要O(n)的算法，改进为O（logN）的算法。
 *
 */
public class QuickPow {

    /**
     * 快速幂运算
     * 拿3^13为例
     * 3^13=3^(1101)=3^(1000+100+1)=3^(2^0)*3^(2^2)*3^(2^3)
     * 循环中：
     *      result=1,power=(1101)2,base=3，第一次后
     *      result=3=3^(2^0),power=(110)2,base=3^2=9，第二次后
     *      result=3=3^(2^0),power=(11)2,base=3^(2^2)=81，第三次后
     *      result=243=3^(2^0)*3^(2^2),power=(1)2,base=3^(2^3)=6561，第四次后
     *      result=1594323=3^(2^0)*3^(2^2)*3^(2^3),power=0,base=3^(2^4)
     * @param base
     * @param power
     * @return
     */
    public long quickPow(long base,long power){

        long result=1;
        while ((power!=0)&&(power!=Long.MIN_VALUE)){

            if((power & 1)==1){
                //末位为1，需要利用分配律相加
                result*=base;
            }

            //移位,power不带符号右移
            power>>>=1;base*=base;

        }

        return result;

    }

}
