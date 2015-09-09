/*Write a program to swap odd and even bits in an integer with as few instructions
as possible(e.g.,bit 0 and bit 1 are swapped,bit 2 and bits 3 are swapped, and so on.
binary number : begin with 0b
hexical number: begin with 0x
*/
class test{
	public static int swap(int input){
		int mask=0xaaaa;//101010...extract the even digits
		int even= mask&input;
		int odd=(mask>>>1)&input;
		int even_shifted=even>>>1;
		int odd_shifted=odd<<1;
		int result=even_shifted|odd_shifted;
		return result;
	}
	public static void main(String[] args){
		int a=0b101;
		System.out.println("After swap,"+a+" becomes "+swap(a));

	}
}