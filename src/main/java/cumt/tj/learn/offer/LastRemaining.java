package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-8.
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 思路：
 * 1. 使用一个大小为n的数组，每个索引index的数组存储index
 *  从0开始遍历到m-1
 *  如果m-1小于n且a[m-1]!=-1，将a[m-1]设为-1，并从下一位开始从0遍历
 *  如果m-1小于n但是a[m-1]==-1，往后面做线性探测到不等于-1的项，并从下一位开始从0遍历
 *  如果在遍历或探测的过程中索引i>=n，i-=n;
 *  如果探测过程中发现不等于-1的索引为index-1，那么index-1就是要找的
 *  这种需要很长的时间
 * 2. 剑指offer复杂分析、简单实现版
 * 3. 环形链表版
 */
public class LastRemaining {

    public int LastRemaining(int n, int m) {

//        return longTime(n,m);
        return simple(n,m);

    }

    public int simple(int n,int m){

        if(n<1 || m<=0) return -1;

        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m) % i;
        }

        return last;

    }

    public int longTime(int n,int m){
        if(n<=1 || m<=0) return -1;
        if(m==1) return n-1;

        //初始化辅助数组
        int[] array=new int[n];

        //遍历
        int pos=0;
        int pre=-1;
        while (true){


            //数m个
            for(int i=0;i<m;i++){

                while (array[pos]==-1){
                    //如果为-1,线性探测
                    pos++;
                    //如果超出了范围
                    while (pos>n-1) pos-=n;
                }

                if(pos==pre) return pre;
                array[pos++]=-1;
                //如果超出了范围
                while (pos>n-1) pos-=n;

            }

            //从pos开始报数，用pre记录pos的初始位置
            pre=pos;
        }
    }
}

