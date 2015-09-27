/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> list=new ArrayList<>();
       List<Integer> cur=new ArrayList<Integer>();
       for(int i=0;i<=nums.length;i++){
           recurse(list,cur,i,0,nums.length-i,nums);
       }
       return list;
    }
    
    private void recurse(List<List<Integer>> list,List<Integer> cur,int num,int start,int end,int[] nums){
        if(num==0){
            list.add(new ArrayList<Integer>(cur));
            return ;
        }
        if(start>=nums.length)  return;
        for(int i=start;i<=end;i++){
            cur.add(nums[i]);
            recurse(list,cur,num-1,i+1,end+1,nums);
            cur.remove(cur.size()-1);
        }
        
    }    
}