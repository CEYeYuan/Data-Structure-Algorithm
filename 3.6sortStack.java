/*Write a program to sort a stack in ascending order(with biggest items on top). 
You may use at most one additional stack to hold items, but you may not copy the 
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty 

This algorithm is like an insertion sort. We start with s2 empty. And pop s1, use
a tempery buffer to store that value, and we search s2 for the correct position and
then push that value in.*/
class sortStack{
	public static void main (String [] args){
		Stack stack = new Stack();
		stack.push(-1);
		stack.push(7);
		stack.push(1);
		stack.push(4);
		stack.push(3);
		stack.push(7);
		stack.push(1);
		stack.push(7);

		stack=sort(stack);
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

	public static  Stack sort(Stack input){
		Stack buffer =new Stack();
		int back=0;
		while (!input.isEmpty()){
			int value=input.pop();
			if (buffer.isEmpty())
				buffer.push(value);
			else{
				if (value>= buffer.peek())
					buffer.push(value);
				else{
					while (value< buffer.peek() && (!buffer.isEmpty())){
						input.push(buffer.pop());
						back++;
					}
					buffer.push(value);
					for (int i=0;i<back;i++){
						buffer.push(input.pop());
					}
					back=0;
				}

			}
		}
		return buffer;
	}
}