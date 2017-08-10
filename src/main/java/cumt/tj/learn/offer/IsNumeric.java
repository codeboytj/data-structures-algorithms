package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-10.
 *
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 */
public class IsNumeric {

    //指针
    int pos;

    public boolean isNumeric(char[] str) {

        int length;
        if(str==null || (length=str.length)==0) return false;

        readSign(str);
        return readInteger(str) && readDecimal(str);

    }

    /**
     * 读取小数位
     * @param src
     * @return
     */
    public boolean readDecimal(char[] src){

        //如果已经没有了
        if(pos==(src.length)) return true;

        //从小数分界号开始读
        if(src[pos]=='e' || src[pos]=='E'){
            pos++;
            if(pos>=src.length) return false;
            readSign(src);
            return readTillTheEnd(src);
        }else if(src[pos]=='.'){
            pos++;
            if(readInteger(src)){
                if(pos<src.length){
                    if(src[pos]=='E' || src[pos]=='e'){
                        pos++;
                        readSign(src);
                        return readTillTheEnd(src);
                    }else{
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }


    /**
     * 从小数的第一位读到最后
     * @param src
     * @return
     */
    public boolean readTillTheEnd(char[] src){

        //如果已经没有了
        if(pos>=src.length) return false;

        for(int i=pos;i<src.length;i++){
            if(src[i]>'9' || src[i]<'0') return false;
        }

        return true;

    }

    /**
     * 读取整数部分
     * @param src
     */
    public boolean readInteger(char[] src){

        //判断pos是否越界
        if(pos>=src.length) return false;

        //第一位数不能是0
//        if(src[pos]<='0' || src[pos]>'9') return false;
//        pos++;

        //在界限内遍历
        while (pos<src.length){
            if(src[pos]<='9' && src[pos]>='0'){
                pos++;
            }else{
                //遇到小数分界
                if(src[pos]=='E' || src[pos]=='e' || src[pos]=='.') return true;
                //遇到其他字符
                return false;
            }
        }

        return true;

    }

    /**
     * 读取正负号
     * @param src
     */
    public void readSign(char[] src){

        if(src[pos]=='-'){
            //只有当第一位为＇-'的时候是负数
            pos++;
        }else if(src[pos]=='+'){
            pos++;
        }

    }
}
