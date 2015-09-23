/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        if(n==0)    return res;
        generate(res,1,n);
        return res;
    }
    
    private void generate(int[][] res,int cur,int remaining){
        int all=res.length;
        if(remaining==0)    return;
        if(remaining==1)    {
            res[all/2][all/2]=cur;
            return;
        }
        else{
            for(int i=0;i<remaining;i++){
                res[(all-remaining)/2][(all-remaining)/2+i]=cur;
                cur++;
            }
             for(int i=1;i<remaining-1;i++){
                res[(all-remaining)/2+i][all-1-(all-remaining)/2]=cur;
                cur++;
            }
            for(int i=0;i<remaining;i++){
                res[all-1-(all-remaining)/2][all-1-(all-remaining)/2-i]=cur;
                cur++;
            }
             for(int i=1;i<remaining-1;i++){
                res[all-1-(all-remaining)/2-i][(all-remaining)/2]=cur;
                cur++;
            }
            
        }
        generate(res,cur,remaining-2);
        
    }
}