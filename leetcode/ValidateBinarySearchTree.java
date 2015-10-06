/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
    public boolean isValidBST(TreeNode root) {
        if(root==null)  return true;
        int left,right;
        left=right=root.val;
        return isValid(Integer.MIN_VALUE-1l,Integer.MAX_VALUE+1l,root,true);
       
    }
    
    private boolean isValid(long left,long right,TreeNode root,boolean isRoot){
        if(root==null)  return true;
        if(!isRoot&&((root.val>=right)||(root.val<=left)))
            return false;
        boolean lef,rig;
        lef=rig=true;
        if(root.left!=null)
            lef=isValid(left,Math.min(right,root.val),root.left,false);
        if(root.right!=null)
            rig=isValid(Math.max(left,root.val),right,root.right,false);
        return lef&&rig;
    }
       
}