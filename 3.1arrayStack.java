/*Describe how you would use a single array to implement three stacks*/
class arrayStack{
	Object[] stacks=new Object[100];
	int pointer1=0;
	int pointer2=1;
	int pointer3=2;
	public void push1(Object input){
		stacks[pointer1]=input;
		pointer1+=3;
	}
	public void push2(Object input){
		stacks[pointer2]=input;
		pointer2+=3;
	}
	public void push3(Object input){
		stacks[pointer3]=input;
		pointer3+=3;
	}

	public Object pop1(){
		if(pointer1-3<0)
			return null;
		else{
			Object result=stacks[pointer1-3];
			stacks[pointer1-3]=null;
			pointer1-=3;
			return result;
		}
	}

	public Object pop2(){
		if(pointer1-3<1)
			return null;
		else{
			Object result=stacks[pointer2-3];
			stacks[pointer2-3]=null;
			pointer2-=3;
			return result;
		}
	}

	public Object pop3(){
		if(pointer3-3<2)
			return null;
		else{
			Object result=stacks[pointer3-3];
			stacks[pointer3-3]=null;
			pointer3-=3;
			return result;
		}
	}

	public Object peek1(){
		if(pointer1-3<0)
			return null;
		else{
			return stacks[pointer1-3];
		}

	}
	public Object peek2(){
		if(pointer2-3<1)
			return null;
		else{
			return stacks[pointer2-3];
		}
	}

	public Object peek3(){
		if(pointer3-3<2)
			return null;
		else{
			return stacks[pointer3-3];
		}
	}

	public static void main(String args[]){
		arrayStack stacks=new arrayStack();
		stacks.push1(1);
		stacks.push1(2);
		stacks.push1(3);
		stacks.push2(2);
		stacks.push3(3);
		System.out.println(stacks.peek1());
		System.out.println(stacks.peek1());
		System.out.println(stacks.pop1());
		System.out.println(stacks.pop2());
		System.out.println(stacks.pop3());
		System.out.println(stacks.pop1());
	}
}