/*Design an algorithm to find the kth number such that the only prime factors 
are 3,5, and 7*/
class test{
	public static int kthNum(int input){
		if (input==0)
			return 1;
		if (input==1)
			return 3;
		if (input==2)
			return 5;
		if (input==3)
			return 7;
		if (input==4)
			return 15;
		if (input==5)
			return 21;
		if (input==6)
			return 35;
		if (input==7)
			return 105;

		else{
			int result=1;
			switch (input%7) {
				case 1:
					result=kthNum(input-1)*3;
					break;
				case 2:
					result=kthNum(input-2)*5;
					break;	
				case 3:
					result=kthNum(input-3)*7;
					break;
				case 4:
					result=kthNum(input-4)*15;
					break;	
				case 5:
					result=kthNum(input-5)*21;
					break;
				case 6:
					result=kthNum(input-6)*35;
					break;
				case 0:
					result=kthNum(input-7)*105;
					break;

			}	
			return result;
		}
	}
	public static void main(String [] args){
		int k=15;
		for (int i=0;i<k;i++)
			System.out.println("The "+i+"th number is "+kthNum(i));
	}
}