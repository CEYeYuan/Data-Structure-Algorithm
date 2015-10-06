/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        if(root==null)  return true; 
        return height(root)==-1?false:true;
    }

    private int height(TreeNode node){
        if(node==null)  return 0;
        int left=height(node.left);
        if(left==-1)    return -1;
        int right=height(node.right);
        if(right==-1)   return -1;
        if (Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
       
    }
}