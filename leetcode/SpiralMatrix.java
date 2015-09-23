/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0)    return list;
        spiral(matrix,list,matrix.length,matrix[0].length);
        return list;
    }
    private void spiral(int[][]matrix,List<Integer> list,int m,int n){
        if(m==0||n==0)  return;
        if(m==1&&n==1){
            list.add(matrix[matrix.length/2][matrix[0].length/2]);
            return;
        }
        else if(n==1){
            for(int i=0;i<m;i++)
                list.add(matrix[i+(matrix.length-m)/2][matrix[0].length/2]);
            return;
        }
        else if(m==1){
            for(int i=0;i<n;i++)
                list.add(matrix[matrix.length/2][(matrix[0].length-n)/2+i]);
            return;
        }
        
        else{
            for(int i=0;i<n;i++)
                list.add(matrix[(matrix.length-m)/2][(matrix[0].length-n)/2+i]);
            for(int i=1;i<m-1;i++){
            	int row,col;
            	row=(matrix.length-m)/2+i;
            	col=matrix[0].length-1-(matrix[0].length-n)/2;
            	//System.out.println("row="+row+"col="+col);
            	int tmp=matrix[row][col];
                list.add(tmp);
            }
            for(int i=0;i<n;i++)
                list.add(matrix[matrix.length-1-(matrix.length-m)/2][matrix[0].length-1-(matrix[0].length-n)/2-i]);
            for(int i=1;i<m-1;i++)
                list.add(matrix[matrix.length-1-(matrix.length-m)/2-i][(matrix[0].length-n)/2]);
        
            spiral(matrix,list,m-2,n-2);
        }
    }
}