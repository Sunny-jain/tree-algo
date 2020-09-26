/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<Node>();
        if(root==null)
        {
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            Node t=queue.peek();
            for(int i=0;i<size;i++)
            {
                Node temp=queue.poll();
                if(i==0)
                {
                    t=temp;
                }
                else
                {
                    t.next=temp;
                    t=temp;
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
            t.next=null;
        }
        return root;
    }
}
