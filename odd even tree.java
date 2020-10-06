PROBLEM STATEMENT
A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).




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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        boolean even=true;
        while(!queue.isEmpty())
        {
            int prev=even?Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                
                TreeNode temp=queue.poll();
                    if(even && (temp.val%2==0 || temp.val<=prev))
                    {
                        return false;
                    }
                    if(!even && (temp.val%2!=0 || temp.val>=prev))
                    {
                        return false;
                    }
                
                if(temp.left!=nuhttps://leetcode.com/problems/range-sum-of-bst/ll)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
                
                prev=temp.val;
            }
            even=!even;
            
        }
        
        return true;
    }
}
