package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-23.
 *
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路：
 * 分为2种情况：
 *      1. 该节点有右子树，那么求右子树的中序遍历的第一个节点
 *      2. 该节点无右子树，那么分为
 *          1. 无父节点，那么该节点为根节点，那么中序遍历没有下一节点
 *          2. 有父节点，那么有分为：
 *              1. 该节点为父节点的左节点，那么下一节点为父节点
 *              2. 该节点为父节点的右节点，那么下一节点为以父节点作为当前节点进行递归
 */
public class GetNextTreeNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        //空节点
        if(pNode==null) return null;

        //该节点有右子树，那么求右子树的中序遍历的第一个节点
        if(pNode.right!=null) return getFirst(pNode.right);


        //该节点无右子树，那么
        return getNextIfNoRight(pNode);

    }

    /**
     * 如果没有右子树的处理函数
     * @param pNode
     * @return
     */
    public TreeLinkNode getNextIfNoRight(TreeLinkNode pNode){

        TreeLinkNode father=pNode.next;
        //如果没有父节点，那么该节点为根节点，又没有右子树，那么中序遍历没有下一节点
        if(father==null) return null;

        //有父节点，那么有分为：
        //该节点为父节点的左节点，那么下一节点为父节点
        if (father.left== pNode) return father;
        //该节点为父节点的右节点，那么下一节点为以父节点作为当前节点进行递归
        return getNextIfNoRight(father);

    }


    /**
     * 获取树的中序遍历的第一个节点
     * @param pNode 根节点
     * @return
     */
    public TreeLinkNode getFirst(TreeLinkNode pNode){

        //空节点
        if(pNode==null) return null;

        //如果有左节点
        while (pNode.left!=null){
            pNode=pNode.left;
        }

        //当前节点的没有左子树，那么它就是中序遍历的第一个节点
        return pNode;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }

}