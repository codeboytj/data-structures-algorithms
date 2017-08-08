package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-8.
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。
 *
 * 思路：
 * 以{3,0,1,0,4}为例
 * 1. 先将数组排序{0,0,1,3,4}
 * 2. 一次遍历，得到0的个数k
 * 3. 对于不是0的a[i]，如果a[i+1]=a[i]，则不是连续的;
 * 如果1<a[i+1]-a[i]=j<=(k+1)，那么可以用(j-1)个小大王补齐，k-=(j-1);
 * 如果a[i+1]-a[i]=j>(k+1)，大小王的个数不够，不是连续的
 */
public class IsContinuous {

    public boolean isContinuous(int [] numbers) {

        int length;
        if(numbers==null || (length=numbers.length)<5) return false;

        //先排序，由于输入数组固定为5个，所以即使使用冒泡排序，排序时间也是o(1)
        bubbleSort(numbers);

        //遍历
        //为0的数
        int k=0;
        int interval;
        for(int i=0;i<length-1;i++){
            if(numbers[i]==0){
                k++;
            }else{
                interval=numbers[i+1]-numbers[i];
                if(interval<=0){
                    //重复数字
                    return false;
                }else if(interval==1){
                    //2个相邻的是连续的
                }else{
                    //不是相邻
                    if(interval<=(k+1)) {
                        k-=(interval-1);
                    }else{
                        return false;
                    }
                }
            }

        }

        return true;


    }

    /**
     * 冒泡排序
     * @param numbers
     */
    public void bubbleSort(int[] numbers){

        int length;
        if(numbers==null || (length=numbers.length)<=1) return;

        int tmp;
        for(int i=0;i<length-1;i++){

            for(int j=1;j<length-i;j++){
                if(numbers[j]<numbers[j-1]){
                    //将较大的后移
                    tmp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=tmp;
                }
            }

        }

    }

}
