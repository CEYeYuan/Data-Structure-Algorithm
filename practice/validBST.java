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
        return isValid(Long.MIN_VALUE,Long.MAX_VALUE,root);
       
    }
    
    private boolean isValid(long left,long right,TreeNode root){
        if(root.val>=right||root.val<=left)   return false;
        boolean lef,rig;
        lef=rig=true;
        if(root.left!=null)
            lef=isValid(left,Math.min(right,root.val),root.left);
        if(root.right!=null)
            rig=isValid(Math.max(left,root.val),right,root.right);
        return lef&&rig;
    }
       
}

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
    static boolean ret;
    static long pre;
    public boolean isValidBST(TreeNode root) {
        if(root==null)  return true;
        TreeNode node=root;
        while(node.left!=null)
            node=node.left;
        pre=node.val-1l;
        ret=true;
        inorder(root);
        return ret;
        
    }
    
    private void inorder(TreeNode root){
        if(root.left!=null)
            inorder(root.left);
     
        if(root.val<=pre){
            ret=false;
            pre=root.val;
        }
        else
            pre=root.val;
        if(root.right!=null)
            inorder(root.right);
    }
}