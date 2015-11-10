/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
       return pathSum(root,sum,0);
    }
    
    private boolean pathSum(TreeNode root,int sum,int cur){
        if(root==null)  return false;
        if(root.left==null&&root.right==null)
            return (cur+root.val)==sum;
        else{
            boolean l,r;
            l=r=false;
            if(root.left!=null)
                l=pathSum(root.left,sum,cur+root.val);
            if(root.right!=null)
                r=pathSum(root.right,sum,cur+root.val);
            return l||r;
        }
    }

}