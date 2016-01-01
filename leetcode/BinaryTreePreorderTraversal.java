/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        /*      this->left->right   */
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)  return list;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(true){
            list.add(root.val);
            if(root.right!=null)
                stack.push(root.right);
            root=root.left;
            if(root==null){
                if(stack.isEmpty())
                    break;
                else
                    root=stack.pop();
            }
        }
        return list;
    }
}