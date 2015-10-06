/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class Solution {
/* # of trees has nothing to do with the start/end value, but only the difference or ## matters! */
    public int numTrees(int n) {
        int [] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        return num(n,arr);
    }
    private int num(int n,int[] arr){
        if(arr[n]!=0)   return arr[n];
        if(n<0) return 0;
        else{
            int sum=0;
            for(int i=1;i<=n;i++){
                int left=arr[i-1]!=0?arr[i-1]:num(i-1,arr);
                int right=arr[n-i]!=0?arr[n-i]:num(n-i,arr);
                sum+=left*right;
            }
            arr[n]=sum;
            return sum;
        }
    }
    
    
}