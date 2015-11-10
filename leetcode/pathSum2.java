/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        if(root==null)  return result;
        generate(root,sum,result,tmp,0);
        return result;
    }
    
    private void generate(TreeNode root, int sum,List<List<Integer>> ret,ArrayList<Integer> tmp,int cur){
        if(root==null){
            //exception 
            return;
        }   
        else if(root.left==null&&root.right==null){
            //child node
            cur+=root.val;
            if(sum==cur){
                tmp.add(root.val);
                ret.add(tmp);
            }
        }
        else{
            //non-child
            if(root.left!=null){
                ArrayList<Integer> copy1=new ArrayList<Integer>(tmp);
                copy1.add(root.val);
                generate(root.left,sum,ret,copy1,cur+root.val);
            }
            if(root.right!=null){
                ArrayList<Integer> copy2=new ArrayList<Integer>(tmp);
                copy2.add(root.val);
                generate(root.right,sum,ret,copy2,cur+root.val);
            }
        }
        
    }
}