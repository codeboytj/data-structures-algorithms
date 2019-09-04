package cumt.tj.learn.structures.stack;

/**
 * Created by sky on 17-5-13.
 * 栈，《数据结构与算法分析——java语言描述》第3.6节
 */
public class ArrayStack {
    //栈的数组实现，也就是说目前栈大小是固定的。
    private int[] intStack;
    //当前栈顶元素索引
    private int topOfStack=-1;

    /**
     * 构造函数，初始化栈
     * @param length 栈的大小
     */
    public ArrayStack(int length){
        intStack=new int[length];
    }

    /**
     * 推入栈，如果栈中元素已满，返回false
     * @param item 新推入的元素
     * @return
     */
    public boolean push(int item){
        //栈已满
        if(topOfStack==intStack.length){
            return false;
        }

        //栈未满，自增操作在推入之前进行，因为一开始topStack为-1
        intStack[++topOfStack]=item;
        return true;
    }

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    public int pop(){
        return intStack[topOfStack--];
    }
}
