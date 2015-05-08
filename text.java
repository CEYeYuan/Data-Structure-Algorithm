class test{
	public static int[] change_arr(int [] input){
		input[0]=2;
		return input;
	}
	public static void main(String[] args){
		int[] arr= {1};
		System.out.println(arr[0]);
		int[] new_arr=change_arr(arr);
		System.out.println(new_arr[0]);
		System.out.println(arr[0]);
	}

}