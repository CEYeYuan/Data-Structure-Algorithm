/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)      return null;
        return bst(nums,0,nums.length-1);
    }
    private TreeNode bst(int[] nums,int start,int end){
        if(start>end)   return null;
        else if(start==end) return new TreeNode(nums[start]);
        else{
            int mid=(start+end)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=bst(nums,start,mid-1);
            root.right=bst(nums,mid+1,end);
            return root;
        }
        
    }
}