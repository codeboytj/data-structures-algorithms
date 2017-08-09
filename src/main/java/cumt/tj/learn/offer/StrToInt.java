package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-9.
 *
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例：
 * 输入：
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class StrToInt {

    public int StrToInt(String str) {

        int result=0;
        int length;
        if(str==null || (length=str.length())==0) return 0;

        //转化成字符数组
        char[] strArray=str.toCharArray();

        //遍历字符串
        //判断第一位是否是符号位
        int flag=1;
        int start=0;
        if(strArray[0]=='-'){
            flag=-1;
            start=1;
        }else if(strArray[0]=='+'){
            start=1;
        }

        //从第一位不是符号位的开始遍历
        for(int i=start;i<length;i++){

            if('0'<=strArray[i] && strArray[i]<='9'){
                result=result*10+(strArray[i]-'0');
            }else{
                //非法输入
                return 0;
            }

        }

        return flag*result;

    }

}
