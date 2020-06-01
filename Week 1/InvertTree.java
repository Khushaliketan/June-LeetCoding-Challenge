/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class InvertTree{
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        //Recursively calling for left and right subtrees  
        
        invertTree(root.left);
        invertTree(root.right);
        
        //Terminating condition and also the inversion
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        
        return root;
    }
}
