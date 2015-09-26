/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        recurse(list,cur,n,k,1);
        
        return list;
        
    }
    
    private void recurse(List<List<Integer>> list,List<Integer> cur,int n,int k,int start){
    	// how to prevent a invalid loop? record the largest element so far, and start from i+1
    	//also, for each level, the ceilling should be n-l+1
        if(k==0)    {
            list.add(cur);
            return;
        }
        if(start>n)
            return ;
        for(int i=start;i<=n-k+1;i++){
            ArrayList<Integer> copy=new ArrayList<Integer>(cur);
            copy.add(i);
            recurse(list,copy,n,k-1,i+1);
        }
    }
}