package cumt.tj.learn.structures;

/**
 * Created by sky on 17-5-11.
 */
public class Tree {

}

//数结构使用链表实现的，具体见《数据结构与算法分析——java语言描述版》第四章
class TreeNode<T>{
    T  element;
    //第一个儿子节点
    TreeNode firstChild;
    //下一个兄弟节点
    TreeNode nextSibling;
}