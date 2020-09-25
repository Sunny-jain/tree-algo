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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int lh=balance(root.left);
        int rh=balance(root.right);
        if(Math.abs(lh-rh)>1)
        {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    static int balance(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=balance(root.left);
        int rh=balance(root.right);
        if(lh>rh)
        {
            return lh+1;
        }
        else
        {
            return rh+1;
        }
    }
}
