package cumt.tj.learn.offer;

import cumt.tj.learn.structures.tree.Tree;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sky on 17-7-31.
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 思路：递归
 */
public class FindPath {


    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<Integer> onePath=new ArrayList<Integer>();

        if(root!=null) FindPath(onePath,root,target,0);

        return result;

    }

    public void FindPath(ArrayList<Integer> onePath,TreeNode root, int target,int sum) {

        sum=sum+root.val;
        if((sum)<target){

            //继续递归
            ArrayList<Integer> leftList=new ArrayList<Integer>();
            ArrayList<Integer> rightList=new ArrayList<Integer>();
            onePath.add(root.val);
            leftList.addAll(onePath);
            rightList.addAll(onePath);

            TreeNode left=root.left;
            if(left!=null) FindPath(leftList,root.left,target,sum);
            TreeNode right=root.right;
            if(right!=null) FindPath(rightList,root.right,target,sum);

        }else if(sum==target){

            //如果root是根节点，那么这就是一条路径
            if(root.left==null && root.right==null) {
                onePath.add(root.val);
                result.add(onePath);
            }

        }

    }

    public static void main(String[] args) {

        FindPath findPath=new FindPath();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        //10,5,12,4,7
        TreeNode root1=new TreeNode(10);
        root1.left=new TreeNode(5);
        root1.right=new TreeNode(12);
        root1.left.left=new TreeNode(4);
        root1.left.right=new TreeNode(7);

        ArrayList<ArrayList<Integer>> result=findPath.FindPath(root,7);
        System.out.println(result);
        int num=result.size();
        System.out.print(num);

        result=findPath.FindPath(root1,22);
        System.out.println(result);
         num=result.size();
        System.out.print(num);

    }

}
