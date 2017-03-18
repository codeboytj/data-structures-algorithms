package cumt.tj.learn.algorithms.sort;

/**
 * Created by sky on 17-3-18.
 * 插入排序
 */
public class InsertionSort {
    /**
     * 插入排序主算法
     * @param a 需要排序的数组
     */
    public void insertionSort(int[] a){
        int length=a.length;
        int j,t;
//        从[1,length)进行循环
        for (int i=1;i<length;i++){
//            临时变量
            t=a[i];
//            对i及其之前的元素进行遍历，对于大于a[i]的元素，应该一直往后移位
            for(j=i;j>0 && a[j-1]>t;j--){
//                    因为a[j-1]大于a[i]，所以将a[j-1]后移
                   a[j]=a[j-1];
//                   但是此时a[j]=a[j-1]，而a[i]已经不在数组中了
            }
//            将a[i]放回正确的位置
            a[j]=t;
        }
    }
}
