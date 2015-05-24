/*Given a positive integer, print the next smallest and the next largest number that 
that have the same nuber of 1 bits in their binary representation.*/
class sameDigits{
	public static void printNext(int input){
		int numOf1=0;
		int binary=1<<30;
		while (true){
			if (input!=0&& binary!=0){
				//System.out.println("input is "+input+" while binary is "+binary);
				if (input>=binary){
					input-=binary;
					numOf1++;
				}
				binary/=2;
			}
			else{
				break;
			}	
		}
		int nextSmallest,nextLargest;
		nextSmallest=(~0>>>(32-numOf1-1))^1;
		nextLargest=~0<<(32-numOf1-1)&(~(1<<31));
		System.out.println("The input number contains "+numOf1+" one digits, the nextSmallest ");
		System.out.println("number is "+nextSmallest+" or "+Integer.toBinaryString(nextSmallest));
		System.out.println("the next largest number number is "+Integer.toBinaryString(nextLargest));
		System.out.println("the real largest number number is "+Integer.toBinaryString(1<<31));
	}
	public static void main(String[] args){
		printNext(31);
	}
			
}