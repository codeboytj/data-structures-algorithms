package cumt.tj.learn.algorithms.search;

import cumt.tj.learn.structures.tree.BinaryTreeNode;

/**
 * Created by sky on 17-5-25.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    //root节点
    private BinaryTreeNode<T> root;

    public BinarySearchTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 查找树中是否存在某个元素
     * @param x 查找的元素
     * @return 是否存在
     */
    public boolean contains(T x){
        //从根节点开始查找
        return contains(x,root);
    }

    /**
     * 查找最小值
     * @return 最小值
     */
    public T findMin(){
        if(isEmpty()){
            throw new RuntimeException("二叉数为空");
        }

        //从根节点查起
        return findMin(root);
    }

    /**
     * 查找最大值
     * @return 最大值
     */
    public T findMax(){
        if(isEmpty()){
            throw new RuntimeException("二叉数为空");
        }
        //从根节点查起
        return findMax(root).getElement();
    }

    /**
     * 插入新元素
     * @param x 要插入的节点的element
     */
    public void insert(T x){
        insert(x,root);
    }

    /**
     * 删除x所在的节点
     * @param x 要删除的节点元素的值
     */
    public void remove(T x){
        remove(x,root);
    }

    private BinaryTreeNode<T> remove(T x,BinaryTreeNode<T> node){
        if(node==null) return node;

        //比较
        if(x.compareTo(node.getElement())<0){
            //x比node小，那么从node的左树中删除
            node.setLeft(remove(x,node.getLeft()));
        }else if(x.compareTo(node.getElement())>0){
            //x比node大，那么从node的右树中删除
            node.setRight(remove(x,node.getRight()));
        }else if(node.getLeft()!=null && node.getRight()!=null){
            //找到了，但是node有两个节点，这是最麻烦的
            //需要从node的右子树中找到最小节点，移动到原来的node节点
            BinaryTreeNode<T> rightTreeNode=node.getRight();T minElement=findMin(rightTreeNode);
            //取代原来的node节点，删除x所在节点的工作就完成了
            node.setElement(minElement);
            //删除右子树原来的最小节点
            node.setRight(remove(minElement,node.getRight()));
        }else{
            //找到了，node有1个或0个节点
            //只有一个子树，那么直接将node引用指向子树就行了
            //一个节点都没有的话，可以直接将element弄成null，也可以将node引用设为null就行了，由于左右子树都为null，这样就能与只有一个子树的情况统一
            node=(node.getLeft()!=null)?(node.getLeft()):(node.getRight());
        }

        return node;
    }

    private BinaryTreeNode<T> insert(T x,BinaryTreeNode<T> node){
        //节点为空，可以插在这儿了
        if(node==null) return new BinaryTreeNode<T>(x);

        //将x与node进行比较
        if(x.compareTo(node.getElement())<0){
            //x比node小，往左树递归，结果作为node的新左树
            node.setLeft(insert(x,node.getLeft()));
        }else if(x.compareTo(node.getElement())>0){
            //x比node大，往右树递归，结果作为node的新右树
            node.setRight(insert(x,node.getRight()));
        }else{
            //碰上重复元素，那就什么都不做
        }

        return node;
    }

    private boolean isEmpty(){
        return root==null;
    }

    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node){
        //空节点
        if(node==null){
            return null;
        }

        while(node.getRight()!=null) {
            //右树不为空，说明未找到最大值，继续循环查找
            node = node.getRight();
        }

        return node;
    }

    private T findMin(BinaryTreeNode<T> node){
        //空节点
        if(node==null){
            return null;
        }else if(node.getLeft()==null){
            //左树为空，说明已经找到最小值
            return node.getElement();
        }else {
            //左树不为空，递归从左树查找
            return findMin(node.getLeft());
        }
    }

    private boolean contains(T x,BinaryTreeNode<T> node){
        //空节点
        if(node==null){
            return false;
        }

        //不是空节点，进行比较
        int compareResult=x.compareTo(node.getElement());

        //递归过程
        if(compareResult<0){
            //节点更大，说明需要往节点左树递归查找
            return contains(x,node.getLeft());
        }else if(compareResult>0){
            //节点更小，说明需要往节点右树递归查找
            return contains(x,node.getRight());
        }else {
            return true;
        }
    }
}
