/*A child is running up a staircase with n steps, and can hop either 1 step, 2
steps or 3 steps at a time. Implement a method to count how many possible ways
the child can run up the stairs.*/
class test{
	public static int getNum(int n){
		if (n<=0){
			return 0;
		}
		else if (n==1){
			return 1;
		}
		else if (n==2){
			return 2;
		}
		else if (n==3){
			return 3;
		}
		else{
			return getNum(n-1)+2*getNum(n-2)+3*getNum(n-3);
		}


	}
	public static void main(String[] args){
		int n=5;
		int result=getNum(n);
		System.out.println("There're "+result+" ways to run up the staircase");
	}
}