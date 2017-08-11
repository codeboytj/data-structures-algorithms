package cumt.tj.learn.offer.netbase;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Created by sky on 17-8-11.
 *
 * 航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，
 * 科学家根据实验数据估计，如果在发射过程中，产生了 x 程度的损耗，
 * 那么在降落的过程中就会产生 x的2次方 程度的损耗，
 * 如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。
 * 问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，
 * 那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？
 *
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。
 *
 * 输出描述:
 * 输出一行一个整数表示结果。
 *
 * 输入例子1:
 * 10
 *
 * 输出例子1:
 * 2
 *
 * 思路：
 * 求解一元二次方程：x+x^2<=h中的x的最大整数解
 *
 */
public class InterstellarCrossing {

    long h;
    long x;


    public void solve(){

        //使用二分查找吧
        long center;
        long result;
        //end从h的根号开始，防止溢出，这里可能有问题
        long start=0,end=(long)Math.ceil(Math.sqrt(h));

        while (true){

            center=(start+end)/2;
            result=center+center*center;

            if(result<h){
                if(center==(end-1)){
                    x=center;
                    return;
                }
                start=center;
            }else if(result==h){
                x=center;
                return;
            }else{
                end=center;
            }


        }

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        if(sc.hasNextLong()){
            h=sc.nextLong();
        }

        sc.close();

    }

    public static void main(String[] args) {

        InterstellarCrossing is=new InterstellarCrossing();

        //读取输入
        is.readInput();

        //求解
        is.solve();

        System.out.print(is.x);

        return;

    }

}
