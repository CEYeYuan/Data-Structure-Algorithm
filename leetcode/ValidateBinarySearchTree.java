/*
###
1.min max way
2.inorder traversal
###
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

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)  return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode node){
       Stack<TreeNode> stack=new Stack<TreeNode>();
       Integer pre=null;
       while(node!=null||!stack.isEmpty()){
            while(node!=null){
              stack.push(node);
              node=node.left;
             }
           node=stack.pop();
           System.out.println(node.val);
           if(pre==null)
                pre=node.val;
            else{
                if(node.val<=pre)
                    return false;
                pre=node.val;
            }
           node=node.right;
       }
       return true;
    }
}