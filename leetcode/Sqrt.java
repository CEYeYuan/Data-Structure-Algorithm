/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int mySqrt(int x) {
        return binarySearch(x,0,x);
    }
    private int binarySearch(int target,int low,int high){
        if(low>=high){
            if(low*low<=target) return low;
            else    return  low-1 ;
        }
        int mid=(low+high)/2;
        if(mid*mid==target) return mid;
        else if(1l*mid*mid<target) return binarySearch(target,mid+1,high);
        else    return binarySearch(target,low,mid-1);
    }
}