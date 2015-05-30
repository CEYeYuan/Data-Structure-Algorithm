/*Write a program to determine the number of bits you would need to flip to 
convert integer A to integer B
Example
Input:29   11101         
	  15   01111
Output:2

#### difference between logic shift and arithmatic shift
The signed left shift operator "<<" shifts a bit pattern to the left, and the 
signed right shift operator ">>" shifts a bit pattern to the right. The bit pattern
 is given by the left-hand operand, and the number of positions to shift by the 
 right-hand operand. The unsigned right shift operator ">>>" shifts a zero into the 
 leftmost position, while the leftmost position after ">>" depends on sign extension.
  */
class test{
	public static int flip(int a,int b){
		int x=a^b;
		int num=0;
		while(x!=0){
			if ((1&x)==1)
				num++;
			x=x>>>1;
		} 
		return num;
	}
	public static void main(String[] args){
		int a=31;
		int b=0;
		int numOfBits=flip(a,b);
		System.out.println(numOfBits+" of bits need get fliped");
	}
}