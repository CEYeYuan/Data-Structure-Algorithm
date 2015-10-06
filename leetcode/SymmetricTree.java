/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return areSymetric(root.left,root.right);
    }
    private boolean areSymetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)   return true;
        else if((left==null&&right!=null)||(left!=null&&right==null))   return false;
        else{
            if(left.val!=right.val)     return false;
            return areSymetric(left.right,right.left)&&areSymetric(left.left,right.right);
        }
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        Stack<TreeNode> s1,s2;
        s1=new Stack<TreeNode>();
        s2=new Stack<TreeNode>();
        s1.push(root.left);
        s2.push(root.right);
        while(!s1.isEmpty()){
            TreeNode left=s1.pop();
            TreeNode right=s2.pop();
            if(left==null&&right==null) continue;
            else if((left==null&&right!=null)||(left!=null&&right==null))   return false;
            else{
                if(left.val!=right.val)     return false;
                s1.push(left.right);
                s2.push(right.left);
                s1.push(left.left);
                s2.push(right.right);
            }
        }
        return true;
    }
}