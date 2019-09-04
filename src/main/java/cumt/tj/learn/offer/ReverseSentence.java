package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-6.
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {

    public String ReverseSentence(String str) {

        return simpleReverse(str);

    }

    /**
     * 不借助jdk，分为2步翻转：
     * 1. 翻转整个句子的每个字符
     * 2. 翻转每个单词的每个字符
     * @param str
     * @return
     */
    public String simpleReverse(String str){

        int length;
        if(str==null || (length=str.length())<=1) return str;

        char[] strArray=str.toCharArray();

        //先翻转整个句子
        reverseSequence(strArray,0,length);

        //反转每一个单词
        int start=0,end=0;
        for(int i=0;i<length;i++){
            if(strArray[i]==32){
                end=i;
                reverseSequence(strArray,start,end);
                start=end+1;
            }
            if(i==length-1){
                reverseSequence(strArray,start,length);
            }
        }

        return new String(strArray);

    }

    public void reverseSequence(char[] strArray,int start,int end){

        int length;
        if(strArray==null||(length=strArray.length)<=1) return;

        int fore=start,behind=end;
        char tmp;
        while (fore<behind){
            tmp=strArray[fore];
            strArray[fore++]=strArray[--behind];
            strArray[behind]=tmp;
        }

    }

    /**
     * 使用Jdk中的spilt切分成单词数组，进行翻转，需要额外的一个数组空间
     * @param str
     * @return
     */
    public String reverseBySpilt(String str){

        int length;
        if(str==null || str.equals("") ||str.equals(" ")) return str;

        //首先需要把分成单词数组
        String[] words=str.split(" ");
        length=words.length;
        if(length<=1) return str;

        //2个指针，指向头尾
        int fore=0,behind=length;
        String tmp;
        while (fore<behind){
            tmp=words[fore];
            words[fore++]=words[--behind];
            words[behind]=tmp;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();

    }

}
