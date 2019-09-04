package cumt.tj.learn.offer;

import java.util.ArrayList;

/**
 * Created by sky on 17-7-30.
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    /**
     * 如果popA[0]在pushA中重复出现，这种方法无法判别
     * @param pushA
     * @param popA
     * @return
     */
    public boolean isPopOrder(int [] pushA,int [] popA) {

        //对于只有一个元素的情况
        if(pushA.length==1 && popA.length==1 && popA[0]==pushA[0]) return true;

        //1.利用popA的第一个元素把pushA一分为二
        //比如12345被45321分为：1234与5
        ArrayList<Integer> help=new ArrayList<Integer>();
        int lastIndex=pushA.length-1;
        for(int i=pushA.length-1;i>=0;i--){
            if(pushA[i]!=popA[0]){
                help.add(pushA[i]);
                lastIndex--;
            }else {
                break;
            }
        }
        //pushA中并没有popA
        int helpSize=help.size();
        if(helpSize==0) return false;

        //2.这样一来，如果是弹出序列的一种，对于popA中的数，要么来自pushA的末尾，要么来自help的开头
        int firstIndex=0;
        for(int j=0;j<popA.length;j++){

            if(firstIndex<helpSize && popA[j]==help.get(firstIndex)){
                firstIndex++;
            }else if( lastIndex>=0 && popA[j]==pushA[lastIndex]){
                lastIndex--;
            }else{
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {

        IsPopOrder isPopOrder=new IsPopOrder();
//        System.out.println(isPopOrder.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
//        System.out.println(isPopOrder.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,2,1}));
//        System.out.println(isPopOrder.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
//        System.out.println(isPopOrder.isPopOrder(new int[]{1,2,3,4,5},new int[]{3,5,4,2,1}));
        System.out.println(isPopOrder.isPopOrder(new int[]{1},new int[]{1}));


    }

}
