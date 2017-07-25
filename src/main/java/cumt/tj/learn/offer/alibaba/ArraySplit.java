package cumt.tj.learn.offer.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sky on 17-7-25.
 * 题目：一个整型数组，将其划分为和相同的4个切片，
 * 例如：{ 2, 3, 5, 1, 2, 2, 1, 1, 3 }，切片操作后划分为：{2,3}，{5}，{1,2,2}，{1,1,3}，也就找到所谓的四等分点。
 * 只不过输出结果为true或者false（是否能得到这样的4个切片）。
 * 同时要求时间复杂度和空间复杂度为o(n)。
 */
public class ArraySplit {

    public static boolean equalSplitAble(List<Integer> intArray){

        //首先，数组需要满足：
        //1.长度大于4
        int length=intArray.size();
        if(length<4) return false;
        //2.数组之和能被4整除
        int sum=0;
        for(int i=0;i<length;i++) sum+=intArray.get(i);
        if((sum % 4) !=0) return false;

        //满足初始条件之后
        //如果可以4等分，那么每个等分的和为：
        int segSum=sum/4;
        int tmpSegSum=0;
        for (int j=0;j<length;j++){
            tmpSegSum+=intArray.get(j);
            if(tmpSegSum==segSum){
                //这一段的和满足要求，将tmpSegSum清空，计算下一段
                tmpSegSum=0;
//                if(j==length-1) return true;
            }else if(tmpSegSum<segSum){
                //这一段的和比要求的和小，继续计算tmpSegSum
                continue;
            }else if(tmpSegSum>segSum){
                //这一段的和比要求的和大，不用计算了，不符合要求
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        //首先，提示输入数组
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入整数数组，空格隔开，输入exit结束数组输入，按回车键得到结果：");

        //读取用户输入，并转换为数组
        List<Integer> intArray=new ArrayList<Integer>();
        while (sc.hasNextInt()){
            intArray.add(sc.nextInt());
        }
        if(sc.hasNext() && (sc.next().equals("exit")));

        //判断数组是否能够被切成4等分
        System.out.println(equalSplitAble(intArray));

    }


}
