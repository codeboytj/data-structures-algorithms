package cumt.tj.learn.algorithms.sort;

/**
 * Created by sky on 17-3-16.
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并操作
     * @param a 要进行归并排序的数组
     * @param tmp 临时数组
     * @param leftPos 归并的起始索引，0开头
     * @param rightPos 归并的有数组起始索引
     * @param rightEndPos 归并的结束索引，最大为数组.length-1
     */
    public void merge(int[] a,int[] tmp,int leftPos,int rightPos,int rightEndPos){
//        左边数组末尾指针index
        int leftEndPos=rightPos-1;
//        临时数组指针，从左边数组开始
        int tmpPos=leftPos;
//        归并段总长度
        int mergeLength=rightEndPos-leftPos+1;

//        两边数组都还没有遍历完成
        while(leftPos<=leftEndPos && rightPos<=rightEndPos){
            if(a[leftPos]<a[rightPos]){
//                将左边元素复制到tmp
                tmp[tmpPos]=a[leftPos];
//                左边和临时数组指针移位
                leftPos++;tmpPos++;
            }else{
//                将左边元素复制到tmp
                tmp[tmpPos]=a[rightPos];
//                左边和临时数组指针移位
                rightPos++;tmpPos++;

            }
        }

//        如果左边数组还没有遍历到尽头，剩余的数比临时数组中的数都大
        while (leftPos<=leftEndPos){
//                将左边元素复制到tmp
            tmp[tmpPos]=a[leftPos];
//                左边和临时数组指针移位
            leftPos++;tmpPos++;
        }
//        如果右边数组还没有遍历到尽头，剩余的数比临时数组中的数都大
        while (rightPos<=rightEndPos){
//                将左边元素复制到tmp
            tmp[tmpPos]=a[rightPos];
//                左边和临时数组指针移位
            rightPos++;tmpPos++;
        }
//        将tmp中已排序好的数组复制到a
        for(int i=0;i<mergeLength;i++){
            a[rightEndPos]=tmp[rightEndPos];
            rightEndPos--;
        }
//        for(int m:a){
//            System.out.print(m+" ");
//        }
//        for(int n:tmp){
//            System.out.print(n+" ");
//        }
    }

    public void mergeSort(int[] a){
//        为临时数组分配空间，让所有递归过程使用一个临时数组，减少空间浪费
        int[] tmp=new int[a.length];
        mergeSort(a,tmp,0,a.length-1);
    }

    public void mergeSort(int[] a,int[] tmp, int leftPos,int rightEndPos){
//        右边数组起始位
        int rightPos=(rightEndPos+leftPos)/2+1;
//        左边数组结束索引
        int leftEndPos=rightPos-1;
        if(leftPos<rightEndPos){
//            分别对左右两边数组递归排序
            mergeSort(a,tmp,leftPos,leftEndPos);
            mergeSort(a,tmp,rightPos,rightEndPos);
//            此时左右两边各自已排好顺序，开始归并
            merge(a,tmp,leftPos,rightPos,rightEndPos);
        }
    }
}
