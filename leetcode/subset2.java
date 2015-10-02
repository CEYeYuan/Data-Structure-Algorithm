/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> cur=new ArrayList<Integer>();
        Arrays.sort(nums);
        recurse(nums,list,cur,0);
        return list;
    }
    
    
    private void recurse(int[]nums,List<List<Integer>> list,List<Integer> cur,int start){
        if(start>=nums.length){
            list.add(cur);
            return;
        }
 
            //check for each single number; it can occur in the list up to COUNT times
            int count=1;
            int j=start+1;
            while(j<nums.length){
                if(nums[j]==nums[start]){
                    count++;
                    j++;
                }
                else
                    break;
            }
            
            //System.out.println("count="+count+"j="+j);
            for (int choice=0;choice<=count;choice++){
                ArrayList<Integer> copy=new ArrayList<Integer> (cur);
                for(int k=0;k<choice;k++){
                    copy.add(nums[start]);
                }
                recurse(nums,list,copy,j);
            }
        
        
    }
}