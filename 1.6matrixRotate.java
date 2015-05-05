/*Given an image represented by an N*N matrix, where each pixel in the image 4
by bytes, write a method to rotate the image by 90 degrees. Can you do this in 
place
*/
/*
array dimension review:
		int[][] foo = new int[][] {
        new int[] { 1, 2, 3 },
        new int[] { 1, 2, 3, 4},
    };

    System.out.println(foo.length); //2
    System.out.println(foo[0].length); //3
    System.out.println(foo[1].length); //4


    int [][] original=new int[][]{
		{1,2,3},
		{4,5,6},
	};
		System.out.println(original.length);  //2
		System.out.println(original[0].length);  //3



	int [][] original=new int[2][3];
		System.out.println(original.length); //2
		System.out.println(original[0].length); //3
	
	0 0 0 
	0 0 0 

*/
import java.util.*;
class matrixRotate{
	public static void main(String[] args){
	/*	int [][] original=new int[][]{
			{1,2,3,4},
			{4,5,6,7},
			{7,8,9,10},
			{10,11,12,13}
		};
	*/
		/*int [][] original=new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};*/
		int [][] original=new int[][]{
			{1,2,3,4,5},
			{4,5,6,7,8},
			{7,8,9,10,11},
			{10,11,12,13,14},
			{13,14,15,16,17}
		};

		for (int i=0;i<original.length;i++){
			for (int j=0;j<original[1].length;j++){
				System.out.print(original[i][j]+"  ");
			}
				System.out.print("\n");
		}

		System.out.println("\n");
		rotate(original);
		for (int i=0;i<original.length;i++){
			for (int j=0;j<original[1].length;j++){
				System.out.print(original[i][j]+"  ");
			}
				System.out.print("\n");
		}

	}

	/*
		summary:row on the top->coloumn on the left reverse
				coloumn on the left->row at the bottom
				row at the bottom->coloumn on the right reverse
				coloumn on the right->row on the top
	*/

	public  static int[][] rotate(int[][] input){
		int layer=input.length/2;
		int length=input.length;
		for (int i=0;i<layer;i++){

			int[] rowTop=new int[length-2*i];
			int[] rowBottom=new int[length-2*i];
			int[] coloumnLeft=new int[length-2*i];
			int[] coloumnRight=new int[length-2*i];
			//copy over the four edges of the matrix
			for (int j=0;j<length-2*i;j++){
				rowTop[j]=input[i][length-1-i-j];
				//System.out.print(rowTop[j]);
				rowBottom[j]=input[length-1-i][length-1-i-j];
				//System.out.print(rowBottom[j]);
				coloumnLeft[j]=input[i+j][i];
				//System.out.print(coloumnLeft[j]);
				coloumnRight[j]=input[i+j][length-1-i];
				//System.out.print(coloumnRight[j]);
			}
			//System.out.println("\n");
			for (int j=0;j<length-2*i;j++){
				input[i][j+i]=coloumnRight[j];
				input[length-1-i][j+i]=coloumnLeft[j];
				//System.out.println(rowTop[j]);
				input[j+i][i]=rowTop[j];
				//input[1][0]=3;
				input[j+i][length-1-i]=rowBottom[j];
			}
		

		}
		return input;
	}
}