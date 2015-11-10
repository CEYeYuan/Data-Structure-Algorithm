/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
       if(root==null)   return;
       flatten(root.left);
       flatten(root.right);
       TreeNode right=root.right;
       TreeNode left=root.left;
       root.left=null;
       //now left subtree is flattened. just remove the left subtree, and 
       //set it as the right subtree,then concatenate the right subtree
       //to the end of the list
       root.right=left;
       while(root.right!=null)  root=root.right;
       root.right=right;
    }
}