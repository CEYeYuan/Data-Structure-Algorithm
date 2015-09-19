/*

####
1.insert the first element
2.for every permutation, insert the second element at every possible index
3.for every permutation, insert the third element at each possible position
####

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].	
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums==null||nums.length<=0)  return list;
        ArrayList<Integer> first=new ArrayList<Integer>();
        first.add(nums[0]);
        list.add(first);
        for (int i=1;i<nums.length;i++){
            List<List<Integer>> newlist=new ArrayList<List<Integer>>();
            for(List<Integer> ele:list){
                int size=ele.size();
                for(int j=0;j<=size;j++){
                    ArrayList<Integer> tmp=new  ArrayList<Integer>(ele);
                    tmp.add(j,nums[i]);
                    newlist.add(tmp);
                }
                
            }
            list=newlist;
        }
        return list;
    }   
}