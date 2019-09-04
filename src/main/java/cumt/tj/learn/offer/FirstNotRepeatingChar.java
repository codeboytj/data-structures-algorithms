package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-4.
 * 题目描述：
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 思路：
 * 如果使用空间，那么时间复杂度肯定不是O(n)
 * 使用一个长为58（z-A+1=122-65+1=58，大小写的ascii码之间隔了几个特殊符号）的数组a[58]，用来辅助
 * 遍历原字符串的每个字符x，如果x的索引为index，假设字符串长度为l
 * 如果x的对应在a中的值a[ascii码-65（最小的A为65）]为0,说明还没有出现，a[ascii码-65（最小的A为65）]+index+1
 * 如果a[ascii码-65（最小的A为65）]，大于0,说明出现过了，a[ascii码-65（最小的A为65）]+l
 * 遍历结束后，遍历数组a，对于最小的，且小于l的，就是第一次出现的
 * 所以，为了时间为O(n)，开辟了一个大小为58的数组
 */
public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {

        //字符串为空
        if(str==null || str.equals("")) return -1;

        //字符串长度
        int length=str.length();

        //辅助数组
        int[] a=new int[58];

        //遍历字符串
        char tmp;
        for(int i=0;i<length;i++){
            tmp=str.charAt(i);

            if(a[tmp-65]==0){
                //还没有出现的字符
                //将值设为字符在字符串中的位置，1开头
                //所以对于那些只出现了一次的字符，a中存的是它在串中索引+1，是小于等于length的
                a[tmp-65]=i+1;
            }else{
                //已经出现过了
                //将值加上字符串的长度
                //所以对于那些只出现了多次的字符，a中存的是它在串的值大于length的
                a[tmp-65]+=length;
            }

        }

        //找出第一次出现的字符
        int min=0;
        for(int i=0;i<58;i++){

            if(a[i]>0){
                if(min==0) min=a[i];
                if(a[i]<min){
                    min=a[i];
                }
            }

        }

        //最后返回的是索引
        return (min>length)?0:min-1;

    }

}
