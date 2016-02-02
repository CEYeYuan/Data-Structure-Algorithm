/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        if(root!=null)
            helper(list,root,"");
        return list;
    }
    
    private void helper(List<String> list,TreeNode root,String s){
        if(root.left==null&&root.right==null){
            s=s+root.val;
            list.add(s);
        }else{
           s=s+root.val+"->";
           if(root.left!=null)
                 helper(list,root.left,s);
            if(root.right!=null)
                 helper(list,root.right,s);
        }
                
    }
}