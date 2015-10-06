/*
##################################
how to think things recursively?
If I already have the list of left subtrees and list of right subtrees,
what should I do?
Just make a permutation !
then add it to the root Node 


corner case : what if left and right are just null element ?
do not worry 
add null to the list is fine



##################################

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        return gene(1,n);
    }
    private List<TreeNode> gene(int start,int end){
        List<TreeNode> list=new ArrayList<TreeNode>();
        if(start>end)   {
            list.add(null);
            return list;
        }
        for(int root=start;root<=end;root++){
            List<TreeNode> leftsubtree=gene(start,root-1);
            List<TreeNode> rightsubtree=gene(root+1,end);
            for(TreeNode left:leftsubtree){
                for(TreeNode right:rightsubtree){
                    TreeNode r=new TreeNode(root);
                    r.left=left;
                    r.right=right;
                    list.add(r);
                }
            }
        }
        return list;
    }
    
}