package cumt.tj.learn.algorithms.sort;

/**
 * Created by sky on 17-8-8.
 */
public class BubbleSort<T extends Comparable<T>> {

    public void sort(T[] array){


        int length;
        if(array==null || (length=array.length)<=1) return;

        T tmp;
        for(int i=0;i<length-1;i++){

            for(int j=1;j<length-i;j++){
                if(array[j].compareTo(array[j-1])<0){
                    //将较大的后移
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }

        }

    }

}
