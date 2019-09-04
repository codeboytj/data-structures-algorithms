package cumt.tj.learn.offer;

import org.w3c.dom.css.Rect;

/**
 * Created by sky on 17-7-7.
 * 问题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：这仍是斐波那契数列，不解释，表达式和跳台阶一模一样
 */
public class RectCover {

    public int getValue(int n){

        switch (n){
            case 1:return 1;
            case 2:return 2;
        }

        //对于n>=2的情况
        int fibN1=1;
        int fibN2=2;
        int fibN=0;

        for (int i=3;i<=n;i++){

            fibN=fibN1+fibN2;
            fibN1=fibN2;
            fibN2=fibN;

        }

        return fibN;

    }

    public static void main(String[] args) {
        RectCover r=new RectCover();
        System.out.print(r.getValue(1));
        System.out.print(r.getValue(2));
        System.out.print(r.getValue(3));
        System.out.print(r.getValue(4));
    }
}
