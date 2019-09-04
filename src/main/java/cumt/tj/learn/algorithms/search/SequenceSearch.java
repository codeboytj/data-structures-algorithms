package cumt.tj.learn.algorithms.search;

/**
 * Created by sky on 17-5-9.
 */
public class SequenceSearch {

    /**
     * 最简单的顺序搜索
     * @param a 输入数组
     * @param i 要查找的元素
     * @return 元素在数组中的索引，没找到返回-1
     */
    public int simpleSearch(int[] a,int i){
        for (int j=0;j<a.length;j++){
            if (a[j]==i) return j;
        }

        return -1;
    }

    /**
     * 改进的顺序搜索。简单的顺序搜索在每次循环都会做2个判断：判断是否是该元素，判断是否超过了数组长度。通过在数组末尾设置哨兵（sentinel）
     * 的方式，使得每次循环不用判断是否超出数组范围，从而减少运行时间
     * @param a 输入数组
     * @param i 要查找的元素
     * @return 元素在数组中的第一个索引，没找到返回-1
     */
    public int sentinelSearch(int[] a,int i){
        int uBound=a.length-1;

        //a原来的末尾元素，复原a的时候用
        int hold=a[uBound];

        //如果不是查找第一个匹配的元素的话，可以在这儿做一个判断，如果末尾元素就是i，直接return
        a[uBound]=i;
        int j;
        for (j=0;;j++){
            if (a[j]==i) break;
        }

        //数组复原
        a[uBound]=hold;
        //如果没有找到，则判断原来的末尾元素是不是要找的元素
        if(j==uBound){
            if (hold==i) return uBound;
            return -1;
        }else {
            return j;
        }
    }

    /**
     * 最终的顺序搜索。增加哨兵的顺序搜索在每次循环都会做一次自增，一次判断和一次数组访问。
     * 现没执行8次判断和数组访问再做一次自增的方式，减少自增此次数，减少运行时间
     * @param a 输入数组
     * @param i 要查找的元素
     * @return 元素在数组中的第一个索引，没找到返回-1
     */
    public int reduceIncreasingSearch(int[] a,int i){
        int uBound=a.length-1;

        //a原来的末尾元素，复原a的时候用
        int hold=a[uBound];

        //如果不是查找第一个匹配的元素的话，可以在这儿做一个判断，如果末尾元素就是i，直接return
        a[uBound]=i;
        int j;
        for (j=0;;j+=8){
            if (a[j]==i) break;
            if (a[j+1]==i) {j+=1;break;}
            if (a[j+2]==i) {j+=2;break;}
            if (a[j+3]==i) {j+=3;break;}
            if (a[j+4]==i) {j+=4;break;}
            if (a[j+5]==i) {j+=5;break;}
            if (a[j+6]==i) {j+=6;break;}
            if (a[j+7]==i) {j+=7;break;}
        }

        //数组复原
        a[uBound]=hold;
        //如果没有找到，则判断原来的末尾元素是不是要找的元素
        if(j==uBound){
            if (hold==i) return uBound;
            return -1;
        }else {
            return j;
        }
    }
}
