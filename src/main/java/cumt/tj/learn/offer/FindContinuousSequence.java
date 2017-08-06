package cumt.tj.learn.offer;

import java.util.ArrayList;

/**
 * Created by sky on 17-8-6.
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 思路：
 * 1.s可以拆分成1+s-1，2+s-2，，，，s/2+s-s/2
 * 从i=1到s/2进行遍历
 * 如果以i开头的序列，如果i+s-i不连续，则i+(i+1)+(s-i-i-1)，不连续则继续，直到i+n>(s-i-i-1-……-i-n)，如果连续则添加
 * 然后以i+1开头的序列
 * 但是这样的话，maybe时间复杂度不行
 * 2.剑指offer版
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        return goodFind(sum);
//        return myFind(sum);
    }

    public ArrayList<ArrayList<Integer>> goodFind(int sum){

        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

        if(sum<=2) return result;

        //big与small指针
        int small=1,big=2;
        int tmpSum=small+big;
        ArrayList<Integer> tmp;

        while (small<big && big<sum){
            if(tmpSum>sum){
                tmpSum-=small++;
//                small++;
            }else if(tmpSum<sum){
//                big++;
                tmpSum+=++big;
            }else{
                tmp=new ArrayList<Integer>(big-small+1);
                for(int i=small;i<=big;i++){
                    tmp.add(i);
                }
                result.add(tmp);
//                big++;
                tmpSum+=++big;
            }
        }

        return result;

    }

    public ArrayList<ArrayList<Integer>> myFind(int sum){

        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

        if(sum<=2) return result;

        int halfSum=sum/2;
//        ArrayList<Integer> tmp=new ArrayList<Integer>();
        ArrayList<Integer> tmp;
        for(int i=1;i<=halfSum;i++){

            //其实这一步可以变成解一元二次方程，i+n=(sum-(i+i+n)(n+1)/2-1)，可能涉及到开根号
            //如果值合法的话，就是要找的了
            for(int j=0;j<=halfSum;j++){
//                    tmp=new ArrayList<Integer>();

                //等差数列的和
                if((i+j)==(sum-(2*i+j)*(j+1)/2-1)){
                    tmp=new ArrayList<Integer>(j+1);
                    for(int k=i;k<=i+j+1;k++){
                        tmp.add(k);
                    }
                    result.add(tmp);
                    break;
                }else if((i+j)>=(sum-(2*i+j)*(j+1)/2-1)){
                    break;
                }
            }

        }

        return result;
    }


}
