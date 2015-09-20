/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> ret=new HashSet<ArrayList<Integer>>();;
        List<List<Integer>> list=new ArrayList<>();
        if(nums==null||nums.length==0)  return list;
        ArrayList<Integer> cur=new ArrayList<Integer>();
        cur.add(nums[0]);
        set.add(cur);
        for(int i=1;i<nums.length;i++){
            for( ArrayList<Integer> tmp:set){
                for(int j=0;j<=tmp.size();j++){
                    ArrayList<Integer> tmpcopy=new ArrayList<Integer>(tmp);
                    tmpcopy.add(j,nums[i]);
                    ret.add(tmpcopy);
                }
            }
            set=ret;
            ret=new HashSet<ArrayList<Integer>>();
        }
        for( ArrayList<Integer> tmp:set){
            list.add(tmp);
        }
        return list;
    }
}