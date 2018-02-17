package 剑指offer.二叉树的镜像;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 */
/*二叉树的镜像定义：源二叉树
          8
        /  \
        6   10
       / \  / \
       5  7 9 11
        镜像二叉树
           8
         /   \
        10    6
        / \  / \
       11 9 7   5*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.new TreeNode(8);
        treeNode.left=solution.new TreeNode(6);
        treeNode.left=solution.new TreeNode(10);
        solution.Mirror(treeNode);
    }

    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }else{
            TreeNode tmpNode;
            tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;
            Mirror(root.left);
            Mirror(root.right);
        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
