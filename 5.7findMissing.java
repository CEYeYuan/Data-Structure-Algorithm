/*An  array A contains all the integers from 0 to n, except for one number which 
is missing. In this problem, we cannot access an entire integer in A with a single 
operation. The elments of A are represented in binary, and the only operation we can
use to access them is "fetch" the jth bit of A[i]",which takes constant time. write
code to find the missing integer. Can you do it in O(n) time ?
--- if we can get access to all the elements, we can just sum them all up, then use
Gauss's theorem, substract the total value, then we can get the missing number 
immediately, this takes O(n) time
--- Alternatively we can still add up all the digits to get the original value, which
will take log(n)n time
---The best approach is we get the number  digit by digit, first get the least significant
 digtits by sum up all the lowest digits; then second least blabla until we got the 
 most significant digit. This takes n+1/2*n+1/4*n... which is linear time  */
 class test{
 	public static int findBit(int input,int digit){
 		// if digit==1, return the least significant bit
 		int mask=1;
 		mask=mask<<(digit-1);
 		return mask&input;
 	}
 	public static int getNumDigits(int input){
 		// return how many digits an integer owns
 		int i=0;
 		while (input!=0){
 			input/=2;
 			i++;
 		}
 		return i;
 	}

 	public static int findMissing(int[] input,int n){
 		int digtits=getNumDigits(n);
 		int result=0;
 		int lastDigit=0;
 		for (int i=1;i<=digtits;i++){
 			int sum=0;
 			for(int j=;j<input.length;j+=(1<<(i-1))){
 				sum+=findBit(input[j],i);
 			}
 			if (n%(1<<i)==0 && (sum&1)==0){
 				result+=1<<(i-1);
 				lastDigit=1;
 			}
 			else if (n%(1<<i)==1 && (sum&1)==0){
 				result+=1<<(i-1);
 				lastDigit=1;
 			}
 			else
 				lastDigit=0;
 		}
 		return result;

 	}
 	public static void main (String[] args){
 		int[] arr=new int[]{0,1,2,4,3,5,6,7,8,10};
 		int result=findMissing(arr,10);
 		System.out.println("The missing element in that array is "+result);
 	}
 }
