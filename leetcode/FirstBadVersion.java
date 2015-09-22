/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return findBinarySearch(1,n);
    }
    private int findBinarySearch(int low,int high){
        int mid=low+(high-low)/2;
        if(!isBadVersion(high))     return high+1;
        if(low>=high){
            if(isBadVersion(low))   return low;
            else    return low+1;
        }
        if(isBadVersion(mid))   return findBinarySearch(low,mid-1);
        else    return findBinarySearch(mid+1,high);
    }
}