package cumt.tj.learn.offer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sky on 17-8-23.
 */
public class IsSymmetricalTest {

    @Test
    public void isSym(){

        IsSymmetrical s=new IsSymmetrical();

        TreeNode root=new TreeNode(5);
        TreeNode first=new TreeNode(3);
        TreeNode firstD=new TreeNode(3);
        TreeNode second=new TreeNode(4);
        TreeNode secondD=new TreeNode(4);
        TreeNode third=new TreeNode(6);
        TreeNode forth=new TreeNode(2);
        TreeNode fifth=new TreeNode(1);
        TreeNode sixth=new TreeNode(1);

        root.left=first;root.right=firstD;
        first.left=second;firstD.right=secondD;
        second.left=third;secondD.right=forth;
        third.left=fifth;forth.right=sixth;

        assertEquals(s.isSymmetrical(root),false);

        first.val=5;firstD.val=5;
        second.val=5;secondD.val=5;secondD.right=null;
        third.val=5;forth.val=5;
        third.left=null;forth.right=null;
        second.left=forth;

        assertEquals(s.isSymmetrical(root),false);

    }

}
