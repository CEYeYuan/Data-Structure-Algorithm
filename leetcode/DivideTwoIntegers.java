/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/
public class Solution {
    public int divide(int dividend,int divisor){
        if(divisor==1)
            return dividend;
        return divideLong(dividend,divisor);
    }
    private int divideLong(long dividend,long divisor) {
        if(dividend<0&&divisor<0)
            return divideLong(-dividend,-divisor);
        else if(dividend>0&&divisor<0){
                return -divideLong(dividend,-divisor);
        }
        else if(dividend<0&&divisor>0){
                return -divideLong(-dividend,divisor);
        }
           
        else{
           long tmp=divisor;
           long result=0;
           while(tmp+tmp<=dividend){
               tmp=tmp+tmp;
           }
           while(tmp!=divisor){
               if(dividend>=tmp){
                   dividend-=tmp;
                   result+=1;
               }
               tmp/=2;
               result*=2;
           }
           if(dividend>=tmp){
                result+=1;
           }
           if(result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
           if(result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
           return (int)result;
           
        }
    }
}