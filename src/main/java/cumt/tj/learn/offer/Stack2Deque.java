package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-6.
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：
 *      栈先进后出，队列先进先出，要用2个栈完成一个队列，
 *      需要将从栈1压入数据，然后将栈1的元素压入到栈2之中，然后从栈2中弹出，这样就达到先进先出的目的
 *      问题是转移元素的时机：
 *      如果每压入一个元素，然后把都要把元素转移到栈2,这样是行不通的，达不到先进后出的效果。
 *      如果在弹出元素的时候，将所有元素转移到栈2,这样能达到先进先出的效果。
 *      但是问题在于如果每次弹出元素的时候，都进行转移的话，如果栈2中还有元素没有弹出，就样就会产生乱序，
 *      所以在转移之前应该先做出判断，是否栈2中还有元素没有弹出，只能在栈2为空的情况下转移元素才是合理的。
 */
public class Stack2Deque {
    java.util.Stack<Integer> stack1 = new java.util.Stack<Integer>();
    java.util.Stack<Integer> stack2 = new java.util.Stack<Integer>();

    public void push(int node) {

        stack1.push(node);

    }

    public int pop() {
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Stack2Deque deque=new Stack2Deque();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.print(deque.pop());

        deque.push(5);
        System.out.print(deque.pop());
    }
}
