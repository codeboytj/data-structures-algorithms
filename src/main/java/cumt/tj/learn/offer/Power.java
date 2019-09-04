package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-8.
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * note:不用java类库。。。
 * 思路：
 *      1. 对于底数来说，分为2种情况：0与非0值
 *      2. 对于指数来说，分为三种情况：负数、0与正数
 *      如果底数为0，指数为0的情况，没有意义，可为0,也可以1
 *      如果指数为负的情况，结果为1/(负数的绝对值次放)，这时如果底数为0,就会造成0为分母的情况，这是不允许的
 *      如果指数为正，那么不管底数是什么都是正常的。
 */
public class Power {
    public double pow(double base,int exponent){

        //底数为0,指数为负的情况
        if(base==0 && exponent<0){
            //这是不允许的，让它返回0.0吧
            return 0;
        }

        //对于底数不为0的，指数为负的情况，先要求出负数的绝对值次方
        int absExponent=Math.abs(exponent);

        //对于底数为0，指数为0的情况，我们让它返回1,这样就可以和指数为正的情况统一了
        double result=betterPositivePos(base,absExponent);

        //对于底数不为0的，指数为负的情况，先要求出负数的绝对值次方，然后求倒
        if(exponent<0){
            result=1.0/result;
        }

        return result;
    }

    /**
     * 求正数base的absExponent（非0数）次方
     * @param base 正数
     * @param absExponent 非0数
     * @return
     */
    private double positivePos(double base,int absExponent){

        //对于指数等于0的情况，结果为1
        double result=1;

        for(int i=1;i<=absExponent;i++){
            result=result*base;
        }

        return result;

    }

    /**
     * 对于大于0的a，大于0的n，a^n：
     * 当n为偶数的时候，等于a^(n/2)*a^(n/2)
     * 当n为奇数的时候，等于a^(n-1/2)*a^(n-1/2)*a
     * 这样计数会减少计算次数
     * @param base
     * @param absExponent
     * @return
     */
    private double betterPositivePos(double base,int absExponent){

        if(absExponent==0) {
            //对于指数等于0的情况，结果为1
            return  1;
        }else if(absExponent==1) {
            //对于指数等于1的情况，结果为base
            return base;
        }

        double result=betterPositivePos(base,absExponent>>1);
        result=result*result;

        if((absExponent & 0x1)==1)
            //如果指数是奇数
            result=result*base;

        return result;

    }

    public static void main(String[] args) {
        Power power=new Power();
        System.out.println(power.pow(0.25,2));
    }
}
