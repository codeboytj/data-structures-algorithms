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
     *
     * 含有双向循环的快速排序，这样能防止simpleQuickSort()在遇到数组元素全部相等时，会花掉平方时间的缺点
     * 但是仍然选择第一个元素作为枢纽元，在输入数据为预排序或反序的时候，会造成平方时间
     * @param a 待排序数组
     */
    public void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    /**
     * 含有双向循环,交换起始元素和随机元素的快速排序
     * 这样以来，当数据预排序或反序时，不会造成平方时间
     * @param a 待排序数组
     */
    public void randQuickSort(int[] a){
        randQuickSort(a,0,a.length-1);
    }

    /**
     * 含有双向循环,交换起始元素和随机元素，忽略小范围数组的快速排序
     * 对于小范围数组来说，插入排序速度高于快速排序，因此在最后，采用插入排序来处理忽略掉的小范围数组
     * @param a 待排序数组
     */
    public void insertAndQuickSort(int[] a){
//        忽略小范围数组进行排序
        cutRandQuickSort(a,0,a.length-1,2);
//        整体插入排序
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.insertionSort(a);
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

    /**
     * 含有双向循环的快速排序内部实现
     * @param a 待排序数组
     * @param leftPos 排序起点
     * @param rightPos 排序终点
     */
    private void quickSort(int[] a, int leftPos, int rightPos){
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

    /**
     * 含有双向循环，交换起始元素和随机元素的快速排序内部实现
     * @param a 待排序数组
     * @param leftPos 排序起点
     * @param rightPos 排序终点
     */
    private void randQuickSort(int[] a, int leftPos, int rightPos){
//        排除空组数或一元数组
        if(leftPos<rightPos) {
//            临时变量，用于交换数值
            int tmp;
//            取[leftPos,rightPos]之间的随机数，交换起始元素和随机元素
            int randIndex = leftPos + (int) (Math.random() * (rightPos - leftPos));
            tmp = a[leftPos];
            a[leftPos] = a[randIndex];
            a[randIndex] = tmp;
//            枢纽元索引
            int pivotPos=leftPos;
//            双向循环的两个移动指针，用于在遍历过程中与数组元素进行比较
            int leftMovePos=leftPos+1;
            int rightMovePos=rightPos;
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
            randQuickSort(a,leftPos,rightMovePos-1);
            randQuickSort(a,rightMovePos+1,rightPos);
        }
    }

    /**
     * 忽略一小范围数组内部排序
     * @param a 待排序数组
     * @param leftPos 起始位置
     * @param rightPos 结束位置
     * @param cutOff 小范围尺度
     */
    private void cutRandQuickSort(int[] a, int leftPos, int rightPos,int cutOff){
        if(leftPos+cutOff<rightPos){
//            临时变量，用于交换数值
            int tmp;
//            取[leftPos,rightPos]之间的随机数，交换起始元素和随机元素
            int randIndex = leftPos + (int) (Math.random() * (rightPos - leftPos));
            tmp = a[leftPos];
            a[leftPos] = a[randIndex];
            a[randIndex] = tmp;
//            枢纽元索引
            int pivotPos=leftPos;
//            双向循环的两个移动指针，用于在遍历过程中与数组元素进行比较
            int leftMovePos=leftPos+1;
            int rightMovePos=rightPos;
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
            cutRandQuickSort(a,leftPos,rightMovePos-1,cutOff);
            cutRandQuickSort(a,rightMovePos+1,rightPos,cutOff);
        }
    }
}
