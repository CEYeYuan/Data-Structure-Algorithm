/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> level;
        if(root==null){
            return list;
        }
        else{
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            queue.add(root);
            int count=1;
            int next=0;
            while(!queue.isEmpty()){
                level=new ArrayList<Integer>();
                for(int i=0;i<count;i++){
                    TreeNode node=queue.removeFirst();
                    level.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                        next++;
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                        next++;
                    }
                }
                count=next;
                next=0;
                list.add(level);
            }
        }
        return  list;
    }
}