/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> set=new HashSet<>();
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<Integer>();
        Arrays.sort(candidates);
        recurse(set,candidates,target,res,0);
        for(List<Integer> tmp:set){
            list.add(tmp);
        }
        return list;
    }
    private void recurse(HashSet<List<Integer>> set,int[]candidates,int target,List<Integer> tmp,int start){
      //  System.out.println("We start at start point="+start+" and now the target is "+target);
        if(target==0)   set.add(tmp);
        else{
                for(int i=start;i<candidates.length;i++){
                    if(candidates[i]<=target){
                         ArrayList<Integer> copy=new ArrayList<Integer>(tmp);
                         copy.add(candidates[i]);
                         //System.out.println("i="+i+" candidates["+i+"]="+candidates[i]);
                         recurse(set,candidates,target-candidates[i],copy,i+1); 
                    }
                    else{
                       // System.out.println("failed");
                        break;
                    }
                }
        }
    }
}
