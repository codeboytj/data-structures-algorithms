package cumt.tj.learn.structures.tree;

/**
 * Created by sky on 17-5-24.
 */
public class BinaryTreeNode<T> {
    T element;
    //左节点与右节点
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
