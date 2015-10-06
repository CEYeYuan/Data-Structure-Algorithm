/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> level;
        if(root==null)  return list;
        int count=1;
        int next=0;
        queue.add(root);
        while(!queue.isEmpty()){
            level=new ArrayList<Integer>();
            TreeNode node;
            for(int i=0;i<count;i++){
                node=queue.removeFirst();
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
            list.add(0,level);
            count=next;
            next=0;
        }
        return list;
    }
}