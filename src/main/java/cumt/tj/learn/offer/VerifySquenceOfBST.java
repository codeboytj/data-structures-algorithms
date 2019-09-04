package cumt.tj.learn.offer;

/**
 * Created by sky on 17-7-31.
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {

        int start=0;
        int end=sequence.length;

        //空数组
        if(start==end) return false;

        return verifySquenceOfBST(sequence,start,end);

    }

    public boolean verifySquenceOfBST(int[] sequence,int start,int end){

        //小于2个元素的话，直接是真的
        if(end<=start+2) return true;

        //序列的末尾为根节点
        int root=sequence[end-1];

        //分为前半部分与后半部分
        int behindStart=-1;
        for(int i=start;i<end;i++){
            if(sequence[i]>root){
                //从第一个大于根节点为后半部分
                behindStart=i;
                break;
            }
        }

        //判断后半部分的所有元素是否都大于根节点
        if(behindStart!=-1) {
            for (int i = behindStart; i < end; i++) {
                if (sequence[i] < root) return false;
            }
        }

        if(behindStart!=-1) return verifySquenceOfBST(sequence,start,behindStart) && verifySquenceOfBST(sequence,behindStart,end-1);

        return true;
    }

    public static void main(String[] args) {

        VerifySquenceOfBST verifySquenceOfBST=new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(new int[]{1,2,3,4,5}));
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(new int[]{7,4,6,5}));
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(new int[]{1,2}));
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(new int[]{3,2}));

    }

}
