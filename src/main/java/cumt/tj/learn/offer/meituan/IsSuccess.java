package cumt.tj.learn.offer.meituan;

import java.util.Scanner;

/**
 * Created by sky on 17-8-31.
 *
 * 要序列中保证第一个元素最大
 * 要保证其它元素的和大于第一个元素
 */
public class IsSuccess {

    //元素个数
    int n;
    //数组
    int[] nums;

    public boolean solve(){

        //查找最大元素，以及所有元素和
        int max=0;
        long sum=0;

        for(int i=0;i<n;i++){

            sum+=nums[i];
            if(max<=nums[i]) max=nums[i];

        }

        return (sum-max)>=max;

    }

    /**
     * 读取输入
     */
    public void readInput(){

        Scanner sc=new Scanner(System.in);

        //读取数组大小
        n=sc.nextInt();
        nums=new int[n];

        //读取数组元素
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        sc.close();
    }



    public static void main(String[] args) {

        IsSuccess kTimes=new IsSuccess();

        //读取输入
        kTimes.readInput();

        //求解
        //输出
        System.out.print(kTimes.solve()?"Yes":"No");

    }

}
