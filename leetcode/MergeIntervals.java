/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare (Interval i1,Interval i2){
                return Integer.compare(i1.start,i2.start);
            }
        });
        LinkedList<Interval> ret=new LinkedList<Interval>();
        if(intervals.size()<=1)     return intervals;
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(Interval i:intervals){
            if(i.start<=end){
                //can merge
                end=Math.max(end,i.end);
            }
            else{
                Interval tmp=new Interval(start,end);
                ret.add(tmp);
                start=i.start;
                end=i.end;
            }
        }
        ret.add(new Interval(start,end));
        return ret;
        
    }
}
*/