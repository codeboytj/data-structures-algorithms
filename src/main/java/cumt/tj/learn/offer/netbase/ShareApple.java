package cumt.tj.learn.offer.netbase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sky on 17-8-11.
 *
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数 n（1 <= n <= 100），
 * 接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 *
 * 输出描述:
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 *
 * 输入例子1:
 * 4
 * 7 15 9 5
 *
 * 输出例子1:
 * 3
 *
 * 思路：
 * 1. 先读取输入数组
 *    然后将数组排序、算出数组总和sum、平均值avg、此时判断平均值是不是整数sum%n==0?
 *    然后使用2个指针，fore与behind，指向开头与末尾
 *    遍历
 *    如果所指元素与avg的差是否为偶数，不为偶数就不能平分
 *          然后将behind-2,fore+2，直到其中一方==avg，然后移动那一方的指针
 *          直到两指针相交
 */
public class ShareApple {

    //每个奶牛拥有的苹果数
    int[] apples;
    //奶牛数
    int cowNum;
    //平均值
    int avg;
    //最少移动次数
    int min;

    public boolean avg(){

        long sum=0;
        for(int i=0;i<cowNum;i++){
            sum+=apples[i];
        }

        //如果平均值不为整数，那么不能平均分配
        if(sum%cowNum!=0){
            min=-1;
            return false;
        }

        //如果平均值为整数，可以平均分配
        avg=(int)sum/cowNum;
        return true;

    }

    /**
     * 数组排序
     */
    public void sort(){

        //使用函数库排序
        Arrays.sort(apples);

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        //读取奶牛数
        if(sc.hasNextInt()){
            cowNum=sc.nextInt();
            sc.nextLine();
        }

        //读取每个奶牛的苹果数
        apples=new int[cowNum];
        for(int i=0;i<cowNum;i++){
            apples[i]=sc.nextInt();
        }

    }

    /**
     * 分配
     */
    public void assign(){

        int fore=0,behind=cowNum-1;
        int foreDiff,behindDiff;
        while (fore<behind){

            //没有相交
            foreDiff=avg-apples[fore];behindDiff=apples[behind]-avg;

            //如果差不是偶数，不能平均分配
            if((foreDiff % 2)!=0 || (behindDiff % 2)!=0){
                min=-1;return;
            }

            //如果差是偶数，当前2个元素至少有一个可以被分配成功，其中一个等于平均值的时候停止循环
            while (apples[fore]!=avg && apples[behind]!=avg){
                //把苹果多的奶牛的苹果拿2个给少的
                apples[behind]-=2;apples[fore]+=2;
                min++;
            }

            if(apples[fore]==avg) fore++;
            if(apples[behind]==avg) behind--;

        }
    }

    public static void main(String[] args) {

        ShareApple sa=new ShareApple();

        //读取输入
        sa.readInput();
        //排序
        sa.sort();
        //计算累加和、平均值等
        if(sa.avg()){
            //有平均值
            sa.assign();
        }

        System.out.print(sa.min);

    }

}
