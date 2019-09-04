package cumt.tj.learn.offer;

/**
 * Created by sky on 17-8-25.
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 思路：
 * 利用二叉树的遍历序列来重构二叉树的时候会遇到问题
 * 比如：前序遍历序列{1,2,4}，1为根节点，2为1的左节点，没有问题；但是4可能是2的左节点，也可能是1的右节点
 * 但是我们知道，当4是1的右节点的时候，2的左右节点都为null，因为如果序列中引入了Null，那就不一样了，假设用'#'表示null:
 * 那么，{1,2,#,#,4,#,#}就可以唯一确定这样的二叉树
 * 1
 * 2 4
 * 同理，{1，2，4,#，#，#，#}可以唯一确定这样的二叉树
 * 1
 * 2
 * 4
 * 所以，先把二叉树遍历成带有null的前序遍历序列，然后恢复
 */
public class SerializeTree {

    String Serialize(TreeNode root) {

        //空树
        if(root==null) return null;

        //前序遍历
        TreeNode left=root.left;
        TreeNode right=root.right;

        //存储字符序列
        StringBuilder sb=new StringBuilder();
        sb.append(root.val);

        //递归
        Serialize(left,sb);
        Serialize(right,sb);

        return sb.toString();

    }

    void Serialize(TreeNode root,StringBuilder sb){

        sb.append(',');
        //空树
        if(root!=null){
            //以','为分隔符
            sb.append(root.val);
            //左右子树进行递归
            TreeNode left=root.left;
            TreeNode right=root.right;
            Serialize(left,sb);
            Serialize(right,sb);
        }else{
            sb.append('#');
        }

    }



    TreeNode Deserialize(String str) {

        //空序列
        if(str==null) return null;

        //字符串数组
        String[] serialized=str.split(",");
        //根节点
        TreeNode root=new TreeNode(Integer.valueOf(serialized[0]));

        Deserialize(serialized,1,root);

        return root;
    }

    int Deserialize(String[] serialized,int pos,TreeNode root){

        if(pos<serialized.length){

            //左节点不为空
            if(!serialized[pos].equals("#")){
                root.left=new TreeNode(Integer.valueOf(serialized[pos++]));
                pos=Deserialize(serialized, pos, root.left);
            }else pos++;

            //右节点不为空
            if(!serialized[pos].equals("#")){
                root.right=new TreeNode(Integer.valueOf(serialized[pos++]));
                pos=Deserialize(serialized, pos, root.right);
            }else pos++;

        }

        return pos;

    }

}
