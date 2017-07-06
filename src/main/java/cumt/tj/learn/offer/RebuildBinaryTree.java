package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-6.
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：
 *      根据前序遍历的特点，根节点肯定为第一个元素
 *      而在中序遍历中，根节点左边的肯定是左子树，右边的肯定是右子树
 *      这样，就可以先找到根节点在中序数组中的位置，然后进行递归获取左右子树来构造二叉树
 */
public class RebuildBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        return reConstructBinaryTree(pre,0,pre.length,in,0,in.length);

    }

    private TreeNode reConstructBinaryTree(int [] pre,int preLow,int preUpper,int [] in,int inLow,int inUpper) {

        if(preLow>=preUpper||inLow>=inUpper)
            return null;

        //根节点在前序遍历的第一个元素
        int root=pre[preLow];
        TreeNode rootNode=new TreeNode(root);

        //找到根节点在中序遍历中的索引
        int rootIndex;
        for(rootIndex=inLow;rootIndex<inUpper;rootIndex++){
            if(in[rootIndex]==root){
                break;
            }
        }

        //左、右子树元素个数
        int leftNumber=rootIndex-inLow;

        //左右子树递归
        rootNode.left=reConstructBinaryTree(pre,preLow+1,preLow+1+leftNumber,in,inLow,rootIndex);
        rootNode.right=reConstructBinaryTree(pre,preLow+leftNumber+1,preUpper,in,rootIndex+1,inUpper);

        return rootNode;
    }

    public static void main(String[] args) {
        RebuildBinaryTree rb=new RebuildBinaryTree();
        TreeNode tree=rb.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        return;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
