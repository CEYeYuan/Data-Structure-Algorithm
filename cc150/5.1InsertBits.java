/*You are given two 32-bits numbers, N and M, and two bit positions,i and j. Write
a method to insert M into N such that M starts at bit j and ends at bit i. You can
assume that the bits j through i have enough space to fit all of M. That is, if 
M=10011, you can assume that there are at least 5 bits between j and i. You would not,
for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
Example
Input: N=10000000000 , M=10011, i=2, j=6
Output:N=10001001100
Bit manipulation:
& AND   | OR   ^ XOR   ~NOT
int x=0b101;
int y=0b110;
System.out.println(Integer.toBinaryString(x) + "+" + Integer.toBinaryString(y)
         + "=" + Integer.toBinaryString(z));
*/
class InsertBits{
	//1. construct a mask which is 0 from start to end, while other digits are 1
	public static int insert(int dest,int source,int start,int end){
		int mask_1=~0<<(end+1); //11111100000
		int mask_2=~0>>(32-start); //00000000011 
		int mask=mask_2|mask_1;
		int set=source<<(start);
		return dest&mask|set;
	} 
	public static void main(String[] args){
		int x=1<<31;
		int y=0b10011;
		int start=5;
		int end=10;
		int result=insert(x,y,start,end);
		System.out.println(Integer.toBinaryString(result));
	}
}