package cumt.tj.learn.structures.tree;

/**
 * Created by sky on 17-9-17.
 */
public class AVLTree<T extends Comparable<? super T>> {

    public void insert(T element){
        //二叉查找树的插入方法进行插入
        //然后对于不满足平衡要求的进行旋转
    }

    private AVLNode<T> insert(T x,AVLNode<T> node){

        //节点为空，可以插在这儿了
        if(node==null) return new AVLNode<T>(x);

        //将x与node进行比较
        if(x.compareTo(node.getElement())<0){
            //x比node小，往左树递归，结果作为node的新左树
            node.setLeft(insert(x,node.getLeft()));
            //构建新平衡
        }else if(x.compareTo(node.getElement())>0){
            //x比node大，往右树递归，结果作为node的新右树
            node.setRight(insert(x,node.getRight()));
            //构建新平衡
        }else{
            //碰上重复元素，那就什么都不做
        }

        return newBalance(node);
    }

    private AVLNode<T> newBalance(AVLNode<T> node){

        if(node.getHeight()>=2){
            if(node.getLeft().getHeight()==1){
                //新节点插入到左子树的左节点，那么左子树的高度应该为1
                //需要一次旋转
            }else if(node.getLeft().getHeight()==-1) {
                //新节点插入到左子树的右节点，那么左子树的高度应该为-1
                //需要两次旋转
            }
        }else if(node.getHeight()<=-2){
            if(node.getLeft().getHeight()==-1){
                //新节点插入到右子树的右节点，那么右子树的高度应该为-1
                //需要一次旋转
            }else if(node.getLeft().getHeight()==1) {
                //新节点插入到右子树的左节点，那么右子树的高度应该为1
                //需要两次旋转
            }
        }

        return node;
    }

    private AVLNode<T> rotateWithLeftChild(AVLNode<T> node){
        //新节点插入到左子树的左节点

        //左子树
        AVLNode<T> left=node.getLeft();
        //left的右节点变为node的左节点
        node.setLeft(left.getRight());
        //将node变为left的右节点
        left.setRight(node);
        //node与left的高度会变化
        //TODO

        return left;
    }

    private static class AVLNode<E extends Comparable<? super E>>{

        AVLNode<E> left;
        AVLNode<E> right;
        E element;
        //高度为左子树的高度-右子树的高度
        int height;

        public AVLNode(E element) {
            this.element = element;
        }

        public AVLNode<E> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<E> left) {
            this.left = left;
            //此时，由于插入到左子树，height要+1
            this.height++;
        }

        public AVLNode<E> getRight() {
            return right;
        }

        public void setRight(AVLNode<E> right) {
            this.right = right;
            //此时，由于插入到右子树，height要-1
            this.height--;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

}
