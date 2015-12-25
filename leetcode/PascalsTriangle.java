/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<>();
        if(numRows==0)  return pascal;
        for(int row=1;row<=numRows;row++){
            List<Integer> list=new ArrayList<Integer>();
            list.add(1);
            for(int i=1;i<row-1;i++){
                list.add(pascal.get(pascal.size()-1).get(i-1)+pascal.get(pascal.size()-1).get(i));
            }
            if(row!=1)
                list.add(1);
            pascal.add(list);
        }
        return pascal;
    }
}