package cumt.tj.learn.structures.tree;

/**
 * Created by sky on 17-7-25.
 * 红黑树Java实现
 */
public class RBTree<T extends Comparable<T>> {

    public RBTNode<T> root;

    public RBTree() {

    }


    /**
     * 左旋
     * 1. 将右孩子y的左节点变成节点node的右孩子x
     * 2. 将y的左节点变成自己
     * 3. 将父节点设为y的父节点
     * 4. 自己父节点变成了y
     * 5. x的父节点变成了node
     * @param node
     */
    private void leftRotate(RBTNode<T> node){

        RBTNode<T> right=node.right;
        RBTNode<T> father=node.father;

        if(right.left!=null) {
            //1. 将右孩子right的左节点变成节点node的右孩子
            node.right = right.left;
            //2. 当前右节点的父节点变成了node
            node.right.father=node;
        }

        // 将right的左节点变成自己
        right.left=node;

        //将父节点的孩子换成right
        if(father!=null){
            if(father.left==node){
                father.left=right;
            }else {
                father.right=right;
            }
        }else {
            root=right;
        }

        //3. 将父节点设为right的父节点
        right.father=node.father;
        //4. 自己父节点变成了right
        node.father=right;

    }

    /**
     * 右旋
     * 基本与左旋相反
     * @param node
     */
    private void rightRotate(RBTNode<T> node){

        RBTNode<T> left=node.left;
        RBTNode<T> father=node.father;

        if(left.right!=null) {
            //1. 将左孩子left的右节点变成节点node的左孩子
            node.left = left.right;
            //2. 当前左节点的父节点变成了node
            node.left.father=node;
        }

        // 将left的右节点变成自己
        left.right=node;

        //将父节点的孩子换成left
        if(father!=null){
            if(father.left==node){
                father.left=left;
            }else {
                father.left=left;
            }
        }else {
            root=left;
        }

        //3. 将父节点设为left的父节点
        left.father=node.father;
        //4. 自己父节点变成了left
        node.father=left;

    }



    //红黑树节点类
    public static class RBTNode<E extends Comparable<E>>{

        Color color;
        E data;
        RBTNode<E> left;
        RBTNode<E> right;
        RBTNode<E> father;

    }

    public enum Color{
        RED,BLACK
    }

}
