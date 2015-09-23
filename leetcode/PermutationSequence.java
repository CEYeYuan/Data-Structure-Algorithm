/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer buffer=new StringBuffer();
        boolean[] arr=new boolean[n+1];
        get(buffer,n,k-1,arr);
        //switch to zero based for simplification
        return buffer.toString();
    }
    
    private void get(StringBuffer buffer,int numOfDigits,int k,boolean[] arr){
        if(numOfDigits==0)  return;
        int ref=factorial(numOfDigits-1);
        int index=k/ref+1;
        for(int i=1;i<arr.length;i++){
            if(!arr[i])     index--;
            if(index==0){
                arr[i]=true;
                buffer.append(i);
                break;
            }
        }
        get(buffer,numOfDigits-1,k%ref,arr);
      
        
    }
    
    private int factorial(int n){
        if(n==0)    return 1;
        if(n==1)    return 1;
        else{
            int res=1;
            for(int i=n;i>=1;i--){
                res*=i;
            }
            return res;
        }
    }
}