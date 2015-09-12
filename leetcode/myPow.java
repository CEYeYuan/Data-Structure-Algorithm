/*
Implement pow(x, n).
*/
public class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        else if(n==1)
            return x;
        else if(n==-1)
            return 1/x;
        else if(n>0){
            double tmp=myPow(x,n/2);
            return n%2==0?tmp*tmp:tmp*tmp*x;
        }
           
        else{
            double tmp=myPow(x,n/2);
            return n%2==0?tmp*tmp:tmp*tmp/x;
        }
           
    }
}