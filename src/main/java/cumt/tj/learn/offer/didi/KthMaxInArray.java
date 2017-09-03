package cumt.tj.learn.offer.didi;

import java.util.Scanner;

/**
 * Created by sky on 17-8-26.
 */
public class KthMaxInArray {


    public static int theKth(int[] array,int k){

        //先将数组排序
        quickSort(array);

        return array[array.length-k];

    }

    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int leftPos, int rightPos){
//        排除空组数或一元数组
        if(leftPos<rightPos){
//            枢纽元索引
            int pivotPos=leftPos;
//            双向循环的两个移动指针，用于在遍历过程中与数组元素进行比较
            int leftMovePos=leftPos+1;
            int rightMovePos=rightPos;
//            临时变量，用于交换数值
            int tmp;
            for(;;){
                while (a[leftMovePos]<a[pivotPos] && leftMovePos<rightPos) leftMovePos++;
                while (a[rightMovePos]>a[pivotPos] && rightMovePos>leftPos) rightMovePos--;
//            如果左移动指针和右移动指针还没有交叉，交换位置
                if(leftMovePos<rightMovePos){
                    tmp=a[leftMovePos];a[leftMovePos]=a[rightMovePos];a[rightMovePos]=tmp;
                }else {
//                已经交叉，跳出循环，这时就要交换枢纽元和右移动指针的位置，这样枢纽元左边的小，右边的大
                    break;
                }
            }
//                已经交叉，跳出循环，这时就要交换枢纽元和右移动指针的位置，这样枢纽元左边的小，右边的大
            tmp=a[pivotPos];a[pivotPos]=a[rightMovePos];a[rightMovePos]=tmp;
//            递归
            quickSort(a,leftPos,rightMovePos-1);
            quickSort(a,rightMovePos+1,rightPos);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] array=null;
        if (in.hasNextLine()) {//注意while处理多个case
            String[] strings=in.nextLine().split(" ");
            int length=strings.length;
            array=new int[length];
            for(int i=0;i<length;i++){
                array[i]=Integer.valueOf(strings[i]);
            }
        }

        int k=in.nextInt();

        System.out.print(theKth(array,k));

    }

}
