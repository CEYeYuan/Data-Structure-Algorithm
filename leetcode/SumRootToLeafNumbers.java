/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if(root==null)  return 0;
        return sum(root,0);
    }
    
    private int sum(TreeNode root,int cur){
        
        //cur means the sum up to this level (exclusively), or in other word, to its parent node
        /* the sum of the path= sum of (left child)+ sum of (right child) */
        if(root.left==null&&root.right==null)
            return cur*10+root.val;
        int total=0;
        if(root.left!=null){
            total+=sum(root.left,cur*10+root.val);
        }
        if(root.right!=null){
            total+=sum(root.right,cur*10+root.val);
        }
        return total;
    }
}