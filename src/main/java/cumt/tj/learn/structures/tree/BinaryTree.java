package cumt.tj.learn.structures.tree;

/**
 * Created by sky on 17-5-24.
 */
@Deprecated
public class BinaryTree<T> {
    //根节点
    BinaryNode<T> rootNode;

    public BinaryTree(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public BinaryTree(T rootElement) {
        this.rootNode=new BinaryNode<T>(rootElement);
    }

    public BinaryTree(T rootElement,BinaryNode<T> leftNode,BinaryNode<T> rightNode){
        this.rootNode=new BinaryNode<T>(rootElement);
        this.rootNode.left=leftNode;
        this.rootNode.right=rightNode;
    }

    public BinaryNode<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public BinaryTree<T> mergeTree(T element, BinaryNode<T> leftTree, BinaryNode<T> rightTree){
        return new BinaryTree<T>(new BinaryNode<T>(element,leftTree,rightTree));
    }
}

@Deprecated
class BinaryNode<T>{
    T element;
    //左节点与右节点
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T element) {
        this.element = element;
    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
