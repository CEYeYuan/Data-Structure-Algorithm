/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
     static ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
       
     /*we create a tree structure first, then as we go through the inorder traversal, we change the 
     treenode value one by one */
         cur =head;
         int count=count(head);
         TreeNode root=gen(count);
         fill(root);
         return root;
    }
    
    private TreeNode gen(int size){
        if(size==0)     return null;
        TreeNode left=gen(size/2);
        TreeNode root=new TreeNode(0);
        root.right=gen(size-1-size/2);
        root.left=left;
        return root;
    }
    
    private void fill(TreeNode root){
        if(root==null)  return ;
        else if(root.left!=null)
            fill(root.left);
        root.val=cur.val;
        cur=cur.next;
        if(root.right!=null)
            fill(root.right);
    }
    
    private int count(ListNode head){
        int i=0;
        while(head!=null){
            head=head.next;
            i++;
        }
        return i;
    }
}