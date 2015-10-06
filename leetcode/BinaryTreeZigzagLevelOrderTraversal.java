/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> level;
        if(root==null){
            return list;
        }
        else{
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            Stack<TreeNode> stack=new Stack<TreeNode>();
            queue.add(root);
            int count=1;
            int next=0;
            boolean leftToright=true;
            while(!queue.isEmpty()){
                TreeNode node;
                level=new ArrayList<Integer>();
                for(int i=0;i<count;i++){
                    
                    node=queue.removeFirst();
                    if(!leftToright){
                        level.add(stack.pop().val);
                    }
                    else
                        level.add(node.val);
                    if(node.left!=null){
                            if(leftToright)
                                stack.push(node.left);
                            queue.add(node.left);
                            next++;
                    }
                    if(node.right!=null){
                        if(leftToright)
                            stack.push(node.right);
                        queue.add(node.right);
                        next++;
                    }
                }
                count=next;
                next=0;
                leftToright=!leftToright;
                list.add(level);
            }
        }
        return  list;
    }
}