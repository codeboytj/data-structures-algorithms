package cumt.tj.learn.structures.tree;

/**
 * Created by sky on 17-9-17.
 */
public class AVLTree<T extends Comparable<? super T>> {

    private AVLNode<T> root;

    public void insert(T element){
        //二叉查找树的插入方法进行插入
        //然后对于不满足平衡要求的进行旋转
        root=insert(element,root);
    }

    /**
     * 插入函数具体实现
     * @param x
     * @param node
     * @return
     */
    private AVLNode<T> insert(T x,AVLNode<T> node){

        //节点为空，可以插在这儿了
        if(node==null) return new AVLNode<T>(x,1);

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

        //重新构造平衡
        node= newBalance(node,x);

        //重新计算高度
        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);

        return node;

    }

    /**
     * 返回树的高度
     * @param node
     * @return
     */
    private int height(AVLNode<T> node){
        return (node==null)?0:node.height;
    }

    /**
     * 获取树的高度
     * @return
     */
    public int height(){
        return root.getHeight();
    }

    /**
     * 构建新平衡，返回更改后的根节点
     * @param node
     * @param x
     * @return
     */
    private AVLNode<T> newBalance(AVLNode<T> node,T x){

        //左右子树
        AVLNode<T> left=node.getLeft(),right=node.getRight();
        //平衡因子
        int balanceFactor=height(left)-height(right);

        if(balanceFactor>=2){
            //新节点在左子树破坏了平衡
            if(x.compareTo(left.getElement())<0){
                //新节点插入到左子树的左节点
                //需要一次旋转
                node=rotateWithLeftChild(node);

            }else{
                //新节点插入到左子树的右节点
                //需要两次旋转
                node=doubleRotateWithLeft(node);

            }

        }else if(balanceFactor<=-2){
            //新节点在右子树破坏了平衡
            if(x.compareTo(right.getElement())<0){
                //新节点插入到右子树的左节点
                //需要一次旋转
                node=doubleRotateWithRight(node);

            }else{
                //新节点插入到右子树的右节点
                //需要两次旋转
                node=rotateWithRightChild(node);

            }

        }else{
            //并没有破坏平衡
        }

        return node;
    }

    /**
     * 新节点插入到左子树的左节点时破坏平衡
     * @param node
     * @return
     */
    private AVLNode<T> rotateWithLeftChild(AVLNode<T> node){
        //新节点插入到左子树的左节点

        //左子树
        AVLNode<T> left=node.getLeft();
        //left的右节点变为node的左节点
        node.setLeft(left.getRight());
        //将node变为left的右节点
        left.setRight(node);
        //node与left的高度会变化
        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);
//        left.setHeight(Math.max(left.getLeft().getHeight(),left.getRight().getHeight())+1);

        return left;
    }

    /**
     * 新节点插入到左子树的右节点时破坏平衡
     * @param node
     * @return
     */
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> node){

        AVLNode<T> left=node.getLeft();

        //先围绕左子树做RR旋转
        node.setLeft(rotateWithRightChild(left));
        //然后围绕node做LL旋转
        return rotateWithLeftChild(node);

    }

    /**
     * 新节点插入到右子树的左节点时破坏平衡
     * @param node
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> node){

        AVLNode<T> right=node.getLeft();

        //先围绕右子树做LL旋转
        node.setRight(rotateWithLeftChild(right));
        //然后围绕node做RR旋转
        return rotateWithRightChild(node);

    }

    /**
     * 新节点插入到右子树的右节点时破坏平衡
     * @param node
     * @return
     */
    private AVLNode<T> rotateWithRightChild(AVLNode<T> node){
        //新节点插入到右子树的右节点

        //右子树
        AVLNode<T> right=node.getRight();
        //right的左节点变为node的右节点
        node.setRight(right.getLeft());
        //将node变为right的左节点
        right.setLeft(node);
        //node与right的高度会变化
        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);
//        right.setHeight(Math.max(right.getLeft().getHeight(),right.getRight().getHeight())+1);

        return right;
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

        public AVLNode(E element, int height) {
            this.element = element;
            this.height = height;
        }

        public AVLNode<E> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<E> left) {
            this.left = left;
            //此时，由于插入到左子树，height要+1
//            this.height++;
        }

        public AVLNode<E> getRight() {
            return right;
        }

        public void setRight(AVLNode<E> right) {
            this.right = right;
            //此时，由于插入到右子树，height要-1
//            this.height--;
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
