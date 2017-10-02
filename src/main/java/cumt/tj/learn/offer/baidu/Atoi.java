package cumt.tj.learn.offer.baidu;

/**
 * Created by sky on 17-10-2.
 * atoi()函数的功能：将字符串转换成整型数；atoi()会扫描参数nptr字符串，跳过前面的空格字符，
 * 直到遇上数字或正负号才开始做转换，而再遇到非数字或字符串时（'\0'）才结束转化，
 * 并将结果返回（返回转换后的整型数）。
 */
public class Atoi {

    public int atoi(String str){

        if(str==null) return 0;

        int i=0;//初始指针位置

        //取出字符串前面的空格
        while (str.charAt(i)==' '){
            i++;
        }

        //识别正负号
        int signal=1;
        if(str.charAt(i)=='-'){
            signal=-1;
            i++;
        }else if(str.charAt(i)=='+'){
            i++;
        }

        //取数
        char c;
        int result=0;
        int length=str.length();
        while (i<length &&(c=str.charAt(i++))<='9' && c>='0'){
            result*=10;
            result=result+(c-'0');
        }

        return result*signal;

    }

}
