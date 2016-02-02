/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/
public class Solution {
    public int countPrimes(int n) {
        if(n<2)
            return 0;
        boolean[] arr=new boolean[n];
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i<n;i++)
            arr[i]=true;
        //assume all # are prime
        for(int i=2;i*i<n;i++){
            if(arr[i]==false)//composite skip
                continue;
            else{
                for(int j=i*2;j<n;j+=i){
                    arr[j]=false;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==true)
                count++;
        }
        return count;
        
    }
}