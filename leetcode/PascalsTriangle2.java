/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<Integer>();
        if(rowIndex==0) {
            list.add(1);
            return list;
        }
        if(rowIndex==1){
            list.add(1);
            list.add(1);
            return list;
        }
        else{
            List<Integer> last=getRow(rowIndex-1);
            list.add(1);
            for(int i=1;i<rowIndex;i++){
                list.add(last.get(i-1)+last.get(i));
            }
            list.add(1);
            return list;
        }
    }
}