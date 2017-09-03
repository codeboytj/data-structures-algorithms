package cumt.tj.learn.offer.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sky on 17-8-26.
 */
public class MaxSubArraySum {

    public static int findGreatestSumOfSubArray(ArrayList<Integer> array){

        int length=array.size();
        if(length==0) return 0;
        if(length==1) return array.get(0);

        int subSum=array.get(0);int currentSum=array.get(0);

        for (int i=1;i<length;i++) {

            if(currentSum<0) currentSum=0;
            currentSum+=array.get(i);
            if(currentSum>subSum) subSum=currentSum;

        }

        return subSum;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ilist=new ArrayList<Integer>();
        while (in.hasNextInt()) {//注意while处理多个case
            ilist.add(in.nextInt());
        }

        System.out.print(findGreatestSumOfSubArray(ilist));

    }

}
