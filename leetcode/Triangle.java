/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        for(int i=size-2;i>=0;i--){
        	//bottom up approach is much easier!
            List<Integer> l1=triangle.get(i+1);
            List<Integer> l2=triangle.get(i);
            for(int j=0;j<l2.size();j++){
                int tmp=l2.get(j);
                int min=Math.min(l1.get(j),l1.get(j+1));
                tmp+=min;
                l2.set(j,tmp);
            }
        }
        return triangle.get(0).get(0);
    }
}