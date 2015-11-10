/*
Given preorder and inorder traversal of a tree, construct the binary tree.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subTree(preorder,0,inorder,0,inorder.length-1);
    }
    
    private TreeNode subTree(int[] preorder,int root_index,int[] inorder, int start,int end){
        //both start and end are inclusive
        /*
        preorder: this->left->right
        inorder: left->this->root
        preorder always meet the root of a subtree, while we can do a partition for inorder, then we 
        solve the left-subtree and right-subtree recursively
        */
        if(root_index>=preorder.length)
            return null;
        else{
            TreeNode root=new TreeNode(preorder[root_index]);
            int i=-1;
            for(i=start;i<=end;i++){
                if(inorder[i]==preorder[root_index])
                    break;
            }
            if(i==-1)
                return root;
            int left_size=i-start;
            if(i-1-start>=0&&end-i-1>=0){
                //left and subtree exist
                root.left=subTree(preorder,root_index+1,inorder,start,i-1);
                root.right=subTree(preorder,root_index+left_size+1,inorder,i+1,end);
            }
            else{
                if(i-1-start>=0){
                     root.left=subTree(preorder,root_index+1,inorder,start,i-1);
                     root.right=null;
                }
                if(end-i-1>=0){
                    root.right=subTree(preorder,root_index+1,inorder,i+1,end);
                    root.left=null;
                }
                    
            }
            return root;
        }
    }
    
    
}