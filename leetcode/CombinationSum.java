/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<List<Integer>> cur =new ArrayList<>();
        List<Integer> tmp=new ArrayList<Integer>();
        cur.add(tmp);
        Arrays.sort(candidates);
        recurse(result,target,candidates,cur,0);  
        return result;
    }
    
    private void recurse(List<List<Integer>> result,int target,int[]candidates,List<List<Integer>> cur,int start){
        
        if(target==0)  {
            for(List<Integer> tmp:cur)
                result.add(tmp);
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]<=target){
                 List<List<Integer>> copy=new ArrayList<>();
                 for(List<Integer> tmp:cur){
                     ArrayList<Integer> add=new ArrayList<Integer>(tmp);
                     add.add(candidates[i]);
                     copy.add(add);
                     recurse(result,target-candidates[i],candidates,copy,i);
                 }
            }
            else
                break;
        }
    }


    
}