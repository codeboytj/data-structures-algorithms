package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-3.
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {

        int pivotIndex=numbers.length-1;
        quickSort(numbers,0,pivotIndex,pivotIndex);

        String s="";
        for (int i:numbers) {
            s+=i;
        }

        return s;

    }

    public void quickSort(int[] numbers,int start,int end,int pivot){

        //如果只有一个元素
        if(start>=end) return;

        //枢纽元与头元素换位
        int tmp=numbers[start];numbers[start]=numbers[pivot];numbers[pivot]=tmp;

        //如果只有2个元素
        if(start==(end-1) && numbers[end]<numbers[start]) {
            tmp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = tmp;
        }

        int fore=start+1;int behind=end;
        while (true){

            while (fore<end && compare(numbers[fore],numbers[start])<=0) fore++;
            while (behind>start && compare(numbers[behind],numbers[start])>=0) behind--;

            if(fore<behind && compare(numbers[fore],numbers[behind])>0){

                //换位
                tmp=numbers[fore];numbers[fore]=numbers[behind];numbers[behind]=tmp;

            }else {
                break;
            }

        }

        //换位
        tmp=numbers[start];numbers[start]=numbers[behind];numbers[behind]=tmp;

        //左边排序
        quickSort(numbers,start,behind-1,behind-1);
        //右边排序
        quickSort(numbers,behind+1,end,end);

    }

    public int compare(int a,int b){

        //先求得2个数的位数
        int aNumbers=getNumbers(a);
        int bNumbers=getNumbers(b);

        //如果位数相等，直接比较大小
        if(aNumbers==bNumbers) return a-b;

        //
        char[] aFore=(a+""+b).toCharArray();
        char[] bFore=(b+""+a).toCharArray();

        for(int i=0;i<aFore.length;i++){
            if (aFore[i] < bFore[i]){
                return -1;
            }else if(aFore[i]>bFore[i]){
                return 1;
            }else {
                continue;
            }
        }

        return 0;

//        //a、b的最高位数字
//        int aHighest=getNumberOnPosition(a,aNumbers);
//        int bHighest=getNumberOnPosition(b,bNumbers);
//        int aCurrent=aHighest;
//        int bCurrent=bHighest;
//
//        //如果位数不想等，要逐位进行比较
//        while (true){
//
//            if(aCurrent!=bCurrent){
//                //当前位不同，比较当前位就行了
//                return aCurrent-bCurrent;
//            }else{
//                //当前位相同，需要比较下一位
//
//                //但是都没有下一位了
//                if(aNumbers<=1 && bNumbers <=1) return 0;
//
//                //至少还有一方有下一位
//                if(aNumbers>1){
//                    //a有下一位
//                    aCurrent=getNumberOnPosition(a,--aNumbers);
//                }else {
//                    //a没有下一位
//                    aCurrent=aHighest;
//                }
//
//                if(bNumbers>1){
//                    //b有下一位
//                    bCurrent=getNumberOnPosition(b,--bNumbers);
//                }else {
//                    //b没有下一位
//                    bCurrent=bHighest;
//                }
//
//                continue;
//            }
//        }


    }

    /**
     * 返回指定位的数字
     * @param a
     * @param position
     * @return
     */
    public int getNumberOnPosition(int a,int position){

        a=a%((int)Math.pow(10,position));

        return a/((int)Math.pow(10,position-1));

    }



    /**
     * 返回位数，比如123为3位数
     * @param n
     * @return
     */
    public int getNumbers(int n){

        //先求n的位数
        int m=n;
        int numbers=1;
        while (m>=10){
            m=m/10;
            numbers++;
        }
        return numbers;

    }

}
