package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-9.
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * 思路：
 * 1. 将A[i]作为2次遍历的分水岭
 *    将B[0]初值设为1
 *    第一次遍历，从第2个元素开始
 *          B[i]=A[0]*……*A[i-1]
 *    第2次遍历，从第n-1开始往前遍历
 *          B[i]=N[i]*A[n-1]*……A[i+1]
 */
public class Multiply {

    public int[] multiply(int[] A) {

        int length;
        if(A==null) return null;

        length=A.length;
        int[] B=new int[length];
        if(length==0) return B;

        B[0]=1;
        int multiply=1;
        for(int i=1;i<length;i++){
            multiply*=A[i-1];
            B[i]=multiply;
        }

        multiply=1;
        for(int i=length-2;i>=0;i--){
            multiply*=A[i+1];
            B[i]*=multiply;
        }

        return B;
    }

}
