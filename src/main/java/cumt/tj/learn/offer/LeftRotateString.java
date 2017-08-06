package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-6.
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 */
public class LeftRotateString {

    public String LeftRotateString(String str,int n) {

        char[] strArray=str.toCharArray();
//        acrobaticsRotate(strArray,n);
        blockRotate(strArray,n);

        return new String(strArray);
    }

    /**
     * 块旋转,例“abcdefg”，移3位
     * 先看成2块A=abc、B=defg
     * 然后将B看成2块，末尾一块长度等于A，即B1=d以及B2=efg
     * 先交换A与B2，这样A就在正确的位置上了，变成B2B1A了
     * 现在相当与把B1与B2交换的2块问题了，所以可以递归
     * @param s
     * @param n
     */
    public void blockRotate(char[] s,int n){

        int length;
        if(s==null || (length=s.length)<=1) return;

        blockRotate(s,0,n,length);

    }

    public void blockRotate(char[] s,int start,int n,int end){

        if(end<=start || (n>=end-start)||n<=0)
            return;


        char tmp;
        //左半边小于右边半
        if((n)<=(end-start-n)){
            //将右半边分为2半B1、B2
            //将左半边与B2交换
            for(int i=start;i<n+start;i++){
                //交换
                tmp=s[i];
                s[i]=s[end-n+i-start];
                s[end-n+i-start]=tmp;
            }
            //现在对B2，B1进行递归
            if((n)<=(end-start-n)) blockRotate(s,start,n,end-n);
        }else {
            //将左半边分为2半A1、A2
            //将右半边与A1交换
            for(int i=start+n;i<end;i++){
                //交换
                tmp=s[i];
                s[i]=s[i-n];
                s[i-n]=tmp;
            }
            //对右边A2A1进行递归
            blockRotate(s,end-n,2*n+start-end,end);
        }

    }


    /**
     * 杂技旋转,参考编程珠玑
     * @param s
     * @param n 移动n位
     * @return
     */
    public void acrobaticsRotate(char[] s,int n){

        int k;
        int pre;
        int length=s.length;
        char tmp;

        for(int i=0;i<gcd(length,n);i++){
            tmp=s[i];
            pre=i;
            while (true){
                k=pre+n;
                if(k>=length) k-=length;
                if(k==i) break;
                s[pre]=s[k];
                pre=k;
            }
            s[pre]=tmp;
        }

    }

    /**
     * 求最大公约数
     * @param i
     * @param j
     * @return
     */
    public int gcd(int i,int j){

        while (true){
            while (i>j){
                i-=j;
            }
            while (j>i){
                j-=i;
            }
            if(i==j) return i;
        }

    }

}
