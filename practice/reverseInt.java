public class Solution {
    public int reverse(int x) {
         
        
             int ret=0;
             while(x!=0){
                 int tmp=ret;
                 int add=x%10;
                 ret=ret*10+x%10;
                 x=x/10;
                 if((ret-add)/10!=tmp)
                    return 0;
             }
             return ret;
         
    }
}