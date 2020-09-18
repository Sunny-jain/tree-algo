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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mn=new ArrayList<>();
        if(root==null)
        {
            return mn;
        }
        Queue<TreeNode> queue=new LinkedList();
        Stack<Integer> stack=new Stack<Integer>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty() || !stack.isEmpty())
        {
            int size=queue.size();
            ArrayList<Integer> arr=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=queue.poll();
                if(count%2==0)
                {
                    arr.add(temp.val);
                }
                else
                {
                    stack.push(temp.val);
                }
                if(temp.left!=null)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
            }
            if(count%2!=0)
            {
                while(!stack.isEmpty())
                {
                    arr.add(stack.pop());
                }
            }
            count++;
            mn.add(arr);
        }
        return mn;
    }
}
