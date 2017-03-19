package cumt.tj.learn.algorithms.sort;

/**
 * Created by sky on 17-3-19.
 * 快速排序
 */
public class QuickSort {
    /**
     * 一种简单的快速排序，《编程珠玑》11.2 一种简单的快速排序实现
     * 选取第一个元素作为枢纽元，在输入数据为预排序或反序的时候，会造成平方时间
     * @param a 待排序数组
     */
    public void simpleQuickSort(int[] a){
        simpleSort(a,0,a.length-1);
    }

    /**
     * 简单排序内部实现
     * @param a 待排序数组
     * @param leftPos 起始索引
     * @param rightPos 结束索引
     */
    private void simpleSort(int[] a, int leftPos, int rightPos){
//        排除空组数或一元数组
        if(leftPos<rightPos){
//            枢纽元索引
            int pivotPos=leftPos;
//            移动指针，用于在遍历过程中与数组元素进行比较
            int movePos=pivotPos;
//            临时变量，用于交换数值
            int tmp;
            for(int i=leftPos+1 ;i<=rightPos;i++){
//                a[i]比枢纽元小
                if(a[i]<a[pivotPos]){
//                  移动指针向后移位
                    movePos++;
//                  交换位置
                    tmp=a[i];
                    a[i]=a[movePos];
                    a[movePos]=tmp;
                }
            }
//            现在比枢纽元小的都移到了移动指针以及它之前的位置上了，而枢纽元仍在第一个，
//            将枢纽元和移动指针所指元素位置交换,这样，枢纽元左边的比它小，右边的比它大
            tmp=a[pivotPos];
            a[pivotPos]=a[movePos];
            a[movePos]=tmp;
//            递归
            simpleSort(a,leftPos,movePos-1);
            simpleSort(a,movePos+1,rightPos);
        }
    }
}
