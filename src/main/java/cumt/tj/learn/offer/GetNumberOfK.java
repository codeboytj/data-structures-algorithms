package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-5.
 * 题目描述：
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路：
 * 二分查找找到这个数字k的位置index
 * 此时定义两个指针，总index出发，一个向左一个向右，找到不等于k的数字的位置k1,k2
 * 那么k出现了，k2-k1-1次
 *
 */
public class GetNumberOfK {

    public int getNumberOfK(int [] array , int k) {

        int length;
        //不合法
        if(array==null || (length=array.length)==0) return 0;


        //二分查找
        int index=binarySearch(array,k);

        //没找到，返回
        if(index==-1) return 0;

        //前后两个指针
        int fore=index-1,behind=index+1;

        while (fore>=0){
            if(array[fore]!=k) break;
            fore--;
        }
        while (behind<=length-1){
            if(array[behind]!=k) break;
            behind++;
        }

        return behind-fore-1;

    }

    public int binarySearch(int[] array,int k){

        int length;
        //不合法
        if(array==null || (length=array.length)==0) return -1;

        return binarySearch(array,0,length,k);

    }

    public int binarySearch(int[] array,int start,int end,int k){

        if(end-start-1<0) return -1;
        if(end-start-1==0) return (array[start]==k)?start:-1;

        int center=(end+start)/2;

        if(array[center]==k){
            return center;
        }else if(array[center]>k){
            return binarySearch(array,start,center,k);
        }else {
            return binarySearch(array,center,end,k);
        }

    }

}
