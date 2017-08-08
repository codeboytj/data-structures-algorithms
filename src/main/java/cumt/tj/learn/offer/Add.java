package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-8.
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路：位运算
 * 1. 用与运算判断某一位置是否为1
 * 2. 用异或运算来进行不考虑进位的相加
 * 3. 先不管进位相加，存储需要进位的位置
 * 4. 然后与存储的进位相加，然后再将需要再次进位的地方存起来
 * 5. 知道没有需要进位的地方了
 */
public class Add {

    public int add(int num1,int num2) {

        int sum=num1;
        int carry;

        while (num2!=0){

            //不管进位的相加
            sum=num1^num2;
            //需要进位的地方
            carry=(num1 & num2) << 1;

            num1=sum;
            num2=carry;

        }

        return sum;

    }

}
