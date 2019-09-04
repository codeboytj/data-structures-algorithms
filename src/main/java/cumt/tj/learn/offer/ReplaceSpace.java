package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-5.
 * 题目：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：
 * 1. 遍历每个字符，遇到空格就替换成“%20”，然后使用Java类库中的StringBuffer逐一存储
 * 2. 不使用Java类库，拿到字符串内部实现的字符数组，对字符数组进行操作：
 *      由于空格只有一个字符，而“%20”有三个字符，所以原字符数组存不了这么多，需要构造一个新数组。
 *      关于新数组的大小，可以先遍历原数组中空格的个数n，然后利用原数组长度l+n*2获得。
 *      这样就可以将原数组的字符复制到新数组，过程之中将空格转换为“%20”
 */
public class ReplaceSpace {

    /**
     * 通过字符数组实现
     * @param str
     * @return
     */
    public String replaceByCharArray(StringBuffer str){

        //原字符串的字符数组
        char[] oldValue=str.toString().toCharArray();
        //原字符串中的空格个数
        int spaceCount=0;

        //计算空格个数
        for(int i=0;i<oldValue.length;i++)
            if(oldValue[i]==' ')
                spaceCount++;

        //新数组
        char[] newValue=new char[spaceCount*2+oldValue.length];

        //复制、替换
        //k指针记录复制到的原数组中的位置
        int k=0;
        for (int j=0;j<newValue.length;j++){

            if(oldValue[k]==' '){
                newValue[j++]='%';
                newValue[j++]='2';
                newValue[j]='0';
            }else {
                newValue[j] = oldValue[k];
            }

            k++;
        }

        return String.valueOf(newValue);


    }

    /**
     * 通过Java类库的StringBuffer的append方法实现
     * @param str
     * @return
     */
    public String replaceByJDK(StringBuffer str) {

        StringBuffer sb=new StringBuffer();

        char tmp;
        for (int i=0;i<str.length();i++){
            tmp=str.charAt(i);
            if(tmp==' ') {
                sb.append("%20");
            }else {
                sb.append(tmp);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace rs=new ReplaceSpace();
        System.out.println(rs.replaceByJDK(new StringBuffer("We Are Happy")));
        System.out.println(rs.replaceByCharArray(new StringBuffer("We Are Happy")));
    }

}
