/*Given inorder and postorder traversal of a tree, construct the binary tree.*/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0)    return null;
        return subTree(postorder.length-1,postorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode subTree(int root_index,int[]postorder,int[] inorder,int start,int end) {
        TreeNode root=new TreeNode(postorder[root_index]);
        if(end-start<=0)    return root;
        int i=0;
        for(i=start;i<=end;i++){
            if(inorder[i]==postorder[root_index])
                break;
        }
        int right_size=end-i;
        int left_size=i-start;
        if(right_size>0)    root.right=subTree(root_index-1,postorder,inorder,i+1,end);
        if(left_size>0)     root.left=subTree(root_index-1-right_size,postorder,inorder,start,i-1);
        return root;
        
    }
    
}