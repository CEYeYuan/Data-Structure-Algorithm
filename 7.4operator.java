/*Write methods to implement the multiply, subtract, and divide operations for 
integers. Use only the add operator.*/
class Operation{
	//return  -x
	public static int flip (int  input){
		if (input==0)
			return 0;
		else if (input<0){
			return ~input+1;
		}else{
			int minus1=~0;
			return ~(input+(minus1));
		}
	}
	public static int  subtract(int a,int b){
		return a+flip(b);
	}


	public static int multiply(int a,int b){
		if (b<0){
			return flip(multiply(a,-b));
		}
		int result=0;
		for (int i=1;i<=b;i++){
			result+=a;
		}
		return result;
	}

	public static int divide(int a, int b){
		if (a==0){
			return 0;
		}
		if (a<0 && b<0){
			return divide(-a,-b);
		}
		if (a<0&&b>0){
			return flip(divide(-a,b));
		}
		if (b<0&&a>0){
			return flip(divide(a,-b));
		}
		int result=0;
		while(a>=b){
			result+=1;
			a+=flip(b);
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println(divide(13,-5));
	}
}