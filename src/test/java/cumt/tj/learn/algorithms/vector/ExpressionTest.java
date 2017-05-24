package cumt.tj.learn.algorithms.vector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sky on 17-5-14.
 */
public class ExpressionTest {
    @Test
    public void infixToPostfix(){
        Expression expression=new Expression();
        //基本运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b".toCharArray())),"ab-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a+b".toCharArray())),"ab+");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a*b".toCharArray())),"ab*");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a/b".toCharArray())),"ab/");
        //混合运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b+c".toCharArray())),"ab-c+");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b-c".toCharArray())),"ab-c-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b*c".toCharArray())),"abc*-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b/c".toCharArray())),"abc/-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b/c-b*c".toCharArray())),"abc/-bc*-");
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-b-c*b".toCharArray())),"ab-cb*-");
        //带括号运算
        assertEquals(String.copyValueOf(expression.infixToPostfix("a-(b-c)*b".toCharArray())).substring(0,7),"abc-b*-");
    }
}
